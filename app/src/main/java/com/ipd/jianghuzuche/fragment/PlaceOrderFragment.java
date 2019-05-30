package com.ipd.jianghuzuche.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.activity.ChoiceStoreActivity;
import com.ipd.jianghuzuche.activity.LoginActivity;
import com.ipd.jianghuzuche.activity.MainActivity;
import com.ipd.jianghuzuche.activity.SupplementInfoActivity;
import com.ipd.jianghuzuche.activity.UserSelectCarActivity;
import com.ipd.jianghuzuche.activity.WebViewActivity;
import com.ipd.jianghuzuche.base.BaseFragment;
import com.ipd.jianghuzuche.bean.HomeBean;
import com.ipd.jianghuzuche.common.config.IConstants;
import com.ipd.jianghuzuche.contract.PlaceOrderContract;
import com.ipd.jianghuzuche.presenter.PlaceOrderPresenter;
import com.ipd.jianghuzuche.utils.BDLocationUtils;
import com.ipd.jianghuzuche.utils.DateUtils;
import com.ipd.jianghuzuche.utils.LogUtils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ryane.banner.AdPageInfo;
import com.ryane.banner.AdPlayBanner;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.CITY;
import static com.ipd.jianghuzuche.common.config.IConstants.LATIUDE;
import static com.ipd.jianghuzuche.common.config.IConstants.LONGTITUDE;
import static com.ipd.jianghuzuche.common.config.IConstants.REQUEST_CODE_91;
import static com.ipd.jianghuzuche.common.config.IConstants.USE_CAR_TIME;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;
import static com.ryane.banner.AdPlayBanner.ImageLoaderType.GLIDE;

/**
 * Description ：在线下单
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/29.
 */
public class PlaceOrderFragment extends BaseFragment<PlaceOrderContract.View, PlaceOrderContract.Presenter> implements PlaceOrderContract.View {

