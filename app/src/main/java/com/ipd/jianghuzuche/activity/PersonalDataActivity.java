package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.ModifyUserDataBean;
import com.ipd.jianghuzuche.bean.UploadImgBean;
import com.ipd.jianghuzuche.common.config.IConstants;
import com.ipd.jianghuzuche.common.view.CircleImageView;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.ModifyUserDataContract;
import com.ipd.jianghuzuche.presenter.ModifyUserDataPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.wildma.pictureselector.PictureSelector;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;
import okhttp3.RequestBody;

import static com.ipd.jianghuzuche.activity.SupplementInfoActivity.getImageRequestBody;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：个人资料
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/8.
 */
public class PersonalDataActivity extends BaseActivity<ModifyUserDataContract.View, ModifyUserDataContract.Presenter> implements ModifyUserDataContract.View {

    @BindView(R.id.tv_personal_data_top)
    TopView tvPersonalDataTop;
    @BindView(R.id.ll_top_back)
    LinearLayout llTopBack;
    @BindView(R.id.civ_personal_data_head)
    CircleImageView civPersonalDataHead;
    @BindView(R.id.ll_update_personal_data_head)
    LinearLayout llUpdatePersonalDataHead;
    @BindView(R.id.tv_personal_data_name)
    TextView tvPersonalDataName;
    @BindView(R.id.ll_update_personal_data_name)
    LinearLayout llUpdatePersonalDataName;
    @BindView(R.id.tv_personal_data_phone)
    TextView tvPersonalDataPhone;
    @BindView(R.id.ll_update_personal_data_phone)
    LinearLayout llUpdatePersonalDataPhone;

    private String avatar = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_data;
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
        ImmersionBar.setTitleBar(this, tvPersonalDataTop);

        Glide.with(this).load(SPUtil.get(this, IConstants.AVATAR, "")).apply(new RequestOptions()).into(civPersonalDataHead);
        tvPersonalDataName.setText((String) SPUtil.get(this, IConstants.NAME, ""));
        tvPersonalDataPhone.setText((String) SPUtil.get(this, IConstants.PHONE, ""));
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    private void selectPhoto() {
        /**
         * create()方法参数一是上下文，在activity中传activity.this，在fragment中传fragment.this。参数二为请求码，用于结果回调onActivityResult中判断
         * selectPicture()方法参数分别为 是否裁剪、裁剪后图片的宽(单位px)、裁剪后图片的高、宽比例、高比例。都不传则默认为裁剪，宽200，高200，宽高比例为1：1。
         */
        PictureSelector.create(PersonalDataActivity.this, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(false, 200, 200, 1, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case IConstants.REQUEST_CODE_95:
                    if (!data.getStringExtra("nameResult").equals("")) {
                        tvPersonalDataName.setText(data.getStringExtra("nameResult"));
                        SPUtil.put(this, IConstants.NAME, data.getStringExtra("nameResult"));
                    }
                    break;
                case PictureSelector.SELECT_REQUEST_CODE:
                    if (data != null) {
                        String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                        TreeMap<String, RequestBody> map = new TreeMap<>();
                        map.put("file\";filename=\"" + ".jpeg", getImageRequestBody(picturePath));
                        getPresenter().getUploadImg("1", map, true, false);
                    }
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK, new Intent().putExtra("refresh", 0));
        finish();
    }

    @OnClick({R.id.ll_update_personal_data_head, R.id.ll_update_personal_data_name, R.id.ll_top_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_update_personal_data_head:
                selectPhoto();
                break;
            case R.id.ll_update_personal_data_name:
                startActivityForResult(new Intent(this, NameActivity.class), IConstants.REQUEST_CODE_95);
                break;
            case R.id.ll_top_back:
                setResult(RESULT_OK, new Intent().putExtra("refresh", 0));
                finish();
                break;
        }
    }

    @Override
    public void resultUploadImg(UploadImgBean data) {
        try {
            avatar = data.getData();
            TreeMap<String, String> modifyPersonalDataMap = new TreeMap<>();
            modifyPersonalDataMap.put("userId", (String) SPUtil.get(this, IConstants.USER_ID, ""));
            modifyPersonalDataMap.put("avatar", data.getData());
            modifyPersonalDataMap.put("userName", (String) SPUtil.get(this, IConstants.NAME, ""));
            getPresenter().getModifyUserData(modifyPersonalDataMap, true, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resultModifyUserData(ModifyUserDataBean data) {
        SPUtil.put(this, IConstants.AVATAR, BASE_LOCAL_URL + avatar);
        Glide.with(this).load(BASE_LOCAL_URL + avatar).apply(new RequestOptions()).into(civPersonalDataHead);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
