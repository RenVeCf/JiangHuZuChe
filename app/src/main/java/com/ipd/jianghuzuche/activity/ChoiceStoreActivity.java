package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.ChoiceStoreAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.ChoiceStoreBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.ChoiceStoreContract;
import com.ipd.jianghuzuche.presenter.ChoiceStorePresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.STORE_NAME;
import static com.ipd.jianghuzuche.common.config.IConstants.STORE_PATH;

/**
 * Description ：选择门店
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/29.
 */
public class ChoiceStoreActivity extends BaseActivity<ChoiceStoreContract.View, ChoiceStoreContract.Presenter> implements ChoiceStoreContract.View {

    @BindView(R.id.tv_choice_store_top)
    TopView tvChoiceStoreTop;
    @BindView(R.id.srl_choice_store)
    SwipeRefreshLayout srlChoiceStore;
    @BindView(R.id.rv_choice_store)
    RecyclerView rvChoiceStore;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_search)
    ImageView ivSearch;

    private ChoiceStoreAdapter choiceStoreAdapter;
    private List<ChoiceStoreBean.DataBean.StoreListBean> choiceStoreBeanList;
    private String latitude = "";
    private String longtitude = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_choice_store;
    }

    @Override
    public ChoiceStoreContract.Presenter createPresenter() {
        return new ChoiceStorePresenter(this);
    }

    @Override
    public ChoiceStoreContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvChoiceStoreTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvChoiceStore.setLayoutManager(layoutManager);
        rvChoiceStore.setHasFixedSize(true);
        rvChoiceStore.setItemAnimator(new DefaultItemAnimator());

        latitude = getIntent().getStringExtra("latitude");
        longtitude = getIntent().getStringExtra("longtitude");
        choiceStoreBeanList = new ArrayList<>();
        choiceStoreAdapter = new ChoiceStoreAdapter(choiceStoreBeanList);
        rvChoiceStore.setAdapter(choiceStoreAdapter);
    }

    @Override
    public void initListener() {
        srlChoiceStore.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
                srlChoiceStore.setRefreshing(false);
            }
        });

        choiceStoreAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SPUtil.put(ChoiceStoreActivity.this, STORE_NAME, choiceStoreBeanList.get(position).getStoreName() + "");
                SPUtil.put(ChoiceStoreActivity.this, STORE_PATH, choiceStoreBeanList.get(position).getDescAddress() + "");

                setResult(RESULT_OK, new Intent()
                        .putExtra("store_id", choiceStoreBeanList.get(position).getStoreId() + "")
                        .putExtra("store_name", choiceStoreBeanList.get(position).getStoreName()));
                finish();
            }
        });

        choiceStoreAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_go_store:
                        goToBaiduMap(choiceStoreBeanList.get(position).getDescAddress());
                        break;
                    case R.id.tv_store_distance:
                        goToBaiduMap(choiceStoreBeanList.get(position).getDescAddress());
                        break;
                    case R.id.ll_go_store_details:
                        startActivity(new Intent(ChoiceStoreActivity.this, StoreDetailsActivity.class).putExtra("store_details", choiceStoreBeanList.get(position)).putExtra("store_type", 0));
                        break;
                }
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> choiceStoreMap = new TreeMap<>();
        choiceStoreMap.put("longitude", longtitude);
        choiceStoreMap.put("latitude", latitude);
        getPresenter().getChoiceStore(choiceStoreMap, true, false);
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

    @Override
    public void resultChoiceStore(final ChoiceStoreBean data) {
        choiceStoreBeanList.clear();
        choiceStoreBeanList.addAll(data.getData().getStoreList());
        choiceStoreAdapter.setNewData(choiceStoreBeanList);

        //空数据时的页面
        choiceStoreAdapter.setEmptyView(R.layout.null_data, rvChoiceStore);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @OnClick(R.id.iv_search)
    public void onViewClicked() {
        TreeMap<String, String> choiceStoreMap = new TreeMap<>();
        choiceStoreMap.put("longitude", longtitude);
        choiceStoreMap.put("latitude", latitude);
        choiceStoreMap.put("storeName", etSearch.getText().toString().trim());
        getPresenter().getChoiceStore(choiceStoreMap, true, false);
    }
}
