package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.UserCouponAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.CouponBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.CouponContract;
import com.ipd.jianghuzuche.presenter.CouponPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.LogUtils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

/**
 * Description ：优惠券
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/30.
 */
public class UserCouponActivity extends BaseActivity<CouponContract.View, CouponContract.Presenter> implements CouponContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.tv_user_coupon_top)
    TopView tvUserCouponTop;
    @BindView(R.id.rv_user_coupon)
    RecyclerView rvUserCoupon;
    @BindView(R.id.srl_user_coupon)
    SwipeRefreshLayout srlUserCoupon;
    @BindView(R.id.tv_sum_money)
    TextView tvSumMoney;
    @BindView(R.id.ll_sum_money)
    LinearLayout llSumMoney;

    private List<CouponBean.DataBean.UserCouponListBean> couponBean;
    private UserCouponAdapter userCouponAdapter;
    private double money = 0;
    private static Handler handler = new Handler();
    private int page = 0;
    private int couponType = 2;
    private double sumMoney = 0;
    private List<Integer> couponIdList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_coupon;
    }

    @Override
    public CouponContract.Presenter createPresenter() {
        return new CouponPresenter(this);
    }

    @Override
    public CouponContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvUserCouponTop);

        couponIdList = getIntent().getIntegerArrayListExtra("coupon_id");
        couponType = getIntent().getIntExtra("coupon_type", 2);
        if (couponType == 1)
            llSumMoney.setVisibility(View.GONE);
        money = getIntent().getDoubleExtra("money", 0);
        sumMoney = getIntent().getDoubleExtra("coupon_money", 0);
        tvSumMoney.setText(Html.fromHtml("累计优惠: <font color=\"#0076FF\"> ¥" + sumMoney + "元</font>"));


        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvUserCoupon.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvUserCoupon.setHasFixedSize(true);
        rvUserCoupon.setItemAnimator(new DefaultItemAnimator());

        couponBean = new ArrayList<>();
        userCouponAdapter = new UserCouponAdapter(couponBean);
        rvUserCoupon.setAdapter(userCouponAdapter);
    }

    @Override
    public void initListener() {
        srlUserCoupon.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlUserCoupon.setRefreshing(false);
            }
        });

        userCouponAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                //                for (int i = 0; i < couponBean.size(); i++) {
                //                    couponBean.get(i).setShow(false);
                //                }
                if (couponBean.get(position).isShow()) {
                    couponBean.get(position).setShow(false);
                    for (int j = 0; j < couponIdList.size(); j++) {
                        if (couponBean.get(position).getUserCouponId() == couponIdList.get(j))
                            couponIdList.remove(j);
                    }

                    sumMoney -= couponBean.get(position).getMoney();
                } else {
                    if (money - sumMoney >= 0 ? true : false) {
                        couponBean.get(position).setShow(true);
                        couponIdList.add(couponBean.get(position).getUserCouponId());
                        sumMoney += couponBean.get(position).getMoney();
                    } else
                        ToastUtil.showShortToast("最低减至0元，券金额已超出！");
                }
                tvSumMoney.setText(Html.fromHtml("累计优惠: <font color=\"#0076FF\"> ¥" + sumMoney + "元</font>"));
                userCouponAdapter.notifyDataSetChanged();

                //                new Thread(new Runnable() {
                //                    @Override
                //                    public void run() {
                //                        // 使用postDelayed方式修改UI组件tvMessage的Text属性值
                //                        // 并且延迟执行
                //                        handler.postDelayed(new Runnable() {
                //                            @Override
                //                            public void run() {
                //                                setResult(RESULT_OK, new Intent().putExtra("coupon_name", couponBean.get(position).getTitle()).putExtra("coupon_money", couponBean.get(position).getMoney()).putExtra("coupon_id", couponBean.get(position).getUserCouponId()));
                //                                finish();
                //                            }
                //                        }, 500);
                //                    }
                //                }).start();
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> couponMap = new TreeMap<>();
        couponMap.put("userId", (String) SPUtil.get(this, USER_ID, ""));
        couponMap.put("page", page + "");
        couponMap.put("type", couponType + "");
        getPresenter().getCoupon(couponMap, true, false);
    }

    @Override
    public void resultCoupon(CouponBean data) {
        if (page == 0) {
            couponBean.clear();
            couponBean.addAll(data.getData().getUserCouponList());
            if (couponBean.size() > 0) {
                //                for (int i = 0; i < couponBean.size(); ) {
                //                    if (couponBean.get(i).getAchieveMoney() > money) {
                //                        couponBean.remove(i);
                //                    } else
                //                        i++;
                //                }
                page += 1;
                for (int j : couponIdList) {
                    for (int i = 0; i < couponBean.size(); i++) {
                        LogUtils.i("rmy", "getUserCouponId = " + couponBean.get(i).getUserCouponId());
                        LogUtils.i("rmy", "j = " + j);
                        if (couponBean.get(i).getUserCouponId() == j)
                            couponBean.get(i).setShow(true);
                    }
                }
                userCouponAdapter.setNewData(couponBean);
                userCouponAdapter.setOnLoadMoreListener(this, rvUserCoupon);
            } else {
                userCouponAdapter.setNewData(couponBean);
                userCouponAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getUserCouponList().size() > 0) {
                page += 1;
                //                for (int i = 0; i < data.getData().getUserCouponList().size(); i++) {
                //                    if (data.getData().getUserCouponList().get(i).getUserCouponId() == couponId)
                //                        data.getData().getUserCouponList().get(i).setShow(true);
                //                    else
                //                        data.getData().getUserCouponList().get(i).setShow(false);
                //                }
                for (int j : couponIdList) {
                    for (int i = 0; i < couponBean.size(); i++) {
                        if (couponBean.get(i).getUserCouponId() == j)
                            couponBean.get(i).setShow(true);
                    }
                }
                userCouponAdapter.addData(data.getData().getUserCouponList());
                userCouponAdapter.loadMoreComplete();
            } else {
                userCouponAdapter.loadMoreEnd();
            }
        }
        userCouponAdapter.setEmptyView(R.layout.null_data, rvUserCoupon);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void onLoadMoreRequested() {
        initData();
    }

    @OnClick(R.id.bt_coupon)
    public void onViewClicked() {
        setResult(RESULT_OK, new Intent().putExtra("coupon_money", sumMoney).putIntegerArrayListExtra("coupon_id", (ArrayList<Integer>) couponIdList));
        finish();
    }
}
