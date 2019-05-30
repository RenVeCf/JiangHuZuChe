package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class SelectOrderTypeBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"orderList":[{"orderId":54,"userId":3,"orderNo":"1970437324","successTime":"2019-05-13 14:41:44","payWay":1,"payTime":"2019-05-13 14:41:44","payStatus":2,"vehicleId":16,"storeId":7,"takevehicleTime":"2019-05-13 00:00:00","rentDuration":5,"status":4,"createTime":"2019-05-13 14:41:44","telPhone":"18502994087","week":"1","takeStatus":1,"descStatus":null,"vehicleName":"野马跑车","vehicleModel":"YM-58","vehicleLogo":"picture/profile/JYJY199936105620190506140953.jpg","storeName":"韵达","descAddress":"北京市东城区","payMoney":1600,"revehicleTime":null,"params":{}},{"orderId":52,"userId":26,"orderNo":"1957864441","successTime":"2019-05-13 11:02:58","payWay":1,"payTime":"2019-05-13 11:02:58","payStatus":2,"vehicleId":6,"storeId":2,"takevehicleTime":"2019-05-13 00:00:00","rentDuration":3,"status":4,"createTime":"2019-05-13 11:02:58","telPhone":"15021661148","week":"周一","takeStatus":1,"descStatus":null,"vehicleName":"急速跑车","vehicleModel":"gs-890","vehicleLogo":"picture/profile/JYJY195851830720190506140305.jpg","storeName":"涵予汽车店","descAddress":"上海市青浦区华徐公路888号中国梦谷","payMoney":5750,"revehicleTime":null,"params":{}},{"orderId":51,"userId":26,"orderNo":"1956150410","successTime":"2019-05-13 11:02:41","payWay":1,"payTime":"2019-05-13 11:02:41","payStatus":2,"vehicleId":5,"storeId":2,"takevehicleTime":"2019-05-13 00:00:00","rentDuration":2,"status":4,"createTime":"2019-05-13 11:02:41","telPhone":"15021661148","week":"周一","takeStatus":1,"descStatus":null,"vehicleName":"雅迪电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY195431616820190506140223.jpg","storeName":"涵予汽车店","descAddress":"上海市青浦区华徐公路888号中国梦谷","payMoney":4200,"revehicleTime":null,"params":{}},{"orderId":48,"userId":26,"orderNo":"1916925739","successTime":"2019-05-10 13:46:09","payWay":1,"payTime":"2019-05-10 13:46:09","payStatus":2,"vehicleId":5,"storeId":2,"takevehicleTime":"2019-05-10 00:00:00","rentDuration":1,"status":4,"createTime":"2019-05-10 13:46:09","telPhone":"15021661148","week":"周五","takeStatus":1,"descStatus":null,"vehicleName":"雅迪电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY195431616820190506140223.jpg","storeName":"涵予汽车店","descAddress":"上海市青浦区华徐公路888号中国梦谷","payMoney":2650,"revehicleTime":null,"params":{}},{"orderId":45,"userId":26,"orderNo":"1934884786","successTime":"2019-05-09 16:42:28","payWay":1,"payTime":"2019-05-09 16:42:28","payStatus":2,"vehicleId":5,"storeId":2,"takevehicleTime":"2019-05-09 00:00:00","rentDuration":2,"status":4,"createTime":"2019-05-09 16:42:28","telPhone":"15021661148","week":"周四","takeStatus":1,"descStatus":null,"vehicleName":"雅迪电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY195431616820190506140223.jpg","storeName":"涵予汽车店","descAddress":"上海市青浦区华徐公路888号中国梦谷","payMoney":4200,"revehicleTime":null,"params":{}}]}
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
             * orderId : 54
             * userId : 3
             * orderNo : 1970437324
             * successTime : 2019-05-13 14:41:44
             * payWay : 1
             * payTime : 2019-05-13 14:41:44
             * payStatus : 2
             * vehicleId : 16
             * storeId : 7
             * takevehicleTime : 2019-05-13 00:00:00
             * rentDuration : 5
             * status : 4
             * createTime : 2019-05-13 14:41:44
             * telPhone : 18502994087
             * week : 1
             * takeStatus : 1
             * descStatus : null
             * vehicleName : 野马跑车
             * vehicleModel : YM-58
             * vehicleLogo : picture/profile/JYJY199936105620190506140953.jpg
             * storeName : 韵达
             * descAddress : 北京市东城区
             * payMoney : 1600.0
             * revehicleTime : null
             * params : {}
             */

            private int orderId;
            private int userId;
            private String orderNo;
            private String successTime;
            private int payWay;
            private String payTime;
            private int payStatus;
            private int vehicleId;
            private int storeId;
            private String takevehicleTime;
            private int rentDuration;
            private int status;
            private String createTime;
            private String telPhone;
            private String week;
            private int takeStatus;
            private Object descStatus;
            private String vehicleName;
            private String vehicleModel;
            private String vehicleLogo;
            private String storeName;
            private String descAddress;
            private double payMoney;
            private Object revehicleTime;
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

            public String getSuccessTime() {
                return successTime;
            }

            public void setSuccessTime(String successTime) {
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

            public int getVehicleId() {
                return vehicleId;
            }

            public void setVehicleId(int vehicleId) {
                this.vehicleId = vehicleId;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public String getTakevehicleTime() {
                return takevehicleTime;
            }

            public void setTakevehicleTime(String takevehicleTime) {
                this.takevehicleTime = takevehicleTime;
            }

            public int getRentDuration() {
                return rentDuration;
            }

            public void setRentDuration(int rentDuration) {
                this.rentDuration = rentDuration;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(String telPhone) {
                this.telPhone = telPhone;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public int getTakeStatus() {
                return takeStatus;
            }

            public void setTakeStatus(int takeStatus) {
                this.takeStatus = takeStatus;
            }

            public Object getDescStatus() {
                return descStatus;
            }

            public void setDescStatus(Object descStatus) {
                this.descStatus = descStatus;
            }

            public String getVehicleName() {
                return vehicleName;
            }

            public void setVehicleName(String vehicleName) {
                this.vehicleName = vehicleName;
            }

            public String getVehicleModel() {
                return vehicleModel;
            }

            public void setVehicleModel(String vehicleModel) {
                this.vehicleModel = vehicleModel;
            }

            public String getVehicleLogo() {
                return vehicleLogo;
            }

            public void setVehicleLogo(String vehicleLogo) {
                this.vehicleLogo = vehicleLogo;
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

            public double getPayMoney() {
                return payMoney;
            }

            public void setPayMoney(double payMoney) {
                this.payMoney = payMoney;
            }

            public Object getRevehicleTime() {
                return revehicleTime;
            }

            public void setRevehicleTime(Object revehicleTime) {
                this.revehicleTime = revehicleTime;
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
