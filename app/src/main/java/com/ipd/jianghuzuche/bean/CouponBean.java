package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/8.
 */
public class CouponBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"userCouponList":[{"userCouponId":87,"userId":7,"status":1,"title":"满1000减500","money":500,"endTime":null,"couponId":1,"createTime":"2019-06-06 10:06:34","coupon":null,"telPhone":null,"params":{},"achieveMoney":null,"validityTime":null}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<UserCouponListBean> userCouponList;

        public List<UserCouponListBean> getUserCouponList() {
            return userCouponList;
        }

        public void setUserCouponList(List<UserCouponListBean> userCouponList) {
            this.userCouponList = userCouponList;
        }

        public static class UserCouponListBean {
            /**
             * userCouponId : 87
             * userId : 7
             * status : 1
             * title : 满1000减500
             * money : 500.0
             * endTime : null
             * couponId : 1
             * createTime : 2019-06-06 10:06:34
             * coupon : null
             * telPhone : null
             * params : {}
             * achieveMoney : null
             * validityTime : null
             */

            private int userCouponId;
            private int userId;
            private int status;
            private String title;
            private double money;
            private Object endTime;
            private int couponId;
            private String createTime;
            private Object coupon;
            private Object telPhone;
            private ParamsBean params;
            private Object achieveMoney;
            private String validityTime;
            private boolean isShow;

            public boolean isShow() {
                return isShow;
            }

            public void setShow(boolean show) {
                isShow = show;
            }

            public int getUserCouponId() {
                return userCouponId;
            }

            public void setUserCouponId(int userCouponId) {
                this.userCouponId = userCouponId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public Object getEndTime() {
                return endTime;
            }

            public void setEndTime(Object endTime) {
                this.endTime = endTime;
            }

            public int getCouponId() {
                return couponId;
            }

            public void setCouponId(int couponId) {
                this.couponId = couponId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getCoupon() {
                return coupon;
            }

            public void setCoupon(Object coupon) {
                this.coupon = coupon;
            }

            public Object getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(Object telPhone) {
                this.telPhone = telPhone;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public Object getAchieveMoney() {
                return achieveMoney;
            }

            public void setAchieveMoney(Object achieveMoney) {
                this.achieveMoney = achieveMoney;
            }

            public String getValidityTime() {
                return validityTime;
            }

            public void setValidityTime(String validityTime) {
                this.validityTime = validityTime;
            }

            public static class ParamsBean {
            }
        }
    }
}
