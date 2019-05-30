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
     * data : {"userCouponList":[{"couponId":1,"title":"满200减50元","money":50,"validityTime":"2019-05-10 00:00:00","status":null,"achieveMoney":200,"createTime":"2019-05-08 15:47:30","params":{}},{"couponId":2,"title":"满100减20","money":20,"validityTime":"2019-05-03 00:00:00","status":null,"achieveMoney":100,"createTime":"2019-05-08 15:48:00","params":{}}]}
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
             * couponId : 1
             * title : 满200减50元
             * money : 50.0
             * validityTime : 2019-05-10 00:00:00
             * status : null
             * achieveMoney : 200.0
             * createTime : 2019-05-08 15:47:30
             * params : {}
             */

            private int couponId;
            private String title;
            private double money;
            private String validityTime;
            private Object status;
            private double achieveMoney;
            private String createTime;
            private ParamsBean params;
            private boolean isShwo;

            public boolean isShwo() {
                return isShwo;
            }

            public void setShwo(boolean shwo) {
                isShwo = shwo;
            }

            public int getCouponId() {
                return couponId;
            }

            public void setCouponId(int couponId) {
                this.couponId = couponId;
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

            public String getValidityTime() {
                return validityTime;
            }

            public void setValidityTime(String validityTime) {
                this.validityTime = validityTime;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public double getAchieveMoney() {
                return achieveMoney;
            }

            public void setAchieveMoney(double achieveMoney) {
                this.achieveMoney = achieveMoney;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public static class ParamsBean {
            }
        }
    }
}
