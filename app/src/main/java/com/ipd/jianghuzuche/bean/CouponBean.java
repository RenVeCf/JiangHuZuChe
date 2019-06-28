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
     * data : {"userCouponList":[{"userCouponId":23,"userId":7,"status":1,"title":"满1000减500","money":500,"endTime":null,"couponId":1,"createTime":"2019-06-13 15:31:29","coupon":null,"telPhone":null,"params":{},"achieveMoney":1000,"validityTime":"2019-12-13"},{"userCouponId":11,"userId":7,"status":1,"title":"满1000减500","money":500,"endTime":null,"couponId":1,"createTime":"2019-06-12 16:28:26","coupon":null,"telPhone":null,"params":{},"achieveMoney":1000,"validityTime":"2019-12-09"},{"userCouponId":9,"userId":7,"status":1,"title":"满1000减500","money":500,"endTime":null,"couponId":1,"createTime":"2019-06-12 15:38:21","coupon":null,"telPhone":null,"params":{},"achieveMoney":1000,"validityTime":"2019-12-09"},{"userCouponId":8,"userId":7,"status":1,"title":"满1000减500","money":500,"endTime":null,"couponId":1,"createTime":"2019-06-12 15:37:35","coupon":null,"telPhone":null,"params":{},"achieveMoney":1000,"validityTime":"2019-12-09"},{"userCouponId":1,"userId":7,"status":1,"title":"满1000减500","money":500,"endTime":null,"couponId":1,"createTime":"2019-06-12 14:13:47","coupon":null,"telPhone":null,"params":{},"achieveMoney":1000,"validityTime":"2019-12-09"}]}
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
             * userCouponId : 23
             * userId : 7
             * status : 1
             * title : 满1000减500
             * money : 500.0
             * endTime : null
             * couponId : 1
             * createTime : 2019-06-13 15:31:29
             * coupon : null
             * telPhone : null
             * params : {}
             * achieveMoney : 1000.0
             * validityTime : 2019-12-13
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
            private double achieveMoney;
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

            public double getAchieveMoney() {
                return achieveMoney;
            }

            public void setAchieveMoney(double achieveMoney) {
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
