package com.ipd.jianghuzuche.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/29.
 */
public class AliPayBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"data":"partner=\"2088531199085823\"&seller_id=\"hangzhoujhztc@163.com\"&out_trade_no=\"1960235042\"&subject=\"江湖租车\"&body=\"\"&total_fee=\"1200.0\"&notify_url=\"http://47.98.36.104:8010/jhzc/appUser/Pay/returnUrl\"&service=\"mobile.securitypay.pay\"&payment_type=\"1\"&_input_charset=\"utf-8\"&it_b_pay=\"30m\"&return_url=\"m.alipay.com\"&sign=\"KXlgReY8npMzRsL5xCTzb9M6CqC0WF%2BHQA1E47xSzBqvusFQcXFNW3HChGI0RsEixHdaHA2E63K8gp9Q%2FeOxY2gCrhbR9kupRMM2jPBx7dAwmjQbq2JKQZdQuv4Ibfj8u9RlzMxKA6Hzs4tRYnfnmmJkNO5Ibr6DqfQZ3NE83aQ%3D\"&sign_type=\"RSA\""}
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
         * data : partner="2088531199085823"&seller_id="hangzhoujhztc@163.com"&out_trade_no="1960235042"&subject="江湖租车"&body=""&total_fee="1200.0"&notify_url="http://47.98.36.104:8010/jhzc/appUser/Pay/returnUrl"&service="mobile.securitypay.pay"&payment_type="1"&_input_charset="utf-8"&it_b_pay="30m"&return_url="m.alipay.com"&sign="KXlgReY8npMzRsL5xCTzb9M6CqC0WF%2BHQA1E47xSzBqvusFQcXFNW3HChGI0RsEixHdaHA2E63K8gp9Q%2FeOxY2gCrhbR9kupRMM2jPBx7dAwmjQbq2JKQZdQuv4Ibfj8u9RlzMxKA6Hzs4tRYnfnmmJkNO5Ibr6DqfQZ3NE83aQ%3D"&sign_type="RSA"
         */

        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
