package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.ContentAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.common.view.LockableViewPager;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.DisplayUtils;
import com.ipd.jianghuzuche.utils.SPUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.ipd.jianghuzuche.common.config.IConstants.FIRST_APP;

/**
 * Description ：引导页
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/6/12.
 */
public class LoadingActivity extends BaseActivity {
    @BindView(R.id.lvp_loading)
    LockableViewPager lvpLoading;
    @BindView(R.id.ib_loading_login)
    ImageButton ibLoadingLogin;

    private int[] imageUrls = {R.mipmap.loading1, R.mipmap.loading2, R.mipmap.loading3};
    private List<View> viewList;
    private int currentItem = 0;
    private ContentAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_loading;
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

        // 判断是否是第一次开启应用
        boolean isFirstOpen = (boolean) SPUtil.get(this, FIRST_APP, true);
        if (!isFirstOpen) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }

        viewList = new ArrayList<>();
        for (int i = 0; i < imageUrls.length; i++) {
            viewList.add(initView(imageUrls[i]));
        }
        adapter = new ContentAdapter(viewList, null);
        lvpLoading.setSwipeable(true);
        lvpLoading.setAdapter(adapter);
        lvpLoading.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float startY;//没有用到
            float endX;
            float endY;//没有用到

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = motionEvent.getX();
                        endY = motionEvent.getY();
                        //首先要确定的是，是否到了最后一页，然后判断是否向左滑动，并且滑动距离是否符合，我这里的判断距离是屏幕宽度的4分之一（这里可以适当控制）
                        if (currentItem == (viewList.size() - 1) && startX - endX >= (DisplayUtils.getScreenWidth(LoadingActivity.this) / 4)) {
                            Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    private View initView(int imagePathId) {
        ImageView imageView = new ImageView(getBaseContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(imagePathId);
        return imageView;
    }

    @OnClick(R.id.ib_loading_login)
    public void onViewClicked() {
        startActivity(new Intent(LoadingActivity.this, MainActivity.class));
        finish();
    }
}
