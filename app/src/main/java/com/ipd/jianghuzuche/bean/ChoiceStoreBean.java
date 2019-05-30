package com.ipd.jianghuzuche.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class ChoiceStoreBean implements Parcelable {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"storeList":[{"storeId":2,"storeName":"tan","picPath":"picture/PcStore/JYJY190359674120190520100715.jpg,picture/PcStore/JYJY190092488020190520100649.jpg,picture/PcStore/JYJY190024039220190520100642.jpg,","contactsPhone":"15021661128","contactsName":null,"descAddress":"上海市华徐公路888号中国梦谷","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-20 10:08:33","repairId":null,"repairNames":"","chargeId":"","distance":2684.1,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY191085719820190520100828.jpg","stock":null,"longitude":"121.272675","latitude":"31.204742","totalNum":null,"availableNum":2,"params":{}},{"storeId":1,"storeName":"RMY","picPath":"picture/PcStore/JYJY194196315320190520095659.jpg,picture/PcStore/JYJY194093736020190520095649.jpg,picture/PcStore/JYJY193199165920190520095519.jpg,","contactsPhone":"18502994087","contactsName":null,"descAddress":"上海市华徐公路888号","province":"上海","city":"上海市","area":"青浦区","createTime":"2019-05-20 09:57:44","repairId":null,"repairNames":"","chargeId":"","distance":2684.1,"status":null,"userName":null,"telPhone":null,"userId":null,"logo":"picture/profile/JYJY193269517620190520095526.jpg","stock":null,"longitude":"121.272675","latitude":"31.204742","totalNum":null,"availableNum":2,"params":{}}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected ChoiceStoreBean(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<ChoiceStoreBean> CREATOR = new Creator<ChoiceStoreBean>() {
        @Override
        public ChoiceStoreBean createFromParcel(Parcel in) {
            return new ChoiceStoreBean(in);
        }

        @Override
        public ChoiceStoreBean[] newArray(int size) {
            return new ChoiceStoreBean[size];
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
        private List<StoreListBean> storeList;

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

        public List<StoreListBean> getStoreList() {
            return storeList;
        }

        public void setStoreList(List<StoreListBean> storeList) {
            this.storeList = storeList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class StoreListBean implements Parcelable {
            public StoreListBean() {
                super();
            }

            /**
             * storeId : 2
             * <p>
             * storeName : tan
             * picPath : picture/PcStore/JYJY190359674120190520100715.jpg,picture/PcStore/JYJY190092488020190520100649.jpg,picture/PcStore/JYJY190024039220190520100642.jpg,
             * contactsPhone : 15021661128
             * contactsName : null
             * descAddress : 上海市华徐公路888号中国梦谷
             * province : 上海
             * city : 上海市
             * area : 青浦区
             * createTime : 2019-05-20 10:08:33
             * repairId : null
             * repairNames :
             * chargeId :
             * distance : 2684.1
             * status : null
             * userName : null
             * telPhone : null
             * userId : null
             * logo : picture/profile/JYJY191085719820190520100828.jpg
             * stock : null
             * longitude : 121.272675
             * latitude : 31.204742
             * totalNum : null
             * availableNum : 2
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
            private int availableNum;
            private ParamsBean params;

            protected StoreListBean(Parcel in) {
                storeId = in.readInt();
                storeName = in.readString();
                picPath = in.readString();
                contactsPhone = in.readString();
                descAddress = in.readString();
                province = in.readString();
                city = in.readString();
                area = in.readString();
                createTime = in.readString();
                repairNames = in.readString();
                chargeId = in.readString();
                distance = in.readDouble();
                logo = in.readString();
                longitude = in.readString();
                latitude = in.readString();
                availableNum = in.readInt();
            }

            public static final Creator<StoreListBean> CREATOR = new Creator<StoreListBean>() {
                @Override
                public StoreListBean createFromParcel(Parcel in) {
                    return new StoreListBean(in);
                }

                @Override
                public StoreListBean[] newArray(int size) {
                    return new StoreListBean[size];
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
                dest.writeString(repairNames);
                dest.writeString(chargeId);
                dest.writeDouble(distance);
                dest.writeString(logo);
                dest.writeString(longitude);
                dest.writeString(latitude);
                dest.writeInt(availableNum);
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
    }
}
