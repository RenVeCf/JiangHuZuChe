package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.ModifyUserDataBean;
import com.ipd.jianghuzuche.bean.UploadImgBean;
import com.ipd.jianghuzuche.common.config.IConstants;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.ModifyUserDataContract;
import com.ipd.jianghuzuche.presenter.ModifyUserDataPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

/**
 * Description ：姓名
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/8.
 */
public class NameActivity extends BaseActivity<ModifyUserDataContract.View, ModifyUserDataContract.Presenter> implements ModifyUserDataContract.View {

    @BindView(R.id.tv_name_top)
    TopView tvNameTop;
    @BindView(R.id.bt_name_confirm)
    Button btNameConfirm;
    @BindView(R.id.et_name_name)
    EditText etNameName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_name;
    }

    @Override
    public ModifyUserDataContract.Presenter createPresenter() {
        return new ModifyUserDataPresenter(this);
    }

    @Override
    public ModifyUserDataContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvNameTop);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.bt_name_confirm)
    public void onViewClicked() {
        TreeMap<String, String> ModifyUserDataMap = new TreeMap<>();
        ModifyUserDataMap.put("id", (String) SPUtil.get(this, IConstants.USER_ID, ""));
        ModifyUserDataMap.put("avatar", (String) SPUtil.get(this, IConstants.AVATAR, ""));
        ModifyUserDataMap.put("name", etNameName.getText().toString().trim());
        getPresenter().getModifyUserData(ModifyUserDataMap, true, false);
    }

    @Override
    public void resultModifyUserData(ModifyUserDataBean data) {
//        ToastUtil.showShortToast(data.getMsg());
        setResult(RESULT_OK, new Intent().putExtra("nameResult", etNameName.getText().toString().trim()));
        finish();
    }

    @Override
    public void resultUploadImg(UploadImgBean data) {

    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
