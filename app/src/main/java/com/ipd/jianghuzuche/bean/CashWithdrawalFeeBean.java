package com.ipd.jianghuzuche.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class CashWithdrawalFeeBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"putConf":{"putConfId":1,"putRate":0.1,"maxMoney":1000,"minMoney":100,"type":1}}
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
         * putConf : {"putConfId":1,"putRate":0.1,"maxMoney":1000,"minMoney":100,"type":1}
         */

        private PutConfBean putConf;

        public PutConfBean getPutConf() {
            return putConf;
        }

        public void setPutConf(PutConfBean putConf) {
            this.putConf = putConf;
        }

        public static class PutConfBean {
            /**
             * putConfId : 1
             * putRate : 0.1
             * maxMoney : 1000
             * minMoney : 100
             * type : 1
             */

            private int putConfId;
            private double putRate;
            private int maxMoney;
            private int minMoney;
            private int type;

            public int getPutConfId() {
                return putConfId;
            }

            public void setPutConfId(int putConfId) {
                this.putConfId = putConfId;
            }

            public double getPutRate() {
                return putRate;
            }

            public void setPutRate(double putRate) {
                this.putRate = putRate;
            }

            public int getMaxMoney() {
                return maxMoney;
            }

            public void setMaxMoney(int maxMoney) {
                this.maxMoney = maxMoney;
            }

            public int getMinMoney() {
                return minMoney;
            }

            public void setMinMoney(int minMoney) {
                this.minMoney = minMoney;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
