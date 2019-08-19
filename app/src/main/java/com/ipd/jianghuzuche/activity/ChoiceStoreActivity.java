package com.ipd.jianghuzuche.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baidu.mapapi.model.LatLng;
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
import com.ipd.jianghuzuche.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.STORE_NAME;
import static com.ipd.jianghuzuche.common.config.IConstants.STORE_PATH;
import static com.ipd.jianghuzuche.utils.ExchangeMapUtil.BD2GCJ;

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
    private int pageNum = 0;//页数

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
                pageNum = 0;
                initData();
                srlChoiceStore.setRefreshing(false);
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> choiceStoreMap = new TreeMap<>();
        choiceStoreMap.put("longitude", longtitude);
        choiceStoreMap.put("latitude", latitude);
        choiceStoreMap.put("storeName", etSearch.getText().toString().trim());
        choiceStoreMap.put("page", pageNum + "");
        getPresenter().getChoiceStore(choiceStoreMap, true, false);
    }

    // 选择地图
    private void setMapDialog(final int position) {
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_map, null);
        root.findViewById(R.id.ll_baidu_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBaiduMap(choiceStoreBeanList.get(position).getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.ll_gaode_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGaodeMap(choiceStoreBeanList.get(position).getLatitude(), choiceStoreBeanList.get(position).getLongitude(), choiceStoreBeanList.get(position).getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.ll_tengxun_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTengxunMap(choiceStoreBeanList.get(position).getLatitude(), choiceStoreBeanList.get(position).getLongitude(), choiceStoreBeanList.get(position).getDescAddress());
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

    @Override
    public void resultChoiceStore(final ChoiceStoreBean data) {
        if (data.getCode() == 200) {
            if (data.getData().getStoreList().size() > 0) {
                if (pageNum == 0) {
                    choiceStoreBeanList.clear();
                    choiceStoreBeanList.addAll(data.getData().getStoreList());
                    choiceStoreAdapter = new ChoiceStoreAdapter(choiceStoreBeanList);
                    rvChoiceStore.setAdapter(choiceStoreAdapter);
                    choiceStoreAdapter.bindToRecyclerView(rvChoiceStore);
                    choiceStoreAdapter.setEnableLoadMore(true);
                    choiceStoreAdapter.openLoadAnimation();
                    choiceStoreAdapter.disableLoadMoreIfNotFullPage();

                    choiceStoreAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            if (isClickUtil.isFastClick()) {
                                SPUtil.put(ChoiceStoreActivity.this, STORE_NAME, choiceStoreBeanList.get(position).getStoreName() + "");
                                SPUtil.put(ChoiceStoreActivity.this, STORE_PATH, choiceStoreBeanList.get(position).getDescAddress() + "");

                                setResult(RESULT_OK, new Intent()
                                        .putExtra("store_id", choiceStoreBeanList.get(position).getStoreId() + "")
                                        .putExtra("store_name", choiceStoreBeanList.get(position).getStoreName()));
                                finish();
                            }
                        }
                    });

                    choiceStoreAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            if (isClickUtil.isFastClick()) {
                                switch (view.getId()) {
                                    case R.id.tv_go_store:
                                        setMapDialog(position);
                                        break;
                                    case R.id.tv_store_distance:
                                        setMapDialog(position);
                                        break;
                                    case R.id.ll_go_store_details:
                                        startActivity(new Intent(ChoiceStoreActivity.this, StoreDetailsActivity.class).putExtra("store_details", choiceStoreBeanList.get(position)).putExtra("store_type", 0));
                                        break;
                                }
                            }
                        }
                    });

                    //上拉加载
                    choiceStoreAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                        @Override
                        public void onLoadMoreRequested() {
                            rvChoiceStore.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    initData();
                                }
                            }, 1000);
                        }
                    }, rvChoiceStore);

                    if (choiceStoreBeanList.size() > 10) {
                        pageNum += 1;
                    } else {
                        choiceStoreAdapter.loadMoreEnd();
                    }
                } else {
                    if ((choiceStoreBeanList.size() - pageNum * 10) > 0) {
                        pageNum += 1;
                        choiceStoreAdapter.addData(choiceStoreBeanList);
                        choiceStoreAdapter.loadMoreComplete(); //完成本次
                    } else {
                        choiceStoreAdapter.addData(choiceStoreBeanList);
                        choiceStoreAdapter.loadMoreEnd(); //完成所有加载
                    }
                }
            } else {
                choiceStoreBeanList.clear();
                choiceStoreAdapter = new ChoiceStoreAdapter(choiceStoreBeanList);
                rvChoiceStore.setAdapter(choiceStoreAdapter);
                choiceStoreAdapter.loadMoreEnd(); //完成所有加载
                choiceStoreAdapter.setEmptyView(R.layout.null_data, rvChoiceStore);
            }
        } else
            ToastUtil.showLongToast(data.getMsg());
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @OnClick(R.id.iv_search)
    public void onViewClicked() {
        if (isClickUtil.isFastClick()) {
            pageNum = 0;
            TreeMap<String, String> choiceStoreMap = new TreeMap<>();
            choiceStoreMap.put("longitude", longtitude);
            choiceStoreMap.put("latitude", latitude);
            choiceStoreMap.put("storeName", etSearch.getText().toString().trim());
            choiceStoreMap.put("page", pageNum + "");
            getPresenter().getChoiceStore(choiceStoreMap, true, false);
        }
    }
}
