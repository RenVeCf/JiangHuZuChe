package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class ChargeBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"chargeList":[{"chargeId":1,"title":"充电包天","cost":99,"icon":"图标","createTime":"2019-04-23 13:37:11","remark":"备注","chargeNum":null,"status":null,"flag":true},{"chargeId":2,"title":"充电包月","cost":999,"icon":"图标","createTime":"2019-04-23 13:37:35","remark":"备注","chargeNum":null,"status":null,"flag":true},{"chargeId":3,"title":"充电一年","cost":9999,"icon":"图标","createTime":"2019-04-23 13:37:58","remark":"备注","chargeNum":null,"status":null,"flag":true}]}
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
        private List<ChargeListBean> chargeList;

        public List<ChargeListBean> getChargeList() {
            return chargeList;
        }

        public void setChargeList(List<ChargeListBean> chargeList) {
            this.chargeList = chargeList;
        }

        public static class ChargeListBean {
            /**
             * chargeId : 1
             * title : 充电包天
             * cost : 99.0
             * icon : 图标
             * createTime : 2019-04-23 13:37:11
             * remark : 备注
             * chargeNum : null
             * status : null
             * flag : true
             */

            private int chargeId;
            private String title;
            private double cost;
            private String icon;
            private String createTime;
            private String remark;
            private Object chargeNum;
            private Object status;
            private boolean flag;

            public int getChargeId() {
                return chargeId;
            }

            public void setChargeId(int chargeId) {
                this.chargeId = chargeId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getCost() {
                return cost;
            }

            public void setCost(double cost) {
                this.cost = cost;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public Object getChargeNum() {
                return chargeNum;
            }

            public void setChargeNum(Object chargeNum) {
                this.chargeNum = chargeNum;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public boolean isFlag() {
                return flag;
            }

            public void setFlag(boolean flag) {
                this.flag = flag;
            }
        }
    }
}
