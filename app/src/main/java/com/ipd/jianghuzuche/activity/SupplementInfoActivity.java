package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.SupplementInfoBean;
import com.ipd.jianghuzuche.bean.UploadImgBean;
import com.ipd.jianghuzuche.common.config.IConstants;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.SupplementInfoContract;
import com.ipd.jianghuzuche.presenter.SupplementInfoPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.MD5Utils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.StringUtils;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;
import com.wildma.pictureselector.PictureSelector;

import java.io.File;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static com.ipd.jianghuzuche.common.config.IConstants.IS_SUPPLEMENT_INFO;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：完善信息
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class SupplementInfoActivity extends BaseActivity<SupplementInfoContract.View, SupplementInfoContract.Presenter> implements SupplementInfoContract.View {

    @BindView(R.id.tv_supplement_info_top)
    TopView tvSupplementInfoTop;
    @BindView(R.id.tv_top_review)
    TextView tvTopReview;
    @BindView(R.id.iv_id_card_positive)
    ImageView ivIdCardPositive;
    @BindView(R.id.iv_id_card_back)
    ImageView ivIdCardBack;
    @BindView(R.id.iv_id_card_hand)
    ImageView ivIdCardHand;
    @BindView(R.id.bt_supplement_info)
    Button btSupplementInfo;

    private String idImgPath = "";
    private String idPositive = "";
    private String idOpposite = "";
    private String idHold = "";
    private int flag;
    private int reviewType = 0;//1.未上传资料 2正常4.审核中 5.已拒绝

    @Override
    public int getLayoutId() {
        return R.layout.activity_supplement_info;
    }

    @Override
    public SupplementInfoContract.Presenter createPresenter() {
        return new SupplementInfoPresenter(this);
    }

    @Override
    public SupplementInfoContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvSupplementInfoTop);

        reviewType = getIntent().getIntExtra("review_type", 0);
        switch (reviewType) {
            case 1:
                tvTopReview.setText("未审核");
                break;
            case 4:
                tvTopReview.setText("审核中");
                ivIdCardPositive.setEnabled(false);
                ivIdCardBack.setEnabled(false);
                ivIdCardHand.setEnabled(false);
                break;
            case 5:
                tvTopReview.setText("已拒绝");
                break;
        }
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
        PictureSelector.create(this, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(false, 200, 200, 1, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureSelector.SELECT_REQUEST_CODE:
                if (data != null) {
                    String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                    TreeMap<String, RequestBody> map = new TreeMap<>();
                    map.put("file\";filename=\"" + ".jpeg", getImageRequestBody(picturePath));
                    getPresenter().getUploadImg("2", map, true, false);
                }
                break;
        }
    }

    public static RequestBody getImageRequestBody(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        return RequestBody.create(MediaType.parse(options.outMimeType), new File(filePath));
    }

    @OnClick({R.id.iv_id_card_positive, R.id.iv_id_card_back, R.id.iv_id_card_hand, R.id.bt_supplement_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_id_card_positive:
                flag = 0;
                selectPhoto();
                break;
            case R.id.iv_id_card_back:
                flag = 1;
                selectPhoto();
                break;
            case R.id.iv_id_card_hand:
                flag = 2;
                selectPhoto();
                break;
            case R.id.bt_supplement_info:
                if (isClickUtil.isFastClick()) {
                    if (!idPositive.equals("") && !idOpposite.equals("") && !idHold.equals("")) {
                        TreeMap<String, String> loginMap = new TreeMap<>();
                        loginMap.put("idPositive", idPositive);
                        loginMap.put("idOpposite", idOpposite);
                        loginMap.put("idHold", idHold);
                        loginMap.put("userId", (String) SPUtil.get(this, IConstants.USER_ID, ""));
                        loginMap.put("sign", StringUtils.toUpperCase(MD5Utils.encodeMD5(loginMap.toString().replaceAll(" ", "") + "f9a75bb045d75998e1509b75ed3a5225")));
                        getPresenter().getSupplementInfo(loginMap, true, false);
                    } else
                        ToastUtil.showShortToast("请选择证件照！");
                }
                break;
        }
    }

    @Override
    public void resultSupplementInfo(SupplementInfoBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void resultUploadImg(UploadImgBean data) {
        idImgPath = data.getData();
        switch (flag) {
            case 0:
                idPositive = idImgPath;
                Glide.with(this).load(BASE_LOCAL_URL + idImgPath).apply(new RequestOptions()).into(ivIdCardPositive);
                break;
            case 1:
                idOpposite = idImgPath;
                Glide.with(this).load(BASE_LOCAL_URL + idImgPath).apply(new RequestOptions()).into(ivIdCardBack);
                break;
            case 2:
                idHold = idImgPath;
                Glide.with(this).load(BASE_LOCAL_URL + idImgPath).apply(new RequestOptions()).into(ivIdCardHand);
                break;
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