    @BindView(R.id.ab_place_order)
    AdPlayBanner abPlaceOrder;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_reset_location)
    TextView tvResetLocation;
    @BindView(R.id.tv_car_store)
    TextView tvCarStore;
    @BindView(R.id.tv_get_car_time)
    TextView tvGetCarTime;
    @BindView(R.id.tv_use_car_time)
    TextView tvUseCarTime;
    @BindView(R.id.tv_charging_instruction)
    TextView tvChargingInstruction;
    @BindView(R.id.tv_select_car_store)
    TextView tvSelectCarStore;
    @BindView(R.id.bt_place_order)
    Button btPlaceOrder;

    private List<AdPageInfo> images;
    private List<String> listData;
    private OptionsPickerView pvOptions;
    private String storeId;
    //定位相关
    BDLocationUtils bdLocationUtils;
    private String mLatitude = "";
    private String mLongtitude = "";
    private MainActivity mainActivity;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_place_order;
    }

    @Override
    public PlaceOrderContract.Presenter createPresenter() {
        return new PlaceOrderPresenter(mContext);
    }

    @Override
    public PlaceOrderContract.View createView() {
        return this;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        mainActivity = (MainActivity) getActivity();
        mainActivity.tvTopTitle.setText(this.getResources().getString(R.string.jiang_hu_express_train));
        mainActivity.tvTopTitle.setTextColor(Color.BLACK);
    }

    @Override
    public void init() {
        mainActivity = (MainActivity) getActivity();
        mainActivity.tvTopTitle.setText(this.getResources().getString(R.string.jiang_hu_express_train));
        mainActivity.tvTopTitle.setTextColor(Color.BLACK);

        images = new ArrayList<>();

        bdLocationUtils = new BDLocationUtils(getActivity());
        bdLocationUtils.doLocation();//开启定位
        bdLocationUtils.mLocationClient.start();//开始定位
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        tvGetCarTime.setText(DateUtils.times1(Calendar.getInstance().getTimeInMillis()));
        getPresenter().getHome(true, false);

        bdLocationUtils.doLocation();//开启定位
        bdLocationUtils.mLocationClient.start();//开始定位

        mLatitude = SPUtil.get(getActivity(), LATIUDE, "") + "";
        mLongtitude = SPUtil.get(getActivity(), LONGTITUDE, "") + "";
        tvLocation.setText(SPUtil.get(getActivity(), CITY, "") + "");
    }

    public void Permissions() {
        bdLocationUtils.doLocation();//开启定位
        bdLocationUtils.mLocationClient.start();//开始定位

        mLatitude = SPUtil.get(getActivity(), LATIUDE, "") + "";
        mLongtitude = SPUtil.get(getActivity(), LONGTITUDE, "") + "";
        tvLocation.setText(SPUtil.get(getActivity(), CITY, "") + "");
    }

    private List<String> getUseCarTimeData() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            list.add(i + "个月");
        }
        return list;
    }

    //条件选择器
    private void showPickerView() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        // 隐藏软键盘
        imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        listData = getUseCarTimeData();
        pvOptions = new OptionsPickerBuilder(getActivity(), new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                tvUseCarTime.setText(listData.get(options1));
            }
        })
                .setDividerColor(getResources().getColor(R.color.white))//设置分割线的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final Button tvSubmit = (Button) v.findViewById(R.id.bt_pickview_confirm);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvOptions.returnData();
                                pvOptions.dismiss();
                            }
                        });
                    }
                })
                .setSelectOptions(0)//设置选择第一个
                .setOutSideCancelable(true)//点击背的地方不消失
                .build();//创建
        pvOptions.setPicker(listData);
        pvOptions.show();
    }

    private void setCenterLoginDialog() {
        TextView tv;
        final Dialog mCameraDialog = new Dialog(getActivity(), R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_center, null);
        root.findViewById(R.id.tv_dialog_center_start).setVisibility(View.VISIBLE);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText("请先登录");
        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Boolean) (SPUtil.get(getActivity(), IConstants.IS_LOGIN, false)) == false) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                } else if ((Boolean) (SPUtil.get(getActivity(), IConstants.IS_SUPPLEMENT_INFO, false)) == false) {
                    startActivity(new Intent(getActivity(), SupplementInfoActivity.class));
                    getActivity().finish();
                }
                mCameraDialog.dismiss();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_91:
                    storeId = data.getStringExtra("store_id");
                    tvCarStore.setText(data.getStringExtra("store_name"));
                    break;
            }
        }
    }

    @OnClick({R.id.bt_place_order, R.id.tv_car_store, R.id.tv_use_car_time, R.id.tv_reset_location, R.id.tv_charging_instruction, R.id.tv_select_car_store})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_reset_location:
                bdLocationUtils.doLocation();//开启定位
                bdLocationUtils.mLocationClient.start();//开始定位
                mLatitude = SPUtil.get(getActivity(), LATIUDE, "") + "";
                mLongtitude = SPUtil.get(getActivity(), LONGTITUDE, "") + "";
                tvLocation.setText(SPUtil.get(getActivity(), CITY, "") + "");
                LogUtils.i("rmy", "mLatitude = " + mLatitude + ", mLongtitude = " + mLongtitude + ", city = " + SPUtil.get(getActivity(), CITY, ""));
                if (mLatitude.indexOf("E") == -1)
                    ToastUtil.showLongToast("获取成功...");
                else
                    ToastUtil.showLongToast("请移动至空旷地区重试...");
                break;
            case R.id.tv_charging_instruction:
                startActivity(new Intent(getActivity(), WebViewActivity.class).putExtra("h5Type", 4));
                break;
            case R.id.tv_select_car_store:
                mLatitude = SPUtil.get(getActivity(), LATIUDE, "") + "";
                mLongtitude = SPUtil.get(getActivity(), LONGTITUDE, "") + "";
                LogUtils.i("rmy", "跳门店 mLatitude = " + mLatitude + ", mLongtitude = " + mLongtitude);
                if (mLatitude.indexOf("E") == -1)
                    startActivityForResult(new Intent(getActivity(), ChoiceStoreActivity.class).putExtra("latitude", mLatitude).putExtra("longtitude", mLongtitude), REQUEST_CODE_91);
                else
                    ToastUtil.showLongToast("请重新获取位置...");
                break;
            case R.id.tv_car_store:
                mLatitude = SPUtil.get(getActivity(), LATIUDE, "") + "";
                mLongtitude = SPUtil.get(getActivity(), LONGTITUDE, "") + "";
                if (mLatitude.indexOf("E") == -1)
                    startActivityForResult(new Intent(getActivity(), ChoiceStoreActivity.class).putExtra("latitude", mLatitude).putExtra("longtitude", mLongtitude), REQUEST_CODE_91);
                else
                    ToastUtil.showLongToast("请重新获取位置...");
                break;
            case R.id.tv_use_car_time:
                showPickerView();
                break;
            case R.id.bt_place_order:
                if ((Boolean) (SPUtil.get(getContext(), IConstants.IS_LOGIN, false)) == false)
                    setCenterLoginDialog();
                else if ((Boolean) (SPUtil.get(getContext(), IConstants.IS_SUPPLEMENT_INFO, false)) == false)
                    setCenterLoginDialog();
                else if (!tvCarStore.getText().toString().trim().equals("请选择取车门店") && !tvUseCarTime.getText().toString().trim().equals("请选择租赁时长")) {
                    SPUtil.put(getActivity(), USE_CAR_TIME, tvUseCarTime.getText().toString().trim().replaceAll("个月", ""));
                    startActivity(new Intent(getActivity(), UserSelectCarActivity.class).putExtra("storeId", storeId));
                } else
                    ToastUtil.showShortToast("请将信息填写完整！");
                break;
        }
    }

    @Override
    public void resultHome(HomeBean data) {
        for (int i = 0; i < data.getData().getPictureList().size(); i++) {
            AdPageInfo info1 = new AdPageInfo("", BASE_LOCAL_URL + data.getData().getPictureList().get(i).getPicPath(), "", i + 1);
            images.add(info1);
        }
        abPlaceOrder.setInfoList(images)
                .setImageLoadType(GLIDE)
                .setUp();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindUntilEvent(FragmentEvent.PAUSE);
    }
}
