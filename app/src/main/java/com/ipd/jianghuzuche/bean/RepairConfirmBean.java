package com.ipd.jianghuzuche.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class RepairConfirmBean implements Parcelable {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"costList":[{"costId":121,"title":"充电包天","money":99,"createTime":"2019-05-15 14:08:15","chargeNum":1,"orderId":37,"type":2},{"costId":122,"title":"轮胎大头","money":99,"createTime":"2019-05-15 14:08:15","chargeNum":0,"orderId":37,"type":1},{"costId":123,"title":"轮胎尾部","money":99,"createTime":"2019-05-15 14:08:15","chargeNum":0,"orderId":37,"type":1}],"order":{"orderId":37,"userId":3,"orderNo":"1949522086","successTime":null,"payWay":0,"payTime":null,"payStatus":0,"storeId":2,"status":0,"telPhone":"18502994087","userName":"东西","totalMoney":null,"createTime":"2019-05-15 14:08:15","charges":null,"repairs":null,"storeName":"涵予汽车店","descAddress":"上海市青浦区华徐公路888号中国梦谷","logo":"picture/profile/JYJY197213490020190429161521.jpg","payMoney":null,"params":{}}}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected RepairConfirmBean(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<RepairConfirmBean> CREATOR = new Creator<RepairConfirmBean>() {
        @Override
        public RepairConfirmBean createFromParcel(Parcel in) {
            return new RepairConfirmBean(in);
        }

        @Override
        public RepairConfirmBean[] newArray(int size) {
            return new RepairConfirmBean[size];
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
         * costList : [{"costId":121,"title":"充电包天","money":99,"createTime":"2019-05-15 14:08:15","chargeNum":1,"orderId":37,"type":2},{"costId":122,"title":"轮胎大头","money":99,"createTime":"2019-05-15 14:08:15","chargeNum":0,"orderId":37,"type":1},{"costId":123,"title":"轮胎尾部","money":99,"createTime":"2019-05-15 14:08:15","chargeNum":0,"orderId":37,"type":1}]
         * order : {"orderId":37,"userId":3,"orderNo":"1949522086","successTime":null,"payWay":0,"payTime":null,"payStatus":0,"storeId":2,"status":0,"telPhone":"18502994087","userName":"东西","totalMoney":null,"createTime":"2019-05-15 14:08:15","charges":null,"repairs":null,"storeName":"涵予汽车店","descAddress":"上海市青浦区华徐公路888号中国梦谷","logo":"picture/profile/JYJY197213490020190429161521.jpg","payMoney":null,"params":{}}
         */

        private OrderBean order;
        private List<CostListBean> costList;

        public DataBean(Parcel in) {
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class OrderBean implements Parcelable {
            public OrderBean() {
                super();
            }

            /**
             * orderId : 37
             * userId : 3
             * orderNo : 1949522086
             * successTime : null
             * payWay : 0
             * payTime : null
             * payStatus : 0
             * storeId : 2
             * status : 0
             * telPhone : 18502994087
             * userName : 东西
             * totalMoney : null
             * createTime : 2019-05-15 14:08:15
             * charges : null
             * repairs : null
             * storeName : 涵予汽车店
             * descAddress : 上海市青浦区华徐公路888号中国梦谷
             * logo : picture/profile/JYJY197213490020190429161521.jpg
             * payMoney : null
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
            private Object charges;
            private Object repairs;
            private String storeName;
            private String descAddress;
            private String logo;
            private Object payMoney;
            private ParamsBean params;

            public OrderBean(Parcel in) {
                orderId = in.readInt();
                userId = in.readInt();
                orderNo = in.readString();
                payWay = in.readInt();
                payStatus = in.readInt();
                storeId = in.readInt();
                status = in.readInt();
                telPhone = in.readString();
                userName = in.readString();
                createTime = in.readString();
                storeName = in.readString();
                descAddress = in.readString();
                logo = in.readString();
            }

            public static final Creator<OrderBean> CREATOR = new Creator<OrderBean>() {
                @Override
                public OrderBean createFromParcel(Parcel in) {
                    return new OrderBean(in);
                }

                @Override
                public OrderBean[] newArray(int size) {
                    return new OrderBean[size];
                }
            };

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

            public Object getCharges() {
                return charges;
            }

            public void setCharges(Object charges) {
                this.charges = charges;
            }

            public Object getRepairs() {
                return repairs;
            }

            public void setRepairs(Object repairs) {
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(orderId);
                dest.writeInt(userId);
                dest.writeString(orderNo);
                dest.writeInt(payWay);
                dest.writeInt(payStatus);
                dest.writeInt(storeId);
                dest.writeInt(status);
                dest.writeString(telPhone);
                dest.writeString(userName);
                dest.writeString(createTime);
                dest.writeString(storeName);
                dest.writeString(descAddress);
                dest.writeString(logo);
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

        public static class CostListBean implements Parcelable {
            /**
             * costId : 121
             * title : 充电包天
             * money : 99.0
             * createTime : 2019-05-15 14:08:15
             * chargeNum : 1
             * orderId : 37
             * type : 2
             */

            private int costId;
            private String title;
            private double money;
            private String createTime;
            private int chargeNum;
            private int orderId;
            private int type;

            protected CostListBean(Parcel in) {
                costId = in.readInt();
                title = in.readString();
                money = in.readDouble();
                createTime = in.readString();
                chargeNum = in.readInt();
                orderId = in.readInt();
                type = in.readInt();
            }

            public static final Creator<CostListBean> CREATOR = new Creator<CostListBean>() {
                @Override
                public CostListBean createFromParcel(Parcel in) {
                    return new CostListBean(in);
                }

                @Override
                public CostListBean[] newArray(int size) {
                    return new CostListBean[size];
                }
            };

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

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(costId);
                dest.writeString(title);
                dest.writeDouble(money);
                dest.writeString(createTime);
                dest.writeInt(chargeNum);
                dest.writeInt(orderId);
                dest.writeInt(type);
            }
        }
    }
}
