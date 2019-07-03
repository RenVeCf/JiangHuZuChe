package com.ipd.jianghuzuche.common.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Description ：正方形 imageview
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/7/2.
 */
public class ImageViewSquare extends android.support.v7.widget.AppCompatImageView {
    public ImageViewSquare(Context context) {
        super(context);
    }

    public ImageViewSquare(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        //        super.onMeasure(heightMeasureSpec, heightMeasureSpec);//宽 以 高为主
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);//高 以 宽为主2.表示宽度适应高度:

    }
}
