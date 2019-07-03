package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.ConfirmVehicleBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.ConfirmVehicleContract;
import com.ipd.jianghuzuche.presenter.ConfirmVehiclePresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.DateUtils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

/**
 * Description ：提前/申请 还车
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/6.
 */
public class ReturnCarActivity extends BaseActivity<ConfirmVehicleContract.View, ConfirmVehicleContract.Presenter> implements ConfirmVehicleContract.View {

    @BindView(R.id.tv_return_car_top)
    TopView tvReturnCarTop;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_set_car_time)
    TextView tvSetCarTime;
    @BindView(R.id.cb_return_car)
    CheckBox cbReturnCar;
    @BindView(R.id.bt_return_car)
    Button btReturnCar;
    @BindView(R.id.tv_return_car_rule)
    TextView tvReturnCarRule;

    private TimePickerView pvTime;
    private int orderId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_return_car;
    }

    @Override
    public ConfirmVehicleContract.Presenter createPresenter() {
        return new ConfirmVehiclePresenter(this);
    }

    @Override
    public ConfirmVehicleContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvReturnCarTop);

        tvTopTitle.setText(getIntent().getStringExtra("return_car_title"));
        tvStoreName.setText(getIntent().getStringExtra("store_name"));
        orderId = getIntent().getIntExtra("order_id", 0);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    //时间选择器
    private void selectTime() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        //正确设置方式 原因：注意事项有说明
        startDate.set(2013, 0, 1);
        endDate.set(2022, 11, 31);

        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                tvSetCarTime.setText(DateUtils.timedate1(date.getTime() + ""));
                tvSetCarTime.setTextColor(Color.BLACK);
            }
        })
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final Button tvSubmit = (Button) v.findViewById(R.id.bt_pickview_confirm);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvTime.returnData();
                                pvTime.dismiss();
                            }
                        });
                    }
                })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
//                .setCancelText("请选择起始时间")//取消按钮文字
//                .setSubmitText("")//确认按钮文字
                //                .setContentSize(18)//滚轮文字大小
//                .setTitleSize(16)//标题文字大小
//                .setTitleText("请选择起始时间")
                .setDecorView((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content))
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
//                .setTitleColor(Color.BLACK)//标题文字颜色
//                .setSubmitColor(Color.BLACK)//确定按钮文字颜色
//                .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                .setTitleBgColor(0xFFFFFFFF)//标题背景颜色 Night mode
                .setBgColor(Color.WHITE)//滚轮背景颜色 Night mode
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("", "", "", "时", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();
        pvTime.show();
    }

    @OnClick({R.id.tv_return_car_rule, R.id.tv_set_car_time, R.id.bt_return_car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_return_car_rule:
                startActivity(new Intent(this, WebViewActivity.class).putExtra("h5Type", 1));
                break;
            case R.id.tv_set_car_time:
                selectTime();
                break;
            case R.id.bt_return_car:
                if (isClickUtil.isFastClick()) {
                    if (cbReturnCar.isChecked()) {
                        TreeMap<String, String> confirmVehicleMap = new TreeMap<>();
                        confirmVehicleMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                        confirmVehicleMap.put("orderId", orderId + "");
                        confirmVehicleMap.put("revehicleTime", tvSetCarTime.getText().toString().trim());
                        getPresenter().getConfirmVehicle(confirmVehicleMap, true, false);
                    } else
                        ToastUtil.showLongToast(R.string.error_check_box);
                }
                break;
        }
    }

    @Override
    public void resultConfirmVehicle(ConfirmVehicleBean data) {
        ToastUtil.showShortToast(data.getMsg());
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
