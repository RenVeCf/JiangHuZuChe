package com.ipd.jianghuzuche.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.CarPhotoAdapter;
import com.ipd.jianghuzuche.adapter.VehicleConditionAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.CancelOrderBean;
import com.ipd.jianghuzuche.bean.GetCarBean;
import com.ipd.jianghuzuche.bean.SelectVehicleBean;
import com.ipd.jianghuzuche.common.view.DividerItemDecoration;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.SelectVehicleContract;
import com.ipd.jianghuzuche.presenter.SelectVehiclePresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

/**
 * Description ：查看车辆
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/6.
 */
public class SelectCarActivity extends BaseActivity<SelectVehicleContract.View, SelectVehicleContract.Presenter> implements SelectVehicleContract.View {

    @BindView(R.id.tv_select_car_top)
    TopView tvSelectCarTop;
    @BindView(R.id.ll_car_contract)
    LinearLayout llCarContract;
    @BindView(R.id.bt_cancel_pay)
    Button btCancelPay;
    @BindView(R.id.bt_get_car)
    Button btGetCar;
    @BindView(R.id.rv_select_car)
    RecyclerView rvSelectCar;
    @BindView(R.id.rv_car_photo)
    RecyclerView rvCarPhoto;
    @BindView(R.id.tv_car_code)
    TextView tvCarCode;

    private VehicleConditionAdapter vehicleConditionAdapter;
    private CarPhotoAdapter carPhotoAdapter;
    private List<SelectVehicleBean.DataBean.VehicleOrstatusBean> vehicleOrstatusBean;
    private SelectVehicleBean.DataBean.VehiclePicBean vehiclePicBean;
    private List<String> imgList;
    private int orderId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_car;
    }

    @Override
    public SelectVehicleContract.Presenter createPresenter() {
        return new SelectVehiclePresenter(this);
    }

    @Override
    public SelectVehicleContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvSelectCarTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSelectCar.setLayoutManager(layoutManager);
        rvSelectCar.setNestedScrollingEnabled(false);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvSelectCar.setHasFixedSize(true);
        rvSelectCar.setItemAnimator(new DefaultItemAnimator());

        GridLayoutManager NotUseList = new GridLayoutManager(this, 4);
        rvCarPhoto.setLayoutManager(NotUseList);
        rvCarPhoto.addItemDecoration(new DividerItemDecoration(this));
        rvCarPhoto.setNestedScrollingEnabled(false);
        rvCarPhoto.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvCarPhoto.setItemAnimator(new DefaultItemAnimator()); //默认动画

        orderId = getIntent().getIntExtra("order_id", 0);
        vehicleOrstatusBean = new ArrayList<>();
        vehiclePicBean = new SelectVehicleBean.DataBean.VehiclePicBean();

        vehicleConditionAdapter = new VehicleConditionAdapter(vehicleOrstatusBean);
        rvSelectCar.setAdapter(vehicleConditionAdapter);

        imgList = new ArrayList<>();
        carPhotoAdapter = new CarPhotoAdapter(imgList);
        rvCarPhoto.setAdapter(carPhotoAdapter);
    }

    @Override
    public void initListener() {
        carPhotoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BigImageActivity.launch(SelectCarActivity.this, imgList.get(position));
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> unpaidCancelOrderMap = new TreeMap<>();
        unpaidCancelOrderMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        unpaidCancelOrderMap.put("orderId", orderId + "");
        getPresenter().getSelectVehicle(unpaidCancelOrderMap, false, false);
    }

    private void setDocumentsReceivedDialog() {
        final TextView tv;
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_center, null);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText("是否取消订单？");

        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickUtil.isFastClick()) {
                    TreeMap<String, String> selectCarCancelOrderMap = new TreeMap<>();
                    selectCarCancelOrderMap.put("userId", SPUtil.get(SelectCarActivity.this, USER_ID, "") + "");
                    selectCarCancelOrderMap.put("orderId", orderId + "");
                    getPresenter().getSelectCarCancelOrder(selectCarCancelOrderMap, false, false);
                    mCameraDialog.dismiss();
                }
            }
        });

        root.findViewById(R.id.dialog_center_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = 700;
        root.measure(0, 0);
        lp.height = 320;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    @OnClick({R.id.ll_car_contract, R.id.bt_cancel_pay, R.id.bt_get_car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_car_contract:
                startActivity(new Intent(this, WebViewActivity.class).putExtra("h5Type", 2));
                break;
            case R.id.bt_cancel_pay:
                setDocumentsReceivedDialog();
                break;
            case R.id.bt_get_car:
                if (isClickUtil.isFastClick()) {
                    TreeMap<String, String> getCarMap = new TreeMap<>();
                    getCarMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                    getCarMap.put("orderId", orderId + "");
                    getPresenter().getGetCar(getCarMap, false, false);
                }
                break;
        }
    }

    @Override
    public void resultSelectVehicle(SelectVehicleBean data) {
        vehicleOrstatusBean.clear();
        vehicleOrstatusBean.addAll(data.getData().getVehicleOrstatus());
        vehicleConditionAdapter.setNewData(vehicleOrstatusBean);
        if (data.getData().getVehicleOrstatus().size() <= 0) {
            //空数据时的页面
            setContentView(R.layout.null_select_car);

            TopView tvNullSelectCarTop = findViewById(R.id.tv_null_select_car_top);
            //防止状态栏和标题重叠
            ImmersionBar.setTitleBar(this, tvNullSelectCarTop);
        } else {
            vehiclePicBean = data.getData().getVehiclePic();
            tvCarCode.setText(vehiclePicBean.getPlateNumber());
            String[] strs = vehiclePicBean.getPicPath().split(",");
            for (int i = 0, len = strs.length; i < len; i++) {
                imgList.add(strs[i].toString());
            }
            carPhotoAdapter.setNewData(imgList);
        }
    }

    @Override
    public void resultGetCar(GetCarBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            ApplicationUtil.getManager().finishActivity(MainActivity.class);
            startActivity(new Intent(this, MainActivity.class).putExtra("howPage", 1));
            finish();
        }
    }

    @Override
    public void resultSelectCarCancelOrder(CancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            ApplicationUtil.getManager().finishActivity(MainActivity.class);
            startActivity(new Intent(this, MainActivity.class).putExtra("howPage", 1));
            finish();
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
