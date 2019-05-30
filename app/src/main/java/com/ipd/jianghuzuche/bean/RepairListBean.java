package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/9.
 */
public class RepairListBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"storeList":[{"storeId":8,"storeName":"上海涵予店","picPath":"picture/store/JYJY196186332020190523171018.jpg,picture/store/JYJY196183360320190523171018.jpg,picture/store/JYJY196184183520190523171018.jpg","contactsPhone":"15021661147","contactsName":null,"descAddress":"华徐公路888号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-27 21:03:07","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"1,2,3","distance":226.1,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.272675","latitude":"31.204742","totalNum":null,"availableNum":null,"params":{}},{"storeId":6,"storeName":"上海徐泾2店","picPath":"picture/PcStore/JYJY198132448920190521104653.png","contactsPhone":"13764190230","contactsName":null,"descAddress":"明珠路1018号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-27 21:01:54","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"","distance":948.1,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.26778","latitude":"31.199726","totalNum":null,"availableNum":null,"params":{}},{"storeId":1,"storeName":"明珠路1店","picPath":"picture/PcStore/JYJY194196315320190520095659.jpg,picture/PcStore/JYJY194093736020190520095649.jpg,picture/PcStore/JYJY193199165920190520095519.jpg","contactsPhone":"18502994087","contactsName":null,"descAddress":"明珠路800号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-27 20:59:14","repairId":"1,2","repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"","distance":2240,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.27172","latitude":"31.186523","totalNum":null,"availableNum":null,"params":{}},{"storeId":3,"storeName":"上海闵行店","picPath":"picture/store/JYJY190795822920190527152759.jpg,picture/store/JYJY190798218620190527152759.jpg,picture/store/JYJY190802263620190527152800.jpg,picture/store/JYJY190801659420190527152800.jpg,picture/store/JYJY190807381020190527152800.jpg,picture/store/JYJY190813399820190527152801.jpg","contactsPhone":"15021661128","contactsName":null,"descAddress":"纪展路357号","province":"上海","city":"上海市","area":"闵行区","createTime":"2019-05-27 21:01:02","repairId":"1,2","repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"1,2,3","distance":2676.4,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.27904","latitude":"31.230179","totalNum":null,"availableNum":null,"params":{}},{"storeId":7,"storeName":"阳阳车行","picPath":"picture/vehicle/JYJY197809371720190522221940.jpeg,picture/vehicle/JYJY197875619520190522221947.jpeg,picture/vehicle/JYJY197909872020190522221950.jpeg","contactsPhone":"18502994087","contactsName":null,"descAddress":"诚爱路58号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-27 21:02:31","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"1,2","distance":2959.2999999999997,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.28255","latitude":"31.181091","totalNum":null,"availableNum":null,"params":{}},{"storeId":17,"storeName":"付宗乐测试门店01","picPath":"picture/PcStore/JYJY192494613620190528170409.jpg,picture/PcStore/JYJY192454467720190528170405.jpg,picture/PcStore/JYJY192423138420190528170402.jpg","contactsPhone":"15937013825","contactsName":null,"descAddress":"上海市青浦区徐径镇盈港东路明珠路","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-28 17:04:23","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"","distance":3020.1,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY192335494520190528170353.jpg","stock":null,"longitude":"121.274445","latitude":"31.179451","totalNum":null,"availableNum":null,"params":{}},{"storeId":5,"storeName":"上海青浦2店","picPath":"picture/PcStore/JYJY198342292120190520202034.jpg,picture/PcStore/JYJY198307284120190520202030.jpg,picture/PcStore/JYJY198279429620190520202027.jpg","contactsPhone":"15937016361","contactsName":null,"descAddress":"上海市青浦区盈港东路明珠路","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-21 10:39:05","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"","distance":6348.8,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.327172","latitude":"31.172511","totalNum":null,"availableNum":null,"params":{}},{"storeId":10,"storeName":"松江1店","picPath":"picture/PcStore/JYJY194047129720190524134004.jpg,picture/PcStore/JYJY193995934220190524133959.jpg","contactsPhone":"15937016361","contactsName":null,"descAddress":"沪松公路2871弄69号","province":"上海","city":"上海市","area":"松江区","createTime":"2019-05-27 21:04:13","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"1,2,3","distance":10383.1,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY196446766020190527191404.jpg","stock":null,"longitude":"121.28221","latitude":"31.113586","totalNum":null,"availableNum":null,"params":{}},{"storeId":15,"storeName":"松江2店","picPath":"picture/PcStore/JYJY194649344020190527214104.png,picture/PcStore/JYJY194569803720190527214056.png,picture/PcStore/JYJY194467344520190527214046.png","contactsPhone":"13764190222","contactsName":null,"descAddress":"莘砖公路561号","province":"上海","city":"上海市","area":"松江区","createTime":"2019-05-27 21:41:09","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"","distance":12946.9,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY194376793820190527214037.png","stock":null,"longitude":"121.32303","latitude":"31.098202","totalNum":null,"availableNum":null,"params":{}},{"storeId":14,"storeName":"测试门店098","picPath":"picture/PcStore/JYJY199712311420190527213251.jpg,picture/PcStore/JYJY199682249220190527213248.jpg","contactsPhone":"15937016321","contactsName":null,"descAddress":"上海火车站","province":"上海","city":"上海市","area":"徐汇区","createTime":"2019-05-27 21:32:52","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"","distance":18760.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY199621625520190527213242.jpg","stock":null,"longitude":"121.4621","latitude":"31.256071","totalNum":null,"availableNum":null,"params":{}},{"storeId":16,"storeName":"测试001","picPath":"picture/PcStore/JYJY192114093320190527222651.jpg,picture/PcStore/JYJY192081203620190527222648.jpg","contactsPhone":"15937016355","contactsName":null,"descAddress":"上海市黄浦区中山东一路(临黄浦江)","province":"上海","city":"上海市","area":"徐汇区","createTime":"2019-05-27 22:27:02","repairId":null,"repairNames":"大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、","chargeId":"","distance":21622.699999999997,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY191896293420190527222629.jpg","stock":null,"longitude":"121.49688","latitude":"31.242706","totalNum":null,"availableNum":null,"params":{}}],"pictureList":[{"pictureId":5,"title":"111","picPath":"picture/profile/JYJY197058456220190521143825.jpg","status":1,"content":" ","type":1,"creteTime":"2019-05-21 14:38:45","pictureType":2,"params":{}},{"pictureId":6,"title":"11","picPath":"picture/profile/JYJY193969374920190529201956.jpg","status":1,"content":" ","type":1,"creteTime":"2019-05-29 20:20:01","pictureType":2,"params":{}}]}
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
        private List<StoreListBean> storeList;
        private List<PictureListBean> pictureList;

        public List<StoreListBean> getStoreList() {
            return storeList;
        }

        public void setStoreList(List<StoreListBean> storeList) {
            this.storeList = storeList;
        }

        public List<PictureListBean> getPictureList() {
            return pictureList;
        }

        public void setPictureList(List<PictureListBean> pictureList) {
            this.pictureList = pictureList;
        }

        public static class StoreListBean {
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
             * repairNames : 大灯、灯头、灯尾、轮胎、轮胎01、轮胎02、玻璃、钢化玻璃、普通玻璃、车牌、普通车牌、高级车牌、外观件、前泥瓦、机油、机油、
             * chargeId : 1,2,3
             * distance : 226.1
             * status : null
             * userName : null
             * telPhone : null
             * userId : null
             * logo : picture/profile/JYJY196446766020190527191404.jpg
             * stock : null
             * longitude : 121.272675
             * latitude : 31.204742
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

        public static class PictureListBean {
            /**
             * pictureId : 5
             * title : 111
             * picPath : picture/profile/JYJY197058456220190521143825.jpg
             * status : 1
             * content :
             * type : 1
             * creteTime : 2019-05-21 14:38:45
             * pictureType : 2
             * params : {}
             */

            private int pictureId;
            private String title;
            private String picPath;
            private int status;
            private String content;
            private int type;
            private String creteTime;
            private int pictureType;
            private ParamsBeanX params;

            public int getPictureId() {
                return pictureId;
            }

            public void setPictureId(int pictureId) {
                this.pictureId = pictureId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getCreteTime() {
                return creteTime;
            }

            public void setCreteTime(String creteTime) {
                this.creteTime = creteTime;
            }

            public int getPictureType() {
                return pictureType;
            }

            public void setPictureType(int pictureType) {
                this.pictureType = pictureType;
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
    }
}
