package com.ipd.jianghuzuche.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class SupplementInfoBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"user":{"userId":3,"telPhone":"18502994087","password":"3768b4cfea8495e572ebfbb03327e88c","userName":"jhzc916044","userCall":"","parentId":0,"balance":0,"invitationCode":null,"avatar":"","userType":1,"status":2,"idPositive":"picture/profileID/JYJY193214634720190506112841.jpeg","idOpposite":"picture/profileID/JYJY192278311720190506112707.jpeg","idHold":"picture/profileID/JYJY192566164020190506112736.jpeg","createTime":"2019-05-05 16:45:39","storeId":0}}
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
         * user : {"userId":3,"telPhone":"18502994087","password":"3768b4cfea8495e572ebfbb03327e88c","userName":"jhzc916044","userCall":"","parentId":0,"balance":0,"invitationCode":null,"avatar":"","userType":1,"status":2,"idPositive":"picture/profileID/JYJY193214634720190506112841.jpeg","idOpposite":"picture/profileID/JYJY192278311720190506112707.jpeg","idHold":"picture/profileID/JYJY192566164020190506112736.jpeg","createTime":"2019-05-05 16:45:39","storeId":0}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * userId : 3
             * telPhone : 18502994087
             * password : 3768b4cfea8495e572ebfbb03327e88c
             * userName : jhzc916044
             * userCall :
             * parentId : 0
             * balance : 0.0
             * invitationCode : null
             * avatar :
             * userType : 1
             * status : 2
             * idPositive : picture/profileID/JYJY193214634720190506112841.jpeg
             * idOpposite : picture/profileID/JYJY192278311720190506112707.jpeg
             * idHold : picture/profileID/JYJY192566164020190506112736.jpeg
             * createTime : 2019-05-05 16:45:39
             * storeId : 0
             */

            private int userId;
            private String telPhone;
            private String password;
            private String userName;
            private String userCall;
            private int parentId;
            private double balance;
            private Object invitationCode;
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

            public Object getInvitationCode() {
                return invitationCode;
            }

            public void setInvitationCode(Object invitationCode) {
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
    }
}
