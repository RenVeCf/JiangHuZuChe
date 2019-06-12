package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/22.
 */
public class RepairDetailsBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"costList":[{"costId":96,"title":"充电包月","money":99,"createTime":"2019-05-31 00:10:36","chargeNum":1,"orderId":44,"type":2,"coupon":null},{"costId":97,"title":"皮垫更换","money":20,"createTime":"2019-05-31 00:10:36","chargeNum":0,"orderId":44,"type":1,"coupon":null}],"store":{"storeId":6,"storeName":"上海徐泾2店","picPath":"picture/PcStore/JYJY199486744020190531021228.png,picture/PcStore/JYJY199361859320190531021216.png","contactsPhone":"13764190230","contactsName":null,"descAddress":"明珠路1018号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-31 02:12:31","repairId":null,"repairNames":"","chargeId":"1","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.26778","latitude":"31.199726","totalNum":null,"availableNum":null,"params":{}},"order":{"orderId":44,"userId":7,"orderNo":"1963680894","successTime":null,"payWay":0,"payTime":null,"payStatus":2,"storeId":6,"status":4,"telPhone":"18502994087","userName":"jhzc427601","totalMoney":null,"createTime":"2019-05-31 00:10:36","charges":"","repairs":"","storeName":"上海徐泾2店","descAddress":"明珠路1018号","logo":"picture/profile/JYJY196446766020190527191404.jpg","payMoney":99,"city":null,"supId":null,"couponTitle":"满100减20","coupon":20,"userCouponId":null,"params":{}}}
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
         * costList : [{"costId":96,"title":"充电包月","money":99,"createTime":"2019-05-31 00:10:36","chargeNum":1,"orderId":44,"type":2,"coupon":null},{"costId":97,"title":"皮垫更换","money":20,"createTime":"2019-05-31 00:10:36","chargeNum":0,"orderId":44,"type":1,"coupon":null}]
         * store : {"storeId":6,"storeName":"上海徐泾2店","picPath":"picture/PcStore/JYJY199486744020190531021228.png,picture/PcStore/JYJY199361859320190531021216.png","contactsPhone":"13764190230","contactsName":null,"descAddress":"明珠路1018号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-31 02:12:31","repairId":null,"repairNames":"","chargeId":"1","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.26778","latitude":"31.199726","totalNum":null,"availableNum":null,"params":{}}
         * order : {"orderId":44,"userId":7,"orderNo":"1963680894","successTime":null,"payWay":0,"payTime":null,"payStatus":2,"storeId":6,"status":4,"telPhone":"18502994087","userName":"jhzc427601","totalMoney":null,"createTime":"2019-05-31 00:10:36","charges":"","repairs":"","storeName":"上海徐泾2店","descAddress":"明珠路1018号","logo":"picture/profile/JYJY196446766020190527191404.jpg","payMoney":99,"city":null,"supId":null,"couponTitle":"满100减20","coupon":20,"userCouponId":null,"params":{}}
         */

        private StoreBean store;
        private OrderBean order;
        private List<CostListBean> costList;

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<CostListBean> getCostList() {
            return costList;
        }

        public void setCostList(List<CostListBean> costList) {
            this.costList = costList;
        }

        public static class StoreBean {
            /**
             * storeId : 6
             * storeName : 上海徐泾2店
             * picPath : picture/PcStore/JYJY199486744020190531021228.png,picture/PcStore/JYJY199361859320190531021216.png
             * contactsPhone : 13764190230
             * contactsName : null
             * descAddress : 明珠路1018号
             * province : 上海
             * city : 上海市
             * area : 青浦区
             * createTime : 2019-05-31 02:12:31
             * repairId : null
             * repairNames :
             * chargeId : 1
             * distance : 3.6
             * status : null
             * userName : null
             * telPhone : null
             * userId : null
             * logo : picture/profile/JYJY196446766020190527191404.jpg
             * stock : null
             * longitude : 121.26778
             * latitude : 31.199726
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
             * orderId : 44
             * userId : 7
             * orderNo : 1963680894
             * successTime : null
             * payWay : 0
             * payTime : null
             * payStatus : 2
             * storeId : 6
             * status : 4
             * telPhone : 18502994087
             * userName : jhzc427601
             * totalMoney : null
             * createTime : 2019-05-31 00:10:36
             * charges :
             * repairs :
             * storeName : 上海徐泾2店
             * descAddress : 明珠路1018号
             * logo : picture/profile/JYJY196446766020190527191404.jpg
             * payMoney : 99
             * city : null
             * supId : null
             * couponTitle : 满100减20
             * coupon : 20
             * userCouponId : null
             * params : {}
             */

            private int orderId;
            private int userId;
            private String orderNo;
            private Object successTime;
            private int payWay;
            private Object payTime;
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
            private int payMoney;
            private Object city;
            private Object supId;
            private String couponTitle;
            private int coupon;
            private Object userCouponId;
            private ParamsBeanX params;

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

            public int getPayMoney() {
                return payMoney;
            }

            public void setPayMoney(int payMoney) {
                this.payMoney = payMoney;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getSupId() {
                return supId;
            }

            public void setSupId(Object supId) {
                this.supId = supId;
            }

            public String getCouponTitle() {
                return couponTitle;
            }

            public void setCouponTitle(String couponTitle) {
                this.couponTitle = couponTitle;
            }

            public int getCoupon() {
                return coupon;
            }

            public void setCoupon(int coupon) {
                this.coupon = coupon;
            }

            public Object getUserCouponId() {
                return userCouponId;
            }

            public void setUserCouponId(Object userCouponId) {
                this.userCouponId = userCouponId;
            }

            public ParamsBeanX getParams() {
                return params;
            }

            public void setParams(ParamsBeanX params) {
                this.params = params;
            }

            public static class ParamsBeanX {
            }
        }

        public static class CostListBean {
            /**
             * costId : 96
             * title : 充电包月
             * money : 99
             * createTime : 2019-05-31 00:10:36
             * chargeNum : 1
             * orderId : 44
             * type : 2
             * coupon : null
             */

            private int costId;
            private String title;
            private int money;
            private String createTime;
            private int chargeNum;
            private int orderId;
            private int type;
            private Object coupon;

            public int getCostId() {
                return costId;
            }

            public void setCostId(int costId) {
                this.costId = costId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getChargeNum() {
                return chargeNum;
            }

            public void setChargeNum(int chargeNum) {
                this.chargeNum = chargeNum;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Object getCoupon() {
                return coupon;
            }

            public void setCoupon(Object coupon) {
                this.coupon = coupon;
            }
        }
    }
}
