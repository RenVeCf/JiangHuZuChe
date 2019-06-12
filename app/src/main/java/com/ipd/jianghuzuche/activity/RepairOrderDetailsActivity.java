package com.ipd.jianghuzuche.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.RepairDetailsAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.RepairDetailsBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.RepairDetailsContract;
import com.ipd.jianghuzuche.presenter.RepairDetailsPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;
import static com.ipd.jianghuzuche.utils.ExchangeMapUtil.BD2GCJ;


/**
 * Description ：维修订单详情
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/7.
 */
public class RepairOrderDetailsActivity extends BaseActivity<RepairDetailsContract.View, RepairDetailsContract.Presenter> implements RepairDetailsContract.View {

    @BindView(R.id.tv_repair_order_details_top)
    TopView tvRepairOrderDetailsTop;
    @BindView(R.id.iv_user_confirmation_order)
    ImageView ivUserConfirmationOrder;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_go_choice_store)
    TextView tvGoChoiceStore;
    @BindView(R.id.tv_store_path)
    TextView tvStorePath;
    @BindView(R.id.tv_repair_money_sum)
    TextView tvRepairMoneySum;
    @BindView(R.id.rv_repair_details)
    RecyclerView rvRepairDetails;
    @BindView(R.id.tv_coupon_name)
    TextView tvCouponName;
    @BindView(R.id.tv_coupon_money)
    TextView tvCouponMoney;

    private RepairDetailsBean.DataBean.OrderBean orderBean = new RepairDetailsBean.DataBean.OrderBean();
    private RepairDetailsBean.DataBean.StoreBean storeBean = new RepairDetailsBean.DataBean.StoreBean();
    private List<RepairDetailsBean.DataBean.CostListBean> repairDetailsBean;
    private RepairDetailsAdapter repairDetailsAdapter;
    private int orderId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_repair_order_details;
    }

    @Override
    public RepairDetailsContract.Presenter createPresenter() {
        return new RepairDetailsPresenter(this);
    }

    @Override
    public RepairDetailsContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvRepairOrderDetailsTop);

        orderId = getIntent().getIntExtra("order_id", 0);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRepairDetails.setLayoutManager(layoutManager);
        rvRepairDetails.setNestedScrollingEnabled(false);
        rvRepairDetails.setHasFixedSize(true);
        rvRepairDetails.setItemAnimator(new DefaultItemAnimator());

        repairDetailsBean = new ArrayList<>();
        repairDetailsAdapter = new RepairDetailsAdapter(repairDetailsBean);
        rvRepairDetails.setAdapter(repairDetailsAdapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        TreeMap<String, String> repairDetailsMap = new TreeMap<>();
        repairDetailsMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        repairDetailsMap.put("orderId", orderId + "");
        getPresenter().getRepairDetails(repairDetailsMap, true, false);
    }

    @OnClick(R.id.tv_go_choice_store)
    public void onViewClicked() {
        setMapDialog();
    }

    // 选择地图
    private void setMapDialog() {
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_map, null);
        root.findViewById(R.id.ll_baidu_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBaiduMap(orderBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.ll_gaode_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGaodeMap(storeBean.getLatitude(), storeBean.getLongitude(), orderBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.ll_tengxun_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTengxunMap(storeBean.getLatitude(), storeBean.getLongitude(), orderBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = 500;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    /**
     * 跳转高德地图
     */
    private void goToGaodeMap(String lat, String lon, String descAddress) {
        if (!isInstalled("com.autonavi.minimap")) {
            ToastUtil.showShortToast("请先安装高德地图客户端");
            return;
        }
        LatLng endPoint = BD2GCJ(new LatLng(Double.parseDouble(lat), Double.parseDouble(lon)));//坐标转换
        StringBuffer stringBuffer = new StringBuffer("amapuri://openFeature?featureName=").append("OnRideNavi");
        stringBuffer.append("&rideType=").append("bike")
                .append("&sourceApplication=").append("amap")
                .append("&lat=").append(endPoint.latitude)
                .append("&lon=").append(endPoint.longitude)
                .append("&dev=").append(0);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage("com.autonavi.minimap");
        startActivity(intent);
    }

    /**
     * 跳转腾讯地图
     */
    private void goToTengxunMap(String lat, String lon, String descAddress) {
        if (!isInstalled("com.tencent.map")) {
            ToastUtil.showShortToast("请先安装腾讯地图客户端");
            return;
        }
        LatLng endPoint = BD2GCJ(new LatLng(Double.parseDouble(lat), Double.parseDouble(lon)));//坐标转换
        StringBuffer stringBuffer = new StringBuffer("qqmap://map/routeplan?type=bike")
                .append("&tocoord=").append(endPoint.latitude).append(",").append(endPoint.longitude).append("&to=" + descAddress);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
        startActivity(intent);
    }

    /**
     * 跳转百度地图
     */
    private void goToBaiduMap(String descAddress) {
        if (!isInstalled("com.baidu.BaiduMap")) {
            ToastUtil.showShortToast("请先安装百度地图客户端");
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse("baidumap://map/direction?destination="
                + descAddress + // 终点
                "&mode=riding" + // 导航路线方式
                "&coord_type=bd09ll" + // 坐标系
                "&src=" + getPackageName()));
        startActivity(intent); // 启动调用
    }

    /**
     * 检测程序是否安装
     *
     * @param packageName
     * @return
     */
    private boolean isInstalled(String packageName) {
        PackageManager manager = this.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> installedPackages = manager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo info : installedPackages) {
                if (info.packageName.equals(packageName))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void resultRepairDetails(RepairDetailsBean data) {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + data.getData().getOrder().getLogo()).apply(new RequestOptions()).into(ivUserConfirmationOrder);
        orderBean = data.getData().getOrder();
        storeBean = data.getData().getStore();
        tvStoreName.setText(data.getData().getOrder().getStoreName());
        tvStorePath.setText("地址：" + orderBean.getDescAddress());

        repairDetailsBean.clear();
        repairDetailsBean.addAll(data.getData().getCostList());
        repairDetailsAdapter.setNewData(repairDetailsBean);
        tvCouponName.setText(orderBean.getCouponTitle());
        tvCouponMoney.setText("-" + orderBean.getCoupon() + "元");
        tvRepairMoneySum.setText(orderBean.getPayMoney() + "元");
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
