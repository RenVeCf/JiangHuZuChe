package com.ipd.jianghuzuche.utils;

import com.baidu.mapapi.model.LatLng;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/6/6.
 */
public class ExchangeMapUtil {
    /**
     * BD-09 坐标转换成 GCJ-02 坐标
     */
    public static LatLng BD2GCJ(LatLng bd) {
        double x = bd.longitude - 0.0065, y = bd.latitude - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI);

        double lng = z * Math.cos(theta);//lng
        double lat = z * Math.sin(theta);//lat
        return new LatLng(lat, lng);
    }

    /**
     * GCJ-02 坐标转换成 BD-09 坐标
     */
    public static LatLng GCJ2BD(LatLng bd) {
        double x = bd.longitude, y = bd.latitude;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * Math.PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * Math.PI);
        double tempLon = z * Math.cos(theta) + 0.0065;
        double tempLat = z * Math.sin(theta) + 0.006;
        return new LatLng(tempLat, tempLon);
    }
}
