package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class WalletDetailsBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"userDetailed":[{"detailedId":1,"userId":7,"money":50,"moneyType":1,"title":"1","details":"1","createTime":null}],"user":{"userId":7,"telPhone":"15937016361","password":"15f1b0be68f935ca3a5c0725511d4a57","userName":"","userCall":"","parentId":0,"balance":0.00,"invitationCode":"邀请码","avatar":"","userType":1,"status":1,"idPositive":"","idOpposite":"","idHold":"","createTime":"2019-04-22 13:31:35","storeId":0}}
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
         * userDetailed : [{"detailedId":1,"userId":7,"money":50,"moneyType":1,"title":"1","details":"1","createTime":null}]
         * user : {"userId":7,"telPhone":"15937016361","password":"15f1b0be68f935ca3a5c0725511d4a57","userName":"","userCall":"","parentId":0,"balance":0.00,"invitationCode":"邀请码","avatar":"","userType":1,"status":1,"idPositive":"","idOpposite":"","idHold":"","createTime":"2019-04-22 13:31:35","storeId":0}
         */

        private UserBean user;
        private List<UserDetailedBean> userDetailed;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<UserDetailedBean> getUserDetailed() {
            return userDetailed;
        }

        public void setUserDetailed(List<UserDetailedBean> userDetailed) {
            this.userDetailed = userDetailed;
        }

        public static class UserBean {
            /**
             * userId : 7
             * telPhone : 15937016361
             * password : 15f1b0be68f935ca3a5c0725511d4a57
             * userName :
             * userCall :
             * parentId : 0
             * balance : 0.00
             * invitationCode : 邀请码
             * avatar :
             * userType : 1
             * status : 1
             * idPositive :
             * idOpposite :
             * idHold :
             * createTime : 2019-04-22 13:31:35
             * storeId : 0
             */

            private int userId;
            private String telPhone;
            private String password;
            private String userName;
            private String userCall;
            private int parentId;
            private double balance;
            private String invitationCode;
            private String avatar;
            private int userType;
            private int status;
            private String idPositive;
            private String idOpposite;
            private String idHold;
            private String createTime;
            private int storeId;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(String telPhone) {
                this.telPhone = telPhone;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserCall() {
                return userCall;
            }

            public void setUserCall(String userCall) {
                this.userCall = userCall;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public double getBalance() {
                return balance;
            }

            public void setBalance(double balance) {
                this.balance = balance;
            }

            public String getInvitationCode() {
                return invitationCode;
            }

            public void setInvitationCode(String invitationCode) {
                this.invitationCode = invitationCode;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getIdPositive() {
                return idPositive;
            }

            public void setIdPositive(String idPositive) {
                this.idPositive = idPositive;
            }

            public String getIdOpposite() {
                return idOpposite;
            }

            public void setIdOpposite(String idOpposite) {
                this.idOpposite = idOpposite;
            }

            public String getIdHold() {
                return idHold;
            }

            public void setIdHold(String idHold) {
                this.idHold = idHold;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }
        }

        public static class UserDetailedBean {
            /**
             * detailedId : 1
             * userId : 7
             * money : 50
             * moneyType : 1
             * title : 1
             * details : 1
             * createTime : null
             */

            private int detailedId;
            private int userId;
            private int money;
            private int moneyType;
            private String title;
            private String details;
            private Object createTime;

            public int getDetailedId() {
                return detailedId;
            }

            public void setDetailedId(int detailedId) {
                this.detailedId = detailedId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public int getMoneyType() {
                return moneyType;
            }

            public void setMoneyType(int moneyType) {
                this.moneyType = moneyType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }
        }
    }
}
