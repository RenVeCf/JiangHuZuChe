package com.ipd.jianghuzuche.common.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.activity.MsgActivity;
import com.ipd.jianghuzuche.activity.SelectBankTwoActivity;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;

/**
 * Description : 公用标题栏
 * Author : rmy
 * Email : 942685687@qq.com
 * Time : 2017/11/loading1
 */

public class TopView extends RelativeLayout implements View.OnClickListener {

    private TextView tvTopTitle;
    private ImageView ivTopBack;
    private ImageView ivTopSidebar;
    private ImageView ivTopMsg;
    private TextView tvTopBank;

    //各icon是否显示
    private Boolean isBack;
    private Boolean isSidebar;
    private Boolean isMsg;
    private Boolean isBank;
    private Context mContext;

    public TopView(Context context) {
        super(context);
        initValues(context);
    }

    public TopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initValues(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopView);
        tvTopTitle.setText(typedArray.getString(R.styleable.TopView_title));
        tvTopTitle.setTextColor(typedArray.getColor(R.styleable.TopView_title_color, getResources().getColor(R.color.black)));
        isBack = typedArray.getBoolean(R.styleable.TopView_is_back, false);
        isSidebar = typedArray.getBoolean(R.styleable.TopView_is_sidebar, false);
        isMsg = typedArray.getBoolean(R.styleable.TopView_is_msg, false);
        isBank = typedArray.getBoolean(R.styleable.TopView_is_bank, false);
        tvTopBank.setTextColor(typedArray.getColor(R.styleable.TopView_bank_color, getResources().getColor(R.color.black)));
        typedArray.recycle();

        ivTopBack.setVisibility(isBack ? View.VISIBLE : View.GONE);
        ivTopSidebar.setVisibility(isSidebar ? View.VISIBLE : View.GONE);
        ivTopMsg.setVisibility(isMsg ? View.VISIBLE : View.GONE);
        tvTopBank.setVisibility(isBank ? View.VISIBLE : View.GONE);
    }

    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initValues(context);
    }

    private void initValues(final Context context) {
        mContext = context;
        View.inflate(context, R.layout.top_view, this);
        tvTopTitle = (TextView) this.findViewById(R.id.tv_top_title);
        ivTopBack = (ImageView) this.findViewById(R.id.iv_top_back);
        ivTopSidebar = (ImageView) this.findViewById(R.id.iv_top_sidebar);
        ivTopMsg = (ImageView) this.findViewById(R.id.iv_top_msg);
        tvTopBank = (TextView) this.findViewById(R.id.tv_top_bank);

        ivTopBack.setOnClickListener(this);
        ivTopSidebar.setOnClickListener(this);
        ivTopMsg.setOnClickListener(this);
        tvTopBank.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_top_back:
                if (mContext instanceof Activity && isClickUtil.isFastClick()) {
                    ((Activity) mContext).finish();
                    if (((Activity) mContext).getCurrentFocus() != null) {
                        ((InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(((Activity) mContext).getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }
                break;
            case R.id.iv_top_msg:
                ApplicationUtil.getContext().startActivity(new Intent(ApplicationUtil.getContext(), MsgActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
            case R.id.tv_top_bank:
                ApplicationUtil.getContext().startActivity(new Intent(ApplicationUtil.getContext(), SelectBankTwoActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
            default:
                break;
        }
    }
}
