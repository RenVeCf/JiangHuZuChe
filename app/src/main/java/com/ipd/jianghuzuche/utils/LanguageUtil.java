package com.ipd.jianghuzuche.utils;

import android.content.Context;

import java.util.Locale;

/**
 * Description : 判断中英文环境
 * Author : rmy
 * Email : 942685687@qq.com
 * Time : 2017/11/28
 */

public class LanguageUtil {
    public static boolean isZh(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        if (language.endsWith("zh"))
            return true;
        else
            return false;
    }
}
