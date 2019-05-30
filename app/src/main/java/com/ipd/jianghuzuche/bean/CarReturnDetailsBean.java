package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class CarReturnDetailsBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehicleEndcost":[{"endcostId":1,"deposit":null,"equipCost":null,"tenancyService":150,"total":331.6,"orderId":7,"coupon":20,"vehicleRent":50,"rentDuration":3,"chargeMoney":199,"lateMoney":2.6,"createTime":"2019-05-28 10:11:24"}],"vehicleOrstatus":[{"orstatusId":121,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":7,"statusId":9,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":122,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":7,"statusId":8,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":123,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":7,"statusId":7,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":124,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":7,"statusId":6,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":125,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":7,"statusId":5,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":126,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":7,"statusId":14,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":127,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":7,"statusId":13,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":128,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":7,"statusId":12,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":129,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":7,"statusId":11,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":130,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":7,"statusId":10,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":131,"vestatusName":"轮胎","damagedCost":10,"status":1,"orderId":7,"statusId":19,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":132,"vestatusName":"大灯","damagedCost":10,"status":1,"orderId":7,"statusId":18,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":133,"vestatusName":"外壳","damagedCost":10,"status":1,"orderId":7,"statusId":17,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":134,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":7,"statusId":16,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":135,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":7,"statusId":15,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":136,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":7,"statusId":24,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":137,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":7,"statusId":23,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":138,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":7,"statusId":22,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":139,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":7,"statusId":21,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":140,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":7,"statusId":20,"userId":null,"createTime":"2019-05-28 10:14:20","type":null}],"vehicleCost":{"costId":7,"deposit":1000,"equipCost":100,"tenancyService":150,"total":1230,"orderId":7,"coupon":"20.00","createTime":"2019-05-28 10:08:28","vehicleRent":50,"chargeMoney":0,"rentDuration":3,"lateMoney":null,"overdueMoney":0,"refundMoney":600,"defaultMoney":400},"vehiclePic":{"vehicleInfoId":5,"picPath":"picture/vehicle/JYJY196515704420190528101411.jpeg,picture/vehicle/JYJY196557242020190528101415.jpeg,picture/vehicle/JYJY196594634820190528101419.jpeg","plateNumber":"8888","orderId":7,"createTime":null,"type":null},"status":2,"order":{"orderId":7,"userId":7,"orderNo":"1930844822","successTime":"2019-05-28 10:08:28","payWay":2,"payTime":"2019-05-28 10:08:28","payStatus":2,"vehicleId":11,"storeId":7,"takevehicleTime":"2019-05-28","rentDuration":6,"status":5,"createTime":"2019-05-28","telPhone":"18502994087","week":"周二","takeStatus":2,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192842740420190522151444.jpg","storeName":"阳阳车行","descAddress":"诚爱路58号","payMoney":1230,"revehicleTime":null,"expireTime":"2019-08-26","storeStatus":2,"city":"上海市","supId":8,"refundMoney":null,"params":{}}}
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
         * vehicleEndcost : [{"endcostId":1,"deposit":null,"equipCost":null,"tenancyService":150,"total":331.6,"orderId":7,"coupon":20,"vehicleRent":50,"rentDuration":3,"chargeMoney":199,"lateMoney":2.6,"createTime":"2019-05-28 10:11:24"}]
         * vehicleOrstatus : [{"orstatusId":121,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":7,"statusId":9,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":122,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":7,"statusId":8,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":123,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":7,"statusId":7,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":124,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":7,"statusId":6,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":125,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":7,"statusId":5,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":126,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":7,"statusId":14,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":127,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":7,"statusId":13,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":128,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":7,"statusId":12,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":129,"vestatusName":"车体","damagedCost":20,"status":1,"orderId":7,"statusId":11,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":130,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":7,"statusId":10,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":131,"vestatusName":"轮胎","damagedCost":10,"status":1,"orderId":7,"statusId":19,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":132,"vestatusName":"大灯","damagedCost":10,"status":1,"orderId":7,"statusId":18,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":133,"vestatusName":"外壳","damagedCost":10,"status":1,"orderId":7,"statusId":17,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":134,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":7,"statusId":16,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":135,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":7,"statusId":15,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":136,"vestatusName":"轮胎","damagedCost":50,"status":1,"orderId":7,"statusId":24,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":137,"vestatusName":"大灯","damagedCost":40,"status":1,"orderId":7,"statusId":23,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":138,"vestatusName":"外壳","damagedCost":30,"status":1,"orderId":7,"statusId":22,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":139,"vestatusName":"车体","damagedCost":10,"status":1,"orderId":7,"statusId":21,"userId":null,"createTime":"2019-05-28 10:14:20","type":null},{"orstatusId":140,"vestatusName":"仪表","damagedCost":10,"status":1,"orderId":7,"statusId":20,"userId":null,"createTime":"2019-05-28 10:14:20","type":null}]
         * vehicleCost : {"costId":7,"deposit":1000,"equipCost":100,"tenancyService":150,"total":1230,"orderId":7,"coupon":"20.00","createTime":"2019-05-28 10:08:28","vehicleRent":50,"chargeMoney":0,"rentDuration":3,"lateMoney":null,"overdueMoney":0,"refundMoney":600,"defaultMoney":400}
         * vehiclePic : {"vehicleInfoId":5,"picPath":"picture/vehicle/JYJY196515704420190528101411.jpeg,picture/vehicle/JYJY196557242020190528101415.jpeg,picture/vehicle/JYJY196594634820190528101419.jpeg","plateNumber":"8888","orderId":7,"createTime":null,"type":null}
         * status : 2
         * order : {"orderId":7,"userId":7,"orderNo":"1930844822","successTime":"2019-05-28 10:08:28","payWay":2,"payTime":"2019-05-28 10:08:28","payStatus":2,"vehicleId":11,"storeId":7,"takevehicleTime":"2019-05-28","rentDuration":6,"status":5,"createTime":"2019-05-28","telPhone":"18502994087","week":"周二","takeStatus":2,"descStatus":null,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192842740420190522151444.jpg","storeName":"阳阳车行","descAddress":"诚爱路58号","payMoney":1230,"revehicleTime":null,"expireTime":"2019-08-26","storeStatus":2,"city":"上海市","supId":8,"refundMoney":null,"params":{}}
         */

        private VehicleCostBean vehicleCost;
        private VehiclePicBean vehiclePic;
        private int status;
        private OrderBean order;
        private List<VehicleEndcostBean> vehicleEndcost;
        private List<VehicleOrstatusBean> vehicleOrstatus;

        public VehicleCostBean getVehicleCost() {
            return vehicleCost;
        }

        public void setVehicleCost(VehicleCostBean vehicleCost) {
            this.vehicleCost = vehicleCost;
        }

        public VehiclePicBean getVehiclePic() {
            return vehiclePic;
        }

        public void setVehiclePic(VehiclePicBean vehiclePic) {
            this.vehiclePic = vehiclePic;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<VehicleEndcostBean> getVehicleEndcost() {
            return vehicleEndcost;
        }

        public void setVehicleEndcost(List<VehicleEndcostBean> vehicleEndcost) {
            this.vehicleEndcost = vehicleEndcost;
        }

        public List<VehicleOrstatusBean> getVehicleOrstatus() {
            return vehicleOrstatus;
        }

        public void setVehicleOrstatus(List<VehicleOrstatusBean> vehicleOrstatus) {
            this.vehicleOrstatus = vehicleOrstatus;
        }

        public static class VehicleCostBean {
            /**
             * costId : 7
             * deposit : 1000
             * equipCost : 100
             * tenancyService : 150
             * total : 1230
             * orderId : 7
             * coupon : 20.00
             * createTime : 2019-05-28 10:08:28
             * vehicleRent : 50
             * chargeMoney : 0
             * rentDuration : 3
             * lateMoney : null
             * overdueMoney : 0
             * refundMoney : 600
             * defaultMoney : 400
             */

            private int costId;
            private int deposit;
            private int equipCost;
            private int tenancyService;
            private int total;
            private int orderId;
            private String coupon;
            private String createTime;
            private int vehicleRent;
            private int chargeMoney;
            private int rentDuration;
            private Object lateMoney;
            private int overdueMoney;
            private int refundMoney;
            private int defaultMoney;

            public int getCostId() {
                return costId;
            }

            public void setCostId(int costId) {
                this.costId = costId;
            }

            public int getDeposit() {
                return deposit;
            }

            public void setDeposit(int deposit) {
                this.deposit = deposit;
            }

            public int getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(int equipCost) {
                this.equipCost = equipCost;
            }

            public int getTenancyService() {
                return tenancyService;
            }

            public void setTenancyService(int tenancyService) {
                this.tenancyService = tenancyService;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public String getCoupon() {
                return coupon;
            }

            public void setCoupon(String coupon) {
                this.coupon = coupon;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(int vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public int getChargeMoney() {
                return chargeMoney;
            }

            public void setChargeMoney(int chargeMoney) {
                this.chargeMoney = chargeMoney;
            }

            public int getRentDuration() {
                return rentDuration;
            }

            public void setRentDuration(int rentDuration) {
                this.rentDuration = rentDuration;
            }

            public Object getLateMoney() {
                return lateMoney;
            }

            public void setLateMoney(Object lateMoney) {
                this.lateMoney = lateMoney;
            }

            public int getOverdueMoney() {
                return overdueMoney;
            }

            public void setOverdueMoney(int overdueMoney) {
                this.overdueMoney = overdueMoney;
            }

            public int getRefundMoney() {
                return refundMoney;
            }

            public void setRefundMoney(int refundMoney) {
                this.refundMoney = refundMoney;
            }

            public int getDefaultMoney() {
                return defaultMoney;
            }

            public void setDefaultMoney(int defaultMoney) {
                this.defaultMoney = defaultMoney;
            }
        }

        public static class VehiclePicBean {
            /**
             * vehicleInfoId : 5
             * picPath : picture/vehicle/JYJY196515704420190528101411.jpeg,picture/vehicle/JYJY196557242020190528101415.jpeg,picture/vehicle/JYJY196594634820190528101419.jpeg
             * plateNumber : 8888
             * orderId : 7
             * createTime : null
             * type : null
             */

            private int vehicleInfoId;
            private String picPath;
            private String plateNumber;
            private int orderId;
            private Object createTime;
            private Object type;

            public int getVehicleInfoId() {
                return vehicleInfoId;
            }

            public void setVehicleInfoId(int vehicleInfoId) {
                this.vehicleInfoId = vehicleInfoId;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public String getPlateNumber() {
                return plateNumber;
            }

            public void setPlateNumber(String plateNumber) {
                this.plateNumber = plateNumber;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }
        }

        public static class OrderBean {
            /**
             * orderId : 7
             * userId : 7
             * orderNo : 1930844822
             * successTime : 2019-05-28 10:08:28
             * payWay : 2
             * payTime : 2019-05-28 10:08:28
             * payStatus : 2
             * vehicleId : 11
             * storeId : 7
             * takevehicleTime : 2019-05-28
             * rentDuration : 6
             * status : 5
             * createTime : 2019-05-28
             * telPhone : 18502994087
             * week : 周二
             * takeStatus : 2
             * descStatus : null
             * vehicleName : 小刀电动车
             * vehicleModel : xs25445
             * vehicleLogo : picture/profile/JYJY192842740420190522151444.jpg
             * storeName : 阳阳车行
             * descAddress : 诚爱路58号
             * payMoney : 1230
             * revehicleTime : null
             * expireTime : 2019-08-26
             * storeStatus : 2
             * city : 上海市
             * supId : 8
             * refundMoney : null
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
            private int payMoney;
            private Object revehicleTime;
            private String expireTime;
            private int storeStatus;
            private String city;
            private int supId;
            private Object refundMoney;
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

            public int getPayMoney() {
                return payMoney;
            }

            public void setPayMoney(int payMoney) {
                this.payMoney = payMoney;
            }

            public Object getRevehicleTime() {
                return revehicleTime;
            }

            public void setRevehicleTime(Object revehicleTime) {
                this.revehicleTime = revehicleTime;
            }

            public String getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(String expireTime) {
                this.expireTime = expireTime;
            }

            public int getStoreStatus() {
                return storeStatus;
            }

            public void setStoreStatus(int storeStatus) {
                this.storeStatus = storeStatus;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getSupId() {
                return supId;
            }

            public void setSupId(int supId) {
                this.supId = supId;
            }

            public Object getRefundMoney() {
                return refundMoney;
            }

            public void setRefundMoney(Object refundMoney) {
                this.refundMoney = refundMoney;
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

        public static class VehicleEndcostBean {
            /**
             * endcostId : 1
             * deposit : null
             * equipCost : null
             * tenancyService : 150
             * total : 331.6
             * orderId : 7
             * coupon : 20
             * vehicleRent : 50
             * rentDuration : 3
             * chargeMoney : 199
             * lateMoney : 2.6
             * createTime : 2019-05-28 10:11:24
             */

            private int endcostId;
            private Object deposit;
            private Object equipCost;
            private int tenancyService;
            private double total;
            private int orderId;
            private int coupon;
            private int vehicleRent;
            private int rentDuration;
            private int chargeMoney;
            private double lateMoney;
            private String createTime;

            public int getEndcostId() {
                return endcostId;
            }

            public void setEndcostId(int endcostId) {
                this.endcostId = endcostId;
            }

            public Object getDeposit() {
                return deposit;
            }

            public void setDeposit(Object deposit) {
                this.deposit = deposit;
            }

            public Object getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(Object equipCost) {
                this.equipCost = equipCost;
            }

            public int getTenancyService() {
                return tenancyService;
            }

            public void setTenancyService(int tenancyService) {
                this.tenancyService = tenancyService;
            }

            public double getTotal() {
                return total;
            }

            public void setTotal(double total) {
                this.total = total;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getCoupon() {
                return coupon;
            }

            public void setCoupon(int coupon) {
                this.coupon = coupon;
            }

            public int getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(int vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public int getRentDuration() {
                return rentDuration;
            }

            public void setRentDuration(int rentDuration) {
                this.rentDuration = rentDuration;
            }

            public int getChargeMoney() {
                return chargeMoney;
            }

            public void setChargeMoney(int chargeMoney) {
                this.chargeMoney = chargeMoney;
            }

            public double getLateMoney() {
                return lateMoney;
            }

            public void setLateMoney(double lateMoney) {
                this.lateMoney = lateMoney;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }

        public static class VehicleOrstatusBean {
            /**
             * orstatusId : 121
             * vestatusName : 轮胎
             * damagedCost : 50
             * status : 1
             * orderId : 7
             * statusId : 9
             * userId : null
             * createTime : 2019-05-28 10:14:20
             * type : null
             */

            private int orstatusId;
            private String vestatusName;
            private int damagedCost;
            private int status;
            private int orderId;
            private int statusId;
            private Object userId;
            private String createTime;
            private Object type;

            public int getOrstatusId() {
                return orstatusId;
            }

            public void setOrstatusId(int orstatusId) {
                this.orstatusId = orstatusId;
            }

            public String getVestatusName() {
                return vestatusName;
            }

            public void setVestatusName(String vestatusName) {
                this.vestatusName = vestatusName;
            }

            public int getDamagedCost() {
                return damagedCost;
            }

            public void setDamagedCost(int damagedCost) {
                this.damagedCost = damagedCost;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getStatusId() {
                return statusId;
            }

            public void setStatusId(int statusId) {
                this.statusId = statusId;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }
        }
    }
}
