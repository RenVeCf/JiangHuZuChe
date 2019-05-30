package com.ipd.jianghuzuche.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/8.
 */
public class OrderPayBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"basicCost":{"total":"111","tenancyService":1,"equipCost":1,"deposit":1},"order":{"orderId":23,"userId":1,"orderNo":"","successTime":null,"payWay":0,"payTime":null,"payStatus":0,"vehicleId":2,"storeId":1,"takevehicleTime":1,"rentDuration":1,"status":1,"createTime":"2019-04-18 17:04:02","telPhone":"","week":"星期一","vehicleName":"车辆名字","vehicleModel":"1233123","vehicleLogo":"picture/JYJY190095152420190416150009.png","storeName":"门店名字","descAddress":"详细地址"}}
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
        /**
         * basicCost : {"total":"111","tenancyService":1,"equipCost":1,"deposit":1}
         * order : {"orderId":23,"userId":1,"orderNo":"","successTime":null,"payWay":0,"payTime":null,"payStatus":0,"vehicleId":2,"storeId":1,"takevehicleTime":1,"rentDuration":1,"status":1,"createTime":"2019-04-18 17:04:02","telPhone":"","week":"星期一","vehicleName":"车辆名字","vehicleModel":"1233123","vehicleLogo":"picture/JYJY190095152420190416150009.png","storeName":"门店名字","descAddress":"详细地址"}
         */

        private BasicCostBean basicCost;
        private OrderBean order;

        public BasicCostBean getBasicCost() {
            return basicCost;
        }

        public void setBasicCost(BasicCostBean basicCost) {
            this.basicCost = basicCost;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public static class BasicCostBean {
            /**
             * total : 111
             * tenancyService : 1
             * equipCost : 1
             * deposit : 1
             */

            private String total;
            private int tenancyService;
            private int equipCost;
            private int deposit;

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public int getTenancyService() {
                return tenancyService;
            }

            public void setTenancyService(int tenancyService) {
                this.tenancyService = tenancyService;
            }

            public int getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(int equipCost) {
                this.equipCost = equipCost;
            }

            public int getDeposit() {
                return deposit;
            }

            public void setDeposit(int deposit) {
                this.deposit = deposit;
            }
        }

        public static class OrderBean {
            /**
             * orderId : 23
             * userId : 1
             * orderNo :
             * successTime : null
             * payWay : 0
             * payTime : null
             * payStatus : 0
             * vehicleId : 2
             * storeId : 1
             * takevehicleTime : 1
             * rentDuration : 1
             * status : 1
             * createTime : 2019-04-18 17:04:02
             * telPhone :
             * week : 星期一
             * vehicleName : 车辆名字
             * vehicleModel : 1233123
             * vehicleLogo : picture/JYJY190095152420190416150009.png
             * storeName : 门店名字
             * descAddress : 详细地址
             */

            private int orderId;
            private int userId;
            private String orderNo;
            private Object successTime;
            private int payWay;
            private Object payTime;
            private int payStatus;
            private int vehicleId;
            private int storeId;
            private int takevehicleTime;
            private int rentDuration;
            private int status;
            private String createTime;
            private String telPhone;
            private String week;
            private String vehicleName;
            private String vehicleModel;
            private String vehicleLogo;
            private String storeName;
            private String descAddress;

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

            public Object getPayTime() {
                return payTime;
            }

            public void setPayTime(Object payTime) {
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

            public int getTakevehicleTime() {
                return takevehicleTime;
            }

            public void setTakevehicleTime(int takevehicleTime) {
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
        }
    }
}
