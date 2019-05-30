package com.ipd.jianghuzuche.utils;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;

import com.ipd.jianghuzuche.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description :
 * Author : rmy
 * Email : 942685687@qq.com
 * Time : 2018/2/24
 */

public class PermissionUtils {
    private static final String TAG = PermissionUtils.class.getSimpleName();
    public static final int CODE_CONTACTS = 0;//联系人
    public static final int CODE_PHONE = 1;//电话
    public static final int CODE_CALENDAR = 2;//日历
    public static final int CODE_CAMERA = 3;//相机
    public static final int CODE_SENSORS = 4;//传感器
    public static final int CODE_LOCATION = 5;//定位
    public static final int CODE_STORAGE = 6;//内存卡
    public static final int CODE_MICROPHONE = 7;//麦克风
    public static final int CODE_SMS = 8;//短信
    public static final int CODE_MULTI_PERMISSION = 100;//多个权限
    // 以下是对应上面的组权限，只需要申请一个组内的权限即可
    public static final String PERMISSION_GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public static final String PERMISSION_CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String PERMISSION_READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    public static final String PERMISSION_BODY_SENSORS = Manifest.permission.BODY_SENSORS;
    public static final String PERMISSION_ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String PERMISSION_READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String PERMISSION_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public static final String PERMISSION_READ_SMS = Manifest.permission.READ_SMS;
    private static final String[] requestPermissions = {
            PERMISSION_GET_ACCOUNTS,
            PERMISSION_CALL_PHONE,
            PERMISSION_READ_CALENDAR,
            PERMISSION_CAMERA,
            PERMISSION_BODY_SENSORS,
            PERMISSION_ACCESS_FINE_LOCATION,
            PERMISSION_READ_EXTERNAL_STORAGE,
            PERMISSION_RECORD_AUDIO,
            PERMISSION_READ_SMS,
    };

    /**
     * 请求回调接口
     */
    public interface PermissionGrant {
        void onPermissionGranted(int requestCode);
    }

