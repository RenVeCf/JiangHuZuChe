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
public class SelectBankBean implements Parcelable {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"bankList":[{"bankId":8,"cardholder":"付宗乐","cardNum":"411523199502021095x","bankName":"中国建设","userId":14,"delStatus":null,"status":1,"openBank":null,"city":"上海市黄浦区","bankIcon":"图标","bankType":1,"createTime":"2019-04-24 20:38:55","bankcardId":1},{"bankId":7,"cardholder":"付宗乐","cardNum":"411523199502021095x","bankName":"中国建设","userId":14,"delStatus":null,"status":2,"openBank":null,"city":"上海市黄浦区","bankIcon":"图标","bankType":1,"createTime":"2019-04-24 20:30:45","bankcardId":1}]}
     */


    private int code;
    private String msg;
    private DataBean data;

    protected SelectBankBean(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<SelectBankBean> CREATOR = new Creator<SelectBankBean>() {
        @Override
        public SelectBankBean createFromParcel(Parcel in) {
            return new SelectBankBean(in);
        }

        @Override
        public SelectBankBean[] newArray(int size) {
            return new SelectBankBean[size];
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
        private List<BankListBean> bankList;

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

        public List<BankListBean> getBankList() {
            return bankList;
        }

        public void setBankList(List<BankListBean> bankList) {
            this.bankList = bankList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class BankListBean implements Parcelable {
            /**
             * bankId : 8
             * cardholder : 付宗乐
             * cardNum : 411523199502021095x
             * bankName : 中国建设
             * userId : 14
             * delStatus : null
             * status : 1
             * openBank : null
             * city : 上海市黄浦区
             * bankIcon : 图标
             * bankType : 1
             * createTime : 2019-04-24 20:38:55
             * bankcardId : 1
             */

            private int bankId;
            private String cardholder;
            private String cardNum;
            private String bankName;
            private int userId;
            private Object delStatus;
            private int status;
            private Object openBank;
            private String city;
            private String bankIcon;
            private int bankType;
            private String createTime;
            private int bankcardId;

            public BankListBean() {
                super();
            }

            public BankListBean(Parcel in) {
                bankId = in.readInt();
                cardholder = in.readString();
                cardNum = in.readString();
                bankName = in.readString();
                userId = in.readInt();
                status = in.readInt();
                city = in.readString();
                bankIcon = in.readString();
                bankType = in.readInt();
                createTime = in.readString();
                bankcardId = in.readInt();
            }

            public static final Creator<BankListBean> CREATOR = new Creator<BankListBean>() {
                @Override
                public BankListBean createFromParcel(Parcel in) {
                    return new BankListBean(in);
                }

                @Override
                public BankListBean[] newArray(int size) {
                    return new BankListBean[size];
                }
            };

            public int getBankId() {
                return bankId;
            }

            public void setBankId(int bankId) {
                this.bankId = bankId;
            }

            public String getCardholder() {
                return cardholder;
            }

            public void setCardholder(String cardholder) {
                this.cardholder = cardholder;
            }

            public String getCardNum() {
                return cardNum;
            }

            public void setCardNum(String cardNum) {
                this.cardNum = cardNum;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getDelStatus() {
                return delStatus;
            }

            public void setDelStatus(Object delStatus) {
                this.delStatus = delStatus;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getOpenBank() {
                return openBank;
            }

            public void setOpenBank(Object openBank) {
                this.openBank = openBank;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getBankIcon() {
                return bankIcon;
            }

            public void setBankIcon(String bankIcon) {
                this.bankIcon = bankIcon;
            }

            public int getBankType() {
                return bankType;
            }

            public void setBankType(int bankType) {
                this.bankType = bankType;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getBankcardId() {
                return bankcardId;
            }

            public void setBankcardId(int bankcardId) {
                this.bankcardId = bankcardId;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(bankId);
                dest.writeString(cardholder);
                dest.writeString(cardNum);
                dest.writeString(bankName);
                dest.writeInt(userId);
                dest.writeInt(status);
                dest.writeString(city);
                dest.writeString(bankIcon);
                dest.writeInt(bankType);
                dest.writeString(createTime);
                dest.writeInt(bankcardId);
            }
        }
    }
}
