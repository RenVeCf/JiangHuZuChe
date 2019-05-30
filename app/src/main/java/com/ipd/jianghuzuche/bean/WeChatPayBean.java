package com.ipd.jianghuzuche.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/29.
 */
public class WeChatPayBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"data":{"package":"Sign=WXPay","appid":"wx1a65c563b86ec579","sign":"531F6D04B068FD71E01A265D36A60DFA","partnerid":"1535916031","prepayid":"wx29143304697949bd30f5ca216530250000","noncestr":"1433048191","timestamp":1559111584}}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : {"package":"Sign=WXPay","appid":"wx1a65c563b86ec579","sign":"531F6D04B068FD71E01A265D36A60DFA","partnerid":"1535916031","prepayid":"wx29143304697949bd30f5ca216530250000","noncestr":"1433048191","timestamp":1559111584}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * package : Sign=WXPay
             * appid : wx1a65c563b86ec579
             * sign : 531F6D04B068FD71E01A265D36A60DFA
             * partnerid : 1535916031
             * prepayid : wx29143304697949bd30f5ca216530250000
             * noncestr : 1433048191
             * timestamp : 1559111584
             */

            @SerializedName("package")
            private String packageX;
            private String appid;
            private String sign;
            private String partnerid;
            private String prepayid;
            private String noncestr;
            private int timestamp;

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }

            public String getNoncestr() {
                return noncestr;
            }

            public void setNoncestr(String noncestr) {
                this.noncestr = noncestr;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }
        }
    }
}
