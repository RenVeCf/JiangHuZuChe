package com.ipd.jianghuzuche.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.ViewPagerAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.common.view.NavitationLayout;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.fragment.RepairOrderRuningFragment;
import com.ipd.jianghuzuche.utils.ApplicationUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Description ：维修订单
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/7.
 */
public class RepairOrderActivity extends BaseActivity {
    @BindView(R.id.tv_repair_order_top)
    TopView tvRepairOrderTop;
    @BindView(R.id.nl_repair_order)
    NavitationLayout nlRepairOrder;
    @BindView(R.id.vp_repair_order)
    ViewPager vpRepairOrder;

    private String[] titles = new String[]{"进行中", "已完成", "已取消"};
    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;

    @Override
    public int getLayoutId() {
        return R.layout.activity_repair_order;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvRepairOrderTop);

        //向集合添加Fragment
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            final RepairOrderRuningFragment fm = new RepairOrderRuningFragment();
            Bundle args = new Bundle();
            args.putInt("fm_type", i);
            fm.setArguments(args);
            fragments.add(fm);
        }
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        vpRepairOrder.setAdapter(viewPagerAdapter);

        //设置导航条
        nlRepairOrder.setViewPager(this, titles, vpRepairOrder, R.color.tx_bottom_navigation, R.color.tx_bottom_navigation_select, 16, 16, 0, 45, true);
        nlRepairOrder.setBgLine(this, 0, R.color.whitesmoke);
        nlRepairOrder.setNavLine(this, 3, R.color.tx_bottom_navigation_select, 0);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