    /**
     * 请求 permission. * * @param activity 上下文 * @param requestCode request code 如果需要Camera权限，就使用PermissionUtils.CODE_CAMERA
     */
    public static void requestPermission(final Activity activity, final int requestCode, PermissionGrant permissionGrant) {
        if (activity == null) {
            return;
        }
        if (requestCode < 0 || requestCode >= requestPermissions.length) {
            LogUtils.i(TAG, "requestPermission illegal requestCode:" + requestCode);
            return;
        }
        //如果是6.0以下的手机，ActivityCompat.checkSelfPermission()会始终等于PERMISSION_GRANTED，
        // 但是，如果用户关闭了你申请的权限，ActivityCompat.checkSelfPermission(),会导致程序崩溃(java.lang.RuntimeException: Unknown exception code: 1 msg null)， // 你可以使用try{}catch(){},处理异常，也可以判断系统版本，低于23就不申请权限，直接做你想做的。permissionGrant.onPermissionGranted(requestCode);
        // if (Build.VERSION.SDK_INT < 23) {
        // permissionGrant.onPermissionGranted(requestCode);
        // return;
        // }
        final String requestPermission = requestPermissions[requestCode];
        int checkSelfPermission;
        try {
            checkSelfPermission = ActivityCompat.checkSelfPermission(activity, requestPermission);
        } catch (RuntimeException e) {
            ToastUtil.showShortToast(activity.getResources().getText(R.string.Toast_permission) + "");
            return;
        }
        if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
            LogUtils.i(TAG, "ActivityCompat.checkSelfPermission != PackageManager.PERMISSION_GRANTED");
            //判断是否需要解释弹窗
            // 第一次 false 要允许吗（request）？
            // 第二次 true 先弹一个框解释为什么需要权限，然后再去request，这个时候会出现不再询问
            // 第三次 当点击了不再询问会false不弹窗
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, requestPermission)) {
                LogUtils.i(TAG, "requestPermission shouldShowRequestPermissionRationale");
                shouldShowRationale(activity, requestCode, requestPermission);
            } else { //不需要弹窗（第一次) 要求权限打开弹窗
                LogUtils.d(TAG, "requestCameraPermission else");
                ActivityCompat.requestPermissions(activity, new String[]{requestPermission}, requestCode);
            } //如该开启类权限，直接回调接口返回
        } else {
            LogUtils.d(TAG, "ActivityCompat.checkSelfPermission ==== PackageManager.PERMISSION_GRANTED");
            permissionGrant.onPermissionGranted(requestCode);
        }
    }

    /**
     * 一次申请多个权限 * * @param activity 上下文 * @param grant 回调接口
     */
    public static void requestMultiPermissions(final Activity activity, int[] permissions, PermissionGrant grant) {
        if (activity == null) {
            return;
        } //获取没有授权 不弹窗的所有权限
        final List<String> permissionsList = getNoGrantedPermission(activity, permissions, false);
        //获取没有授权 弹窗的所有权限
        final List<String> shouldRationalePermissionsList = getNoGrantedPermission(activity, permissions, true);
        //如果没有需要打开的权限直接返回,
        if (permissionsList == null || shouldRationalePermissionsList == null) {
            return;
        }
        LogUtils.d(TAG, "requestMultiPermissions permissionsList:" + permissionsList.size() + ",shouldRationalePermissionsList:" + shouldRationalePermissionsList.size());
        if (permissionsList.size() > 0) {
            //请求所有权限
            ActivityCompat.requestPermissions(activity, permissionsList.toArray(new String[permissionsList.size()]), CODE_MULTI_PERMISSION);
            LogUtils.d(TAG, "showMessageOKCancel requestPermissions");
        } else if (shouldRationalePermissionsList.size() > 0) {
            showMessageOKCancel(activity, activity.getResources().getString(R.string.Dialog_Multi_Permission), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(activity, shouldRationalePermissionsList.toArray(new String[shouldRationalePermissionsList.size()]), CODE_MULTI_PERMISSION);
                    LogUtils.d(TAG, "showMessageOKCancel requestPermissions");
                }
            });
        } else {
            grant.onPermissionGranted(CODE_MULTI_PERMISSION);
        }
    }

    /**
     * 获取没有授权 需要/不需要 弹窗的权限 * * @param activity 上下文 * @param isShouldRationale true 没有授权需要弹窗的权限 false 没有授权不需要弹窗的权限 * @return 权限集合
     */
    private static ArrayList<String> getNoGrantedPermission(Activity activity, int[] permissionCode, boolean isShouldRationale) {
        ArrayList<String> permissions = new ArrayList<>();
        for (int i = 0; i < permissionCode.length; i++) {
            String requestPermission = requestPermissions[permissionCode[i]];
            int checkSelfPermission = -1;
            try {
                checkSelfPermission = ActivityCompat.checkSelfPermission(activity, requestPermission);
            } catch (RuntimeException e) {
                ToastUtil.showShortToast(activity.getResources().getText(R.string.Toast_permission) + "");
                LogUtils.e(TAG, "RuntimeException:" + e.getMessage());
                return null;
            }
            if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
                LogUtils.i(TAG, "getNoGrantedPermission ActivityCompat.checkSelfPermission != PackageManager.PERMISSION_GRANTED:" + requestPermission);
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, requestPermission)) {
                    LogUtils.d(TAG, "shouldShowRequestPermissionRationale if");
                    if (isShouldRationale) {
                        permissions.add(requestPermission);
                    }
                } else {
                    if (!isShouldRationale) {
                        permissions.add(requestPermission);
                    }
                    LogUtils.d(TAG, "shouldShowRequestPermissionRationale else");
                }
            }
        }
        return permissions;
    }

    /**
     * 权限返回结果，当请求权限结束的时候调用的方法（失败或者成功都会回调) --->打开设置权限 * * @param activity 上下文 * @param requestCode 包含的权限码 * @param permissions 所有权限数组 * @param grantResults 授权的权限数组 * @param permissionGrant 回调接口
     */
    public static void requestPermissionsResult(final Activity activity, final int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, PermissionGrant permissionGrant) {
        if (activity == null) {
            return;
        } //如果code是CODE_MULTI_PERMISSION就去调用多个权限的返回结果方法
        if (requestCode == CODE_MULTI_PERMISSION) {
            requestMultiResult(activity, permissions, grantResults, permissionGrant);
            return;
        }
        if (requestCode < 0 || requestCode >= requestPermissions.length) {
            LogUtils.i(TAG, "requestPermissionsResult illegal requestCode:" + requestCode);
            ToastUtil.showShortToast(activity.getResources().getText(R.string.permission_illegal_code) + "" + requestCode);
            return;
        }
        LogUtils.i(TAG, "onRequestPermissionsResult requestCode:" + requestCode + ",permissions:" + permissions.toString() + ",grantResults:" + grantResults.toString() + ",length:" + grantResults.length);
        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            LogUtils.i(TAG, "onRequestPermissionsResult PERMISSION_GRANTED");
            permissionGrant.onPermissionGranted(requestCode);
        } else {
            LogUtils.i(TAG, "onRequestPermissionsResult PERMISSION NOT GRANTED");
            String[] permissionsHint = activity.getResources().getStringArray(R.array.permissions);
            //            openSettingActivity(activity, "应用" + permissionsHint[requestCode]);
        }
    }

    /**
     * @param activity 上下文 * @param permissions 权限 * @param grantResults 授权的权限数组 * @param permissionGrant 回调接口
     */
    private static void requestMultiResult(Activity activity, String[] permissions, int[] grantResults, PermissionGrant permissionGrant) {
        if (activity == null) {
            return;
        }
        LogUtils.d(TAG, "onRequestPermissionsResult permissions length:" + permissions.length);
        Map<String, Integer> perms = new HashMap<>();
        ArrayList<String> notGranted = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            LogUtils.d(TAG, "permissions: [i]:" + i + ", permissions[i]" + permissions[i] + ",grantResults[i]:" + grantResults[i]);
            perms.put(permissions[i], grantResults[i]);
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                notGranted.add(permissions[i]);
            }
        }
        if (notGranted.size() == 0) {
            permissionGrant.onPermissionGranted(CODE_MULTI_PERMISSION);
        } else {
            openSettingActivity(activity, activity.getResources().getString(R.string.Dialog_Multi_Permission));
        }
    }

    //显示请求权限弹窗
    private static void shouldShowRationale(final Activity activity, final int requestCode, final String requestPermission) {
        String[] permissionsHint = activity.getResources().getStringArray(R.array.permissions);
        showMessageOKCancel(activity, "应用" + permissionsHint[requestCode], new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions(activity, new String[]{requestPermission}, requestCode);
                LogUtils.d(TAG, "showMessageOKCancel requestPermissions:" + requestPermission);
            }
        });
    }

    private static void showMessageOKCancel(final Activity context, String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(context).setMessage(message).setPositiveButton("确定", okListener).setNegativeButton("取消", null).create().show();
    }

    //打开设置页面
    private static void openSettingActivity(final Activity activity, String message) {
        showMessageOKCancel(activity, message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                LogUtils.d(TAG, "getPackageName(): " + activity.getPackageName());
                Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                intent.setData(uri);
                activity.startActivity(intent);
            }
        });
    }
}