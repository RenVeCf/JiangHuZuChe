package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class RepairOrderBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"orderList":[{"orderId":21,"userId":7,"orderNo":"1902319581","successTime":null,"payWay":0,"payTime":"2019-05-22 11:33:55","payStatus":2,"storeId":1,"status":4,"telPhone":"18502994087","userName":"jhzc427601","totalMoney":null,"createTime":"2019-05-22 11:33:43","charges":"充电包天x2、","repairs":"前泥瓦、优惠卷、","storeName":"上海虹桥1店","descAddress":"上海市华徐公路888号","logo":"picture/profile/JYJY192833259320190521103803.png","payMoney":null,"params":{}}]}
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
        private List<OrderListBean> orderList;

        public List<OrderListBean> getOrderList() {
            return orderList;
        }

        public void setOrderList(List<OrderListBean> orderList) {
            this.orderList = orderList;
        }

        public static class OrderListBean {
            /**
             * orderId : 21
             * userId : 7
             * orderNo : 1902319581
             * successTime : null
             * payWay : 0
             * payTime : 2019-05-22 11:33:55
             * payStatus : 2
             * storeId : 1
             * status : 4
             * telPhone : 18502994087
             * userName : jhzc427601
             * totalMoney : null
             * createTime : 2019-05-22 11:33:43
             * charges : 充电包天x2、
             * repairs : 前泥瓦、优惠卷、
             * storeName : 上海虹桥1店
             * descAddress : 上海市华徐公路888号
             * logo : picture/profile/JYJY192833259320190521103803.png
             * payMoney : null
             * params : {}
             */

            private int orderId;
            private int userId;
            private String orderNo;
            private Object successTime;
            private int payWay;
            private String payTime;
            private int payStatus;
            private int storeId;
            private int status;
            private String telPhone;
            private String userName;
            private Object totalMoney;
            private String createTime;
            private String charges;
            private String repairs;
            private String storeName;
            private String descAddress;
            private String logo;
            private Object payMoney;
            private ParamsBean params;

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public Object getSuccessTime() {
                return successTime;
            }

            public void setSuccessTime(Object successTime) {
                this.successTime = successTime;
            }

            public int getPayWay() {
                return payWay;
            }

            public void setPayWay(int payWay) {
                this.payWay = payWay;
            }

            public String getPayTime() {
                return payTime;
            }

            public void setPayTime(String payTime) {
                this.payTime = payTime;
            }

            public int getPayStatus() {
                return payStatus;
            }

            public void setPayStatus(int payStatus) {
                this.payStatus = payStatus;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(String telPhone) {
                this.telPhone = telPhone;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public Object getTotalMoney() {
                return totalMoney;
            }

            public void setTotalMoney(Object totalMoney) {
                this.totalMoney = totalMoney;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCharges() {
                return charges;
            }

            public void setCharges(String charges) {
                this.charges = charges;
            }

            public String getRepairs() {
                return repairs;
            }

            public void setRepairs(String repairs) {
                this.repairs = repairs;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public String getDescAddress() {
                return descAddress;
            }

            public void setDescAddress(String descAddress) {
                this.descAddress = descAddress;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public Object getPayMoney() {
                return payMoney;
            }

            public void setPayMoney(Object payMoney) {
                this.payMoney = payMoney;
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
