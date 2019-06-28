package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/6/18.
 */
public class ShareBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"twoCode":"upload/QRCode/dogj6yvx.png","AppInvitation":[{"invitationId":8,"userId":null,"userIds":null,"userCall":null,"telPhone":"18502994080","money":null,"type":null,"status":null,"createTime":"2019-05-20 09:57:44","telPhones":null,"userName":null,"avatar":"","params":{}},{"invitationId":7,"userId":null,"userIds":null,"userCall":null,"telPhone":"15021661148","money":null,"type":null,"status":null,"createTime":"2019-05-20 09:55:22","telPhones":null,"userName":null,"avatar":"picture/profile/JYJY191735658620190613151613.jpg","params":{}}],"user":{"userId":7,"telPhone":"18502994087","password":"74e4e50701161c4d481d41ca837f1864","userName":"jhzc427601","userCall":"","parentId":0,"balance":0,"invitationCode":"dogj6yvx","avatar":"picture/profile/JYJY191323205420190524153212.jpeg","userType":1,"status":2,"idPositive":"picture/profileID/JYJY192701404720190520174110.jpeg","idOpposite":"picture/profileID/JYJY192734900920190520174113.jpeg","idHold":"picture/profileID/JYJY192775710020190520174117.jpeg","createTime":"2019-05-20 17:41:04","telPhones":null,"oppenId":null,"params":{},"storeId":0},"url":"地址"}
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
         * twoCode : upload/QRCode/dogj6yvx.png
         * AppInvitation : [{"invitationId":8,"userId":null,"userIds":null,"userCall":null,"telPhone":"18502994080","money":null,"type":null,"status":null,"createTime":"2019-05-20 09:57:44","telPhones":null,"userName":null,"avatar":"","params":{}},{"invitationId":7,"userId":null,"userIds":null,"userCall":null,"telPhone":"15021661148","money":null,"type":null,"status":null,"createTime":"2019-05-20 09:55:22","telPhones":null,"userName":null,"avatar":"picture/profile/JYJY191735658620190613151613.jpg","params":{}}]
         * user : {"userId":7,"telPhone":"18502994087","password":"74e4e50701161c4d481d41ca837f1864","userName":"jhzc427601","userCall":"","parentId":0,"balance":0,"invitationCode":"dogj6yvx","avatar":"picture/profile/JYJY191323205420190524153212.jpeg","userType":1,"status":2,"idPositive":"picture/profileID/JYJY192701404720190520174110.jpeg","idOpposite":"picture/profileID/JYJY192734900920190520174113.jpeg","idHold":"picture/profileID/JYJY192775710020190520174117.jpeg","createTime":"2019-05-20 17:41:04","telPhones":null,"oppenId":null,"params":{},"storeId":0}
         * url : 地址
         */

        private String twoCode;
        private UserBean user;
        private String url;
        private List<AppInvitationBean> AppInvitation;

        public String getTwoCode() {
            return twoCode;
        }

        public void setTwoCode(String twoCode) {
            this.twoCode = twoCode;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<AppInvitationBean> getAppInvitation() {
            return AppInvitation;
        }

        public void setAppInvitation(List<AppInvitationBean> AppInvitation) {
            this.AppInvitation = AppInvitation;
        }

        public static class UserBean {
            /**
             * userId : 7
             * telPhone : 18502994087
             * password : 74e4e50701161c4d481d41ca837f1864
             * userName : jhzc427601
             * userCall :
             * parentId : 0
             * balance : 0.0
             * invitationCode : dogj6yvx
             * avatar : picture/profile/JYJY191323205420190524153212.jpeg
             * userType : 1
             * status : 2
             * idPositive : picture/profileID/JYJY192701404720190520174110.jpeg
             * idOpposite : picture/profileID/JYJY192734900920190520174113.jpeg
             * idHold : picture/profileID/JYJY192775710020190520174117.jpeg
             * createTime : 2019-05-20 17:41:04
             * telPhones : null
             * oppenId : null
             * params : {}
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
            private Object telPhones;
            private Object oppenId;
            private ParamsBean params;
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

            public Object getTelPhones() {
                return telPhones;
            }

            public void setTelPhones(Object telPhones) {
                this.telPhones = telPhones;
            }

            public Object getOppenId() {
                return oppenId;
            }

            public void setOppenId(Object oppenId) {
                this.oppenId = oppenId;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public static class ParamsBean {
            }
        }

        public static class AppInvitationBean {
            /**
             * invitationId : 8
             * userId : null
             * userIds : null
             * userCall : null
             * telPhone : 18502994080
             * money : null
             * type : null
             * status : null
             * createTime : 2019-05-20 09:57:44
             * telPhones : null
             * userName : null
             * avatar :
             * params : {}
             */

            private int invitationId;
            private Object userId;
            private Object userIds;
            private Object userCall;
            private String telPhone;
            private Object money;
            private Object type;
            private Object status;
            private String createTime;
            private Object telPhones;
            private Object userName;
            private String avatar;
            private ParamsBeanX params;

            public int getInvitationId() {
                return invitationId;
            }

            public void setInvitationId(int invitationId) {
                this.invitationId = invitationId;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public Object getUserIds() {
                return userIds;
            }

            public void setUserIds(Object userIds) {
                this.userIds = userIds;
            }

            public Object getUserCall() {
                return userCall;
            }

            public void setUserCall(Object userCall) {
                this.userCall = userCall;
            }

            public String getTelPhone() {
                return telPhone;
            }

            public void setTelPhone(String telPhone) {
                this.telPhone = telPhone;
            }

            public Object getMoney() {
                return money;
            }

            public void setMoney(Object money) {
                this.money = money;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getTelPhones() {
                return telPhones;
            }

            public void setTelPhones(Object telPhones) {
                this.telPhones = telPhones;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
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
