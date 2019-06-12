package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class OrderDetailsBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehicleEndcost":[{"endcostId":3,"deposit":null,"equipCost":null,"tenancyService":300,"total":1280.6,"orderId":35,"coupon":20,"vehicleRent":null,"rentDuration":3,"chargeMoney":998,"lateMoney":2.6,"createTime":"2019-05-27 15:13:18"}],"vehicleOrstatus":[{"orstatusId":56,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":35,"statusId":29,"userId":null,"createTime":"2019-05-23 11:05:50","type":null},{"orstatusId":57,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":35,"statusId":28,"userId":null,"createTime":"2019-05-23 11:05:50","type":null},{"orstatusId":58,"vestatusName":"尾部","damagedCost":11,"status":2,"orderId":35,"statusId":6,"userId":null,"createTime":"2019-05-23 11:05:50","type":null},{"orstatusId":59,"vestatusName":"头部","damagedCost":11,"status":2,"orderId":35,"statusId":5,"userId":null,"createTime":"2019-05-23 11:05:50","type":null}],"vehicleCost":[{"costId":40,"deposit":1000,"equipCost":100,"tenancyService":300,"total":1400,"orderId":35,"coupon":"0.00","createTime":"2019-05-23 11:03:56","vehicleRent":50,"chargeMoney":null,"rentDuration":3,"lateMoney":null}],"vehiclePic":{"vehicleInfoId":13,"picPath":"picture/vehicle/JYJY197262227120190523110526.jpeg,picture/vehicle/JYJY197441257120190523110544.jpeg,picture/vehicle/JYJY197486811020190523110548.jpeg","plateNumber":"88888","orderId":35,"createTime":null,"type":null},"order":{"orderId":35,"userId":7,"orderNo":"1963699680","successTime":"2019-05-23 11:03:56","payWay":2,"payTime":"2019-05-23 11:03:56","payStatus":2,"vehicleId":10,"storeId":7,"takevehicleTime":"2019-05-23","rentDuration":6,"status":5,"createTime":"2019-05-23","telPhone":"18502994087","week":"周四","takeStatus":1,"descStatus":2,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192671649320190522151427.jpg","storeName":"阳阳车行","descAddress":"上海市青浦区明珠路","payMoney":1400,"revehicleTime":null,"expireTime":"2019-08-21","storeStatus":null,"city":"上海市","supId":null,"params":{}}}
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
         * vehicleEndcost : [{"endcostId":3,"deposit":null,"equipCost":null,"tenancyService":300,"total":1280.6,"orderId":35,"coupon":20,"vehicleRent":null,"rentDuration":3,"chargeMoney":998,"lateMoney":2.6,"createTime":"2019-05-27 15:13:18"}]
         * vehicleOrstatus : [{"orstatusId":56,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":35,"statusId":29,"userId":null,"createTime":"2019-05-23 11:05:50","type":null},{"orstatusId":57,"vestatusName":"测试01","damagedCost":111,"status":1,"orderId":35,"statusId":28,"userId":null,"createTime":"2019-05-23 11:05:50","type":null},{"orstatusId":58,"vestatusName":"尾部","damagedCost":11,"status":2,"orderId":35,"statusId":6,"userId":null,"createTime":"2019-05-23 11:05:50","type":null},{"orstatusId":59,"vestatusName":"头部","damagedCost":11,"status":2,"orderId":35,"statusId":5,"userId":null,"createTime":"2019-05-23 11:05:50","type":null}]
         * vehicleCost : [{"costId":40,"deposit":1000,"equipCost":100,"tenancyService":300,"total":1400,"orderId":35,"coupon":"0.00","createTime":"2019-05-23 11:03:56","vehicleRent":50,"chargeMoney":null,"rentDuration":3,"lateMoney":null}]
         * vehiclePic : {"vehicleInfoId":13,"picPath":"picture/vehicle/JYJY197262227120190523110526.jpeg,picture/vehicle/JYJY197441257120190523110544.jpeg,picture/vehicle/JYJY197486811020190523110548.jpeg","plateNumber":"88888","orderId":35,"createTime":null,"type":null}
         * order : {"orderId":35,"userId":7,"orderNo":"1963699680","successTime":"2019-05-23 11:03:56","payWay":2,"payTime":"2019-05-23 11:03:56","payStatus":2,"vehicleId":10,"storeId":7,"takevehicleTime":"2019-05-23","rentDuration":6,"status":5,"createTime":"2019-05-23","telPhone":"18502994087","week":"周四","takeStatus":1,"descStatus":2,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192671649320190522151427.jpg","storeName":"阳阳车行","descAddress":"上海市青浦区明珠路","payMoney":1400,"revehicleTime":null,"expireTime":"2019-08-21","storeStatus":null,"city":"上海市","supId":null,"params":{}}
         * store : {"storeId":7,"storeName":"阳阳车行","picPath":"picture/vehicle/JYJY197809371720190522221940.jpeg,picture/vehicle/JYJY197875619520190522221947.jpeg,picture/vehicle/JYJY197909872020190522221950.jpeg","contactsPhone":"18502994087","contactsName":null,"descAddress":"诚爱路58号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-27 21:02:31","repairId":null,"repairNames":"","chargeId":"1,2","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.28255","latitude":"31.181091","totalNum":null,"availableNum":null,"params":{}}
         */

        private VehiclePicBean vehiclePic;
        private OrderBean order;
        private StoreBean store;
        private List<VehicleEndcostBean> vehicleEndcost;
        private List<VehicleOrstatusBean> vehicleOrstatus;
        private List<VehicleCostBean> vehicleCost;

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public VehiclePicBean getVehiclePic() {
            return vehiclePic;
        }

        public void setVehiclePic(VehiclePicBean vehiclePic) {
            this.vehiclePic = vehiclePic;
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

        public List<VehicleCostBean> getVehicleCost() {
            return vehicleCost;
        }

        public void setVehicleCost(List<VehicleCostBean> vehicleCost) {
            this.vehicleCost = vehicleCost;
        }

        public static class VehiclePicBean {
            /**
             * vehicleInfoId : 13
             * picPath : picture/vehicle/JYJY197262227120190523110526.jpeg,picture/vehicle/JYJY197441257120190523110544.jpeg,picture/vehicle/JYJY197486811020190523110548.jpeg
             * plateNumber : 88888
             * orderId : 35
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

        public static class StoreBean {
            /**
             * storeId : 7
             * storeName : 阳阳车行
             * picPath : picture/vehicle/JYJY197809371720190522221940.jpeg,picture/vehicle/JYJY197875619520190522221947.jpeg,picture/vehicle/JYJY197909872020190522221950.jpeg
             * contactsPhone : 18502994087
             * contactsName : null
             * descAddress : 诚爱路58号
             * province : 上海
             * city : 上海市
             * area : 青浦区
             * createTime : 2019-05-27 21:02:31
             * repairId : null
             * repairNames :
             * chargeId : 1,2
             * distance : 3.6
             * status : null
             * userName : null
             * telPhone : null
             * userId : null
             * logo : picture/profile/JYJY196446766020190527191404.jpg
             * stock : null
             * longitude : 121.28255
             * latitude : 31.181091
             * totalNum : null
             * availableNum : null
             * params : {}
             */

            private int storeId;
            private String storeName;
            private String picPath;
            private String contactsPhone;
            private Object contactsName;
            private String descAddress;
            private String province;
            private String city;
            private String area;
            private String createTime;
            private Object repairId;
            private String repairNames;
            private String chargeId;
            private double distance;
            private Object status;
            private Object userName;
            private Object telPhone;
            private Object userId;
            private String logo;
            private Object stock;
            private String longitude;
            private String latitude;
            private Object totalNum;
            private Object availableNum;
            private ParamsBean params;

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public String getContactsPhone() {
                return contactsPhone;
            }

            public void setContactsPhone(String contactsPhone) {
                this.contactsPhone = contactsPhone;
            }

            public Object getContactsName() {
                return contactsName;
            }

            public void setContactsName(Object contactsName) {
                this.contactsName = contactsName;
            }

            public String getDescAddress() {
                return descAddress;
            }

            public void setDescAddress(String descAddress) {
                this.descAddress = descAddress;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getRepairId() {
                return repairId;
            }

            public void setRepairId(Object repairId) {
                this.repairId = repairId;
            }

            public String getRepairNames() {
                return repairNames;
            }

            public void setRepairNames(String repairNames) {
                this.repairNames = repairNames;
            }

            public String getChargeId() {
                return chargeId;
            }

            public void setChargeId(String chargeId) {
                this.chargeId = chargeId;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public Object getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(Object telPhone) {
                this.telPhone = telPhone;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public Object getStock() {
                return stock;
            }

            public void setStock(Object stock) {
                this.stock = stock;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public Object getTotalNum() {
                return totalNum;
            }

            public void setTotalNum(Object totalNum) {
                this.totalNum = totalNum;
            }

            public Object getAvailableNum() {
                return availableNum;
            }

            public void setAvailableNum(Object availableNum) {
                this.availableNum = availableNum;
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

        public static class OrderBean {
            /**
             * orderId : 35
             * userId : 7
             * orderNo : 1963699680
             * successTime : 2019-05-23 11:03:56
             * payWay : 2
             * payTime : 2019-05-23 11:03:56
             * payStatus : 2
             * vehicleId : 10
             * storeId : 7
             * takevehicleTime : 2019-05-23
             * rentDuration : 6
             * status : 5
             * createTime : 2019-05-23
             * telPhone : 18502994087
             * week : 周四
             * takeStatus : 1
             * descStatus : 2
             * vehicleName : 小刀电动车
             * vehicleModel : xs25445
             * vehicleLogo : picture/profile/JYJY192671649320190522151427.jpg
             * storeName : 阳阳车行
             * descAddress : 上海市青浦区明珠路
             * payMoney : 1400.0
             * revehicleTime : null
             * expireTime : 2019-08-21
             * storeStatus : null
             * city : 上海市
             * supId : null
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
            private int descStatus;
            private String vehicleName;
            private String vehicleModel;
            private String vehicleLogo;
            private String storeName;
            private String descAddress;
            private double payMoney;
            private Object revehicleTime;
            private String expireTime;
            private Object storeStatus;
            private String city;
            private Object supId;
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

            public int getDescStatus() {
                return descStatus;
            }

            public void setDescStatus(int descStatus) {
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

            public String getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(String expireTime) {
                this.expireTime = expireTime;
            }

            public Object getStoreStatus() {
                return storeStatus;
            }

            public void setStoreStatus(Object storeStatus) {
                this.storeStatus = storeStatus;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public Object getSupId() {
                return supId;
            }

            public void setSupId(Object supId) {
                this.supId = supId;
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
             * endcostId : 3
             * deposit : null
             * equipCost : null
             * tenancyService : 300.0
             * total : 1280.6
             * orderId : 35
             * coupon : 20.0
             * vehicleRent : null
             * rentDuration : 3
             * chargeMoney : 998.0
             * lateMoney : 2.6
             * createTime : 2019-05-27 15:13:18
             */

            private int endcostId;
            private Object deposit;
            private Object equipCost;
            private double tenancyService;
            private double total;
            private int orderId;
            private double coupon;
            private Object vehicleRent;
            private int rentDuration;
            private double chargeMoney;
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

            public double getTenancyService() {
                return tenancyService;
            }

            public void setTenancyService(double tenancyService) {
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

            public double getCoupon() {
                return coupon;
            }

            public void setCoupon(double coupon) {
                this.coupon = coupon;
            }

            public Object getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(Object vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public int getRentDuration() {
                return rentDuration;
            }

            public void setRentDuration(int rentDuration) {
                this.rentDuration = rentDuration;
            }

            public double getChargeMoney() {
                return chargeMoney;
            }

            public void setChargeMoney(double chargeMoney) {
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
             * orstatusId : 56
             * vestatusName : 测试01
             * damagedCost : 111.0
             * status : 1
             * orderId : 35
             * statusId : 29
             * userId : null
             * createTime : 2019-05-23 11:05:50
             * type : null
             */

            private int orstatusId;
            private String vestatusName;
            private double damagedCost;
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

            public double getDamagedCost() {
                return damagedCost;
            }

            public void setDamagedCost(double damagedCost) {
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

        public static class VehicleCostBean {
            /**
             * costId : 40
             * deposit : 1000.0
             * equipCost : 100.0
             * tenancyService : 300.0
             * total : 1400.0
             * orderId : 35
             * coupon : 0.00
             * createTime : 2019-05-23 11:03:56
             * vehicleRent : 50.0
             * chargeMoney : null
             * rentDuration : 3
             * lateMoney : null
             */

            private int costId;
            private double deposit;
            private double equipCost;
            private double tenancyService;
            private double total;
            private int orderId;
            private String coupon;
            private String createTime;
            private double vehicleRent;
            private Object chargeMoney;
            private int rentDuration;
            private Object lateMoney;
            private String couponTitle;

            public String getCouponTitle() {
                return couponTitle;
            }

            public void setCouponTitle(String couponTitle) {
                this.couponTitle = couponTitle;
            }

            public int getCostId() {
                return costId;
            }

            public void setCostId(int costId) {
                this.costId = costId;
            }

            public double getDeposit() {
                return deposit;
            }

            public void setDeposit(double deposit) {
                this.deposit = deposit;
            }

            public double getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(double equipCost) {
                this.equipCost = equipCost;
            }

            public double getTenancyService() {
                return tenancyService;
            }

            public void setTenancyService(double tenancyService) {
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

            public double getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(double vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public Object getChargeMoney() {
                return chargeMoney;
            }

            public void setChargeMoney(Object chargeMoney) {
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
        }
    }
}
