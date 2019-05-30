package com.ipd.jianghuzuche.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/24.
 */
public class LastBankBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"latelyBank":{"bankId":14,"cardholder":"阳阳车行","cardNum":"7898456112345698","bankName":"中国建设","userId":7,"delStatus":null,"status":1,"openBank":null,"city":"上海市","bankIcon":"picture/profile/JYJY197108909620190429161510.jpg","bankType":1,"createTime":"2019-05-24 14:47:07","bankcardId":1}}
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
         * latelyBank : {"bankId":14,"cardholder":"阳阳车行","cardNum":"7898456112345698","bankName":"中国建设","userId":7,"delStatus":null,"status":1,"openBank":null,"city":"上海市","bankIcon":"picture/profile/JYJY197108909620190429161510.jpg","bankType":1,"createTime":"2019-05-24 14:47:07","bankcardId":1}
         */

        private LatelyBankBean latelyBank;

        public LatelyBankBean getLatelyBank() {
            return latelyBank;
        }

        public void setLatelyBank(LatelyBankBean latelyBank) {
            this.latelyBank = latelyBank;
        }

        public static class LatelyBankBean {
            /**
             * bankId : 14
             * cardholder : 阳阳车行
             * cardNum : 7898456112345698
             * bankName : 中国建设
             * userId : 7
             * delStatus : null
             * status : 1
             * openBank : null
             * city : 上海市
             * bankIcon : picture/profile/JYJY197108909620190429161510.jpg
             * bankType : 1
             * createTime : 2019-05-24 14:47:07
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
        }
    }
}
