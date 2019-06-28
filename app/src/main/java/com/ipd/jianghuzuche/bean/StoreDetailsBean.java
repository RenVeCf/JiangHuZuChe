package com.ipd.jianghuzuche.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/6/17.
 */
public class StoreDetailsBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"store":{"storeId":8,"storeName":"上海涵予店","picPath":"picture/store/JYJY196186332020190523171018.jpg,picture/store/JYJY196183360320190523171018.jpg,picture/store/JYJY196184183520190523171018.jpg","contactsPhone":"15021661147","contactsName":null,"descAddress":"华徐公路888号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-27 21:03:07","repairId":null,"repairNames":"","chargeId":"1,2,3","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.272675","latitude":"31.204742","totalNum":0,"availableNum":0,"params":{}},"storeRepairId":""}
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
         * store : {"storeId":8,"storeName":"上海涵予店","picPath":"picture/store/JYJY196186332020190523171018.jpg,picture/store/JYJY196183360320190523171018.jpg,picture/store/JYJY196184183520190523171018.jpg","contactsPhone":"15021661147","contactsName":null,"descAddress":"华徐公路888号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-27 21:03:07","repairId":null,"repairNames":"","chargeId":"1,2,3","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.272675","latitude":"31.204742","totalNum":0,"availableNum":0,"params":{}}
         * storeRepairId :
         */

        private StoreBean store;
        private String storeRepairId;

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public String getStoreRepairId() {
            return storeRepairId;
        }

        public void setStoreRepairId(String storeRepairId) {
            this.storeRepairId = storeRepairId;
        }

        public static class StoreBean {
            /**
             * storeId : 8
             * storeName : 上海涵予店
             * picPath : picture/store/JYJY196186332020190523171018.jpg,picture/store/JYJY196183360320190523171018.jpg,picture/store/JYJY196184183520190523171018.jpg
             * contactsPhone : 15021661147
             * contactsName : null
             * descAddress : 华徐公路888号
             * province : 上海
             * city : 上海市
             * area : 青浦区
             * createTime : 2019-05-27 21:03:07
             * repairId : null
             * repairNames :
             * chargeId : 1,2,3
             * distance : 3.6
             * status : null
             * userName : null
             * telPhone : null
             * userId : null
             * logo : picture/profile/JYJY196446766020190527191404.jpg
             * stock : null
             * longitude : 121.272675
             * latitude : 31.204742
             * totalNum : 0
             * availableNum : 0
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
            private int totalNum;
            private int availableNum;
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

            public int getTotalNum() {
                return totalNum;
            }

            public void setTotalNum(int totalNum) {
                this.totalNum = totalNum;
            }

            public int getAvailableNum() {
                return availableNum;
            }

            public void setAvailableNum(int availableNum) {
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
    }
}
