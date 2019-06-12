package com.ipd.jianghuzuche.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/7.
 */
public class UserSelectCarBean implements Parcelable {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"StoreById":{"storeId":1,"storeName":"上海虹桥1店","picPath":"picture/PcStore/JYJY194196315320190520095659.jpg,picture/PcStore/JYJY194093736020190520095649.jpg,picture/PcStore/JYJY193199165920190520095519.jpg","contactsPhone":"18502994087","contactsName":null,"descAddress":"上海市华徐公路888号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-21 10:38:17","repairId":"1,2","repairNames":"","chargeId":"","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY192833259320190521103803.png","stock":null,"longitude":"121.316536","latitude":"31.191789","totalNum":null,"availableNum":null,"params":{}},"vehicleList":[{"vehicleId":1,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY194758472020190520095755.jpg","storeId":1,"equipCost":100,"deposit":1000,"vehicleRent":40,"createTime":"2019-05-20 09:58:33","rentOften":3,"details":"<p><span style=\"color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 13px; text-indent: 26px; background-color: rgb(255, 255, 255);\">小刀电动车成立于2004年，专注创新科技，精工质造，致力于为消费者提供动力更足、续航更远、品质更好的电动自行车、电动摩托车等，主流消费者的品质出行。多年来，小刀凭借更具价值的产品，更完善的售后服务，获得广大用户的一致信赖和支持，逐渐步入电动车一线品牌行列<\/span><\/p>"},{"vehicleId":2,"vehicleName":"雅迪电动车","vehicleModel":"xs-2345","vehicleLogo":"picture/profile/JYJY195277330820190520095847.jpg","storeId":1,"equipCost":100,"deposit":1000,"vehicleRent":50,"createTime":"2019-05-20 09:59:04","rentOften":1,"details":"<p><span style=\"color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 13px; text-indent: 26px; background-color: rgb(255, 255, 255);\">小刀电动车成立于2004年，专注创新科技，精工质造，致力于为消费者提供动力更足、续航更远、品质更好的电动自行车、电动摩托车等，主流消费者的品质出行。多年来，小刀凭借更具价值的产品，更完善的售后服务，获得广大用户的一致信赖和支持，逐渐步入电动车一线品牌行列<\/span><\/p>"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected UserSelectCarBean(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<UserSelectCarBean> CREATOR = new Creator<UserSelectCarBean>() {
        @Override
        public UserSelectCarBean createFromParcel(Parcel in) {
            return new UserSelectCarBean(in);
        }

        @Override
        public UserSelectCarBean[] newArray(int size) {
            return new UserSelectCarBean[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
    }

    public static class DataBean implements Parcelable {
        /**
         * StoreById : {"storeId":1,"storeName":"上海虹桥1店","picPath":"picture/PcStore/JYJY194196315320190520095659.jpg,picture/PcStore/JYJY194093736020190520095649.jpg,picture/PcStore/JYJY193199165920190520095519.jpg","contactsPhone":"18502994087","contactsName":null,"descAddress":"上海市华徐公路888号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-21 10:38:17","repairId":"1,2","repairNames":"","chargeId":"","distance":3.6,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY192833259320190521103803.png","stock":null,"longitude":"121.316536","latitude":"31.191789","totalNum":null,"availableNum":null,"params":{}}
         * vehicleList : [{"vehicleId":1,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY194758472020190520095755.jpg","storeId":1,"equipCost":100,"deposit":1000,"vehicleRent":40,"createTime":"2019-05-20 09:58:33","rentOften":3,"details":"<p><span style=\"color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 13px; text-indent: 26px; background-color: rgb(255, 255, 255);\">小刀电动车成立于2004年，专注创新科技，精工质造，致力于为消费者提供动力更足、续航更远、品质更好的电动自行车、电动摩托车等，主流消费者的品质出行。多年来，小刀凭借更具价值的产品，更完善的售后服务，获得广大用户的一致信赖和支持，逐渐步入电动车一线品牌行列<\/span><\/p>"},{"vehicleId":2,"vehicleName":"雅迪电动车","vehicleModel":"xs-2345","vehicleLogo":"picture/profile/JYJY195277330820190520095847.jpg","storeId":1,"equipCost":100,"deposit":1000,"vehicleRent":50,"createTime":"2019-05-20 09:59:04","rentOften":1,"details":"<p><span style=\"color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 13px; text-indent: 26px; background-color: rgb(255, 255, 255);\">小刀电动车成立于2004年，专注创新科技，精工质造，致力于为消费者提供动力更足、续航更远、品质更好的电动自行车、电动摩托车等，主流消费者的品质出行。多年来，小刀凭借更具价值的产品，更完善的售后服务，获得广大用户的一致信赖和支持，逐渐步入电动车一线品牌行列<\/span><\/p>"}]
         */

        private StoreByIdBean StoreById;
        private List<VehicleListBean> vehicleList;

        protected DataBean(Parcel in) {
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public StoreByIdBean getStoreById() {
            return StoreById;
        }

        public void setStoreById(StoreByIdBean StoreById) {
            this.StoreById = StoreById;
        }

        public List<VehicleListBean> getVehicleList() {
            return vehicleList;
        }

        public void setVehicleList(List<VehicleListBean> vehicleList) {
            this.vehicleList = vehicleList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class StoreByIdBean implements Parcelable {
            public StoreByIdBean() {
                super();
            }

            /**
             * storeId : 1
             * storeName : 上海虹桥1店
             * picPath : picture/PcStore/JYJY194196315320190520095659.jpg,picture/PcStore/JYJY194093736020190520095649.jpg,picture/PcStore/JYJY193199165920190520095519.jpg
             * contactsPhone : 18502994087
             * contactsName : null
             * descAddress : 上海市华徐公路888号
             * province : 上海
             * city : 上海市
             * area : 青浦区
             * createTime : 2019-05-21 10:38:17
             * repairId : 1,2
             * repairNames :
             * chargeId :
             * distance : 3.6
             * status : null
             * userName : null
             * telPhone : null
             * userId : null
             * logo : picture/profile/JYJY192833259320190521103803.png
             * stock : null
             * longitude : 121.316536
             * latitude : 31.191789
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
            private String repairId;
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

            public StoreByIdBean(Parcel in) {
                storeId = in.readInt();
                storeName = in.readString();
                picPath = in.readString();
                contactsPhone = in.readString();
                descAddress = in.readString();
                province = in.readString();
                city = in.readString();
                area = in.readString();
                createTime = in.readString();
                repairId = in.readString();
                repairNames = in.readString();
                chargeId = in.readString();
                distance = in.readDouble();
                logo = in.readString();
                longitude = in.readString();
                latitude = in.readString();
            }

            public static final Creator<StoreByIdBean> CREATOR = new Creator<StoreByIdBean>() {
                @Override
                public StoreByIdBean createFromParcel(Parcel in) {
                    return new StoreByIdBean(in);
                }

                @Override
                public StoreByIdBean[] newArray(int size) {
                    return new StoreByIdBean[size];
                }
            };

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

            public String getRepairId() {
                return repairId;
            }

            public void setRepairId(String repairId) {
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(storeId);
                dest.writeString(storeName);
                dest.writeString(picPath);
                dest.writeString(contactsPhone);
                dest.writeString(descAddress);
                dest.writeString(province);
                dest.writeString(city);
                dest.writeString(area);
                dest.writeString(createTime);
                dest.writeString(repairId);
                dest.writeString(repairNames);
                dest.writeString(chargeId);
                dest.writeDouble(distance);
                dest.writeString(logo);
                dest.writeString(longitude);
                dest.writeString(latitude);
            }

            public static class ParamsBean implements Parcelable {
                protected ParamsBean(Parcel in) {
                }

                public static final Creator<ParamsBean> CREATOR = new Creator<ParamsBean>() {
                    @Override
                    public ParamsBean createFromParcel(Parcel in) {
                        return new ParamsBean(in);
                    }

                    @Override
                    public ParamsBean[] newArray(int size) {
                        return new ParamsBean[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                }
            }
        }

        public static class VehicleListBean implements Parcelable {
            public VehicleListBean() {
                super();
            }

            /**
             * vehicleId : 1
             * vehicleName : 小刀电动车
             * vehicleModel : xs25445
             * vehicleLogo : picture/profile/JYJY194758472020190520095755.jpg
             * storeId : 1
             * equipCost : 100.0
             * deposit : 1000.0
             * vehicleRent : 40.0
             * createTime : 2019-05-20 09:58:33
             * rentOften : 3
             * details : <p><span style="color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 13px; text-indent: 26px; background-color: rgb(255, 255, 255);">小刀电动车成立于2004年，专注创新科技，精工质造，致力于为消费者提供动力更足、续航更远、品质更好的电动自行车、电动摩托车等，主流消费者的品质出行。多年来，小刀凭借更具价值的产品，更完善的售后服务，获得广大用户的一致信赖和支持，逐渐步入电动车一线品牌行列</span></p>
             */


            private int vehicleId;
            private String vehicleName;
            private String vehicleModel;
            private String vehicleLogo;
            private int storeId;
            private double equipCost;
            private double deposit;
            private double vehicleRent;
            private String createTime;
            private int rentOften;
            private String details;

            protected VehicleListBean(Parcel in) {
                vehicleId = in.readInt();
                vehicleName = in.readString();
                vehicleModel = in.readString();
                vehicleLogo = in.readString();
                storeId = in.readInt();
                equipCost = in.readDouble();
                deposit = in.readDouble();
                vehicleRent = in.readDouble();
                createTime = in.readString();
                rentOften = in.readInt();
                details = in.readString();
            }

            public static final Creator<VehicleListBean> CREATOR = new Creator<VehicleListBean>() {
                @Override
                public VehicleListBean createFromParcel(Parcel in) {
                    return new VehicleListBean(in);
                }

                @Override
                public VehicleListBean[] newArray(int size) {
                    return new VehicleListBean[size];
                }
            };

            public int getVehicleId() {
                return vehicleId;
            }

            public void setVehicleId(int vehicleId) {
                this.vehicleId = vehicleId;
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

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public double getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(double equipCost) {
                this.equipCost = equipCost;
            }

            public double getDeposit() {
                return deposit;
            }

            public void setDeposit(double deposit) {
                this.deposit = deposit;
            }

            public double getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(double vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getRentOften() {
                return rentOften;
            }

            public void setRentOften(int rentOften) {
                this.rentOften = rentOften;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(vehicleId);
                dest.writeString(vehicleName);
                dest.writeString(vehicleModel);
                dest.writeString(vehicleLogo);
                dest.writeInt(storeId);
                dest.writeDouble(equipCost);
                dest.writeDouble(deposit);
                dest.writeDouble(vehicleRent);
                dest.writeString(createTime);
                dest.writeInt(rentOften);
                dest.writeString(details);
            }
        }
    }
}
