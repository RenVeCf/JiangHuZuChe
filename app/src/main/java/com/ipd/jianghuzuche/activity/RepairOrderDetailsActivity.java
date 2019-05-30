package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

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

    private List<RepairDetailsBean.DataBean.CostListBean> repairDetailsBean;
    private RepairDetailsAdapter repairDetailsAdapter;
    private int orderId;
    private String storePath = "";

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
        goToBaiduMap(storePath);
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
//        Intent intent = new Intent();
//        intent.setData(Uri.parse("baidumap://map/direction?destination=latlng:"
//                + latitude + ","
//                + longitude + "|name:" + descAddress + // 终点
//                "&mode=riding" + // 导航路线方式
//                "&coord_type=bd09ll" + // 坐标系
//                "&src=" + getPackageName()));
//        startActivity(intent); // 启动调用
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

        storePath = data.getData().getOrder().getDescAddress();
        tvStoreName.setText(data.getData().getOrder().getStoreName());
        tvStorePath.setText("地址：" + storePath);

        repairDetailsBean.clear();
        repairDetailsBean.addAll(data.getData().getCostList());
        repairDetailsAdapter.setNewData(repairDetailsBean);
//        tvBasicServiceCharges.setText("20元");
//        tvCarBodyMaintenanceFee.setText("40元");
//        tvBatteryMaintenance.setText("100元");
//        tvChargingMonth.setText("20元");
//        tvRepairCouponName.setText("满100减5元");
//        tvRepairCouponMoney.setText("-5元");
        double money = 0;
        for (int i = 0; i < repairDetailsBean.size(); i++) {
            money += repairDetailsBean.get(i).getMoney();
        }
        tvRepairMoneySum.setText(money + "元");
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
