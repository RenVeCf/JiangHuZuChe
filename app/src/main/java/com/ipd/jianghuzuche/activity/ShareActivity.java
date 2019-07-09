package com.ipd.jianghuzuche.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.ShareAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.ShareBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.ShareContract;
import com.ipd.jianghuzuche.presenter.SharePresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：分享好友
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/6/18.
 */
public class ShareActivity extends BaseActivity<ShareContract.View, ShareContract.Presenter> implements ShareContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.tv_share_top)
    TopView tvShareTop;
    @BindView(R.id.tv_invitation_code)
    TextView tvInvitationCode;
    @BindView(R.id.iv_qr_code)
    ImageView ivQrCode;
    @BindView(R.id.tv_wechat)
    TextView tvWechat;
    @BindView(R.id.tv_wechat_moments)
    TextView tvWechatMoments;
    //    @BindView(R.id.tv_tencent)
    //    TextView tvTencent;
    //    @BindView(R.id.tv_q_zone)
    //    TextView tvQZone;
    @BindView(R.id.rv_share)
    RecyclerView rvShare;

    private int page = 0;
    private String shareUrl = "";
    private ShareAdapter shareAdapter;
    private List<ShareBean.DataBean.AppInvitationBean> appInvitationBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_share;
    }

    @Override
    public ShareContract.Presenter createPresenter() {
        return new SharePresenter(this);
    }

    @Override
    public ShareContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvShareTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvShare.setLayoutManager(layoutManager);
        rvShare.setNestedScrollingEnabled(false);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvShare.setHasFixedSize(true);
        rvShare.setItemAnimator(new DefaultItemAnimator());

        appInvitationBean = new ArrayList<>();
        shareAdapter = new ShareAdapter(appInvitationBean);
        rvShare.setAdapter(shareAdapter);
    }

    @Override
    public void initData() {
        TreeMap<String, String> shareMap = new TreeMap<>();
        shareMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        shareMap.put("page", page + "");
        getPresenter().getShare(shareMap, true, false);
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.tv_wechat, R.id.tv_wechat_moments})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_wechat:
                showShare(shareUrl, Wechat.NAME);
                break;
            case R.id.tv_wechat_moments:
                showShare1(shareUrl, WechatMoments.NAME);
                break;
//            case R.id.tv_tencent:
//                break;
//            case R.id.tv_q_zone:
//                break;
        }
    }

    // 分享微信好友
    private void showShare(String url, String platform) {
        OnekeyShare oks = new OnekeyShare();
        if (platform != null) {
            oks.setPlatform(platform);
        }
        oks.disableSSOWhenAuthorize();
        oks.setTitle(getString(R.string.app_name));
        oks.setText("");
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.logo);//显示APP本身自带图片
        oks.setImageData(bitmap);//bitmap格式图片
        oks.setUrl(url);
        oks.setComment("很棒，值得分享！！");
        oks.show(this);
    }

    // 分享微信朋友圈
    private void showShare1(String url, String platform) {
        OnekeyShare oks = new OnekeyShare();
        if (platform != null) {
            oks.setPlatform(platform);
        }
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // text是分享文本，所有平台都需要这个字段
        oks.setText(getString(R.string.app_name));
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.logo);//显示APP本身自带图片
        oks.setImageData(bitmap);//bitmap格式图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("很棒，值得分享！！");
        // 启动分享GUI
        oks.show(this);
    }

    @Override
    public void resultShare(ShareBean data) {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + data.getData().getTwoCode()).apply(new RequestOptions()).into(ivQrCode);
        tvInvitationCode.setText(data.getData().getUser().getInvitationCode());
        shareUrl = BASE_LOCAL_URL + data.getData().getUrl();
        if (page == 0) {
            appInvitationBean.clear();
            appInvitationBean.addAll(data.getData().getAppInvitation());
            shareAdapter.setNewData(appInvitationBean);
            if (appInvitationBean.size() > 0) {
                page += 1;
                shareAdapter.setOnLoadMoreListener(this, rvShare);
            } else {
                shareAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getAppInvitation().size() > 0) {
                page += 1;
                shareAdapter.addData(data.getData().getAppInvitation());
                shareAdapter.loadMoreComplete();
            } else {
                shareAdapter.loadMoreEnd();
            }
        }
        shareAdapter.setEmptyView(R.layout.null_data, rvShare);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void onLoadMoreRequested() {
        initData();
    }
}
