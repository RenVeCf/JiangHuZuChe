package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class RepairProjectVerticalBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"repairList":[{"repairId":2,"repairCost":99,"repairName":"大灯头部","status":null,"createTime":"2019-05-08 15:17:06","selectStatus":1,"params":{},"parentId":1},{"repairId":3,"repairCost":99,"repairName":"大灯尾部","status":null,"createTime":"2019-05-08 15:17:18","selectStatus":1,"params":{},"parentId":1}]}
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
        private List<RepairListBean> repairList;

        public List<RepairListBean> getRepairList() {
            return repairList;
        }

        public void setRepairList(List<RepairListBean> repairList) {
            this.repairList = repairList;
        }

        public static class RepairListBean {
            /**
             * repairId : 2
             * repairCost : 99
             * repairName : 大灯头部
             * status : null
             * createTime : 2019-05-08 15:17:06
             * selectStatus : 1
             * params : {}
             * parentId : 1
             */

            private int repairId;
            private int repairCost;
            private String repairName;
            private Object status;
            private String createTime;
            private int selectStatus;
            private ParamsBean params;
            private int parentId;

            public int getRepairId() {
                return repairId;
            }

            public void setRepairId(int repairId) {
                this.repairId = repairId;
            }

            public int getRepairCost() {
                return repairCost;
            }

            public void setRepairCost(int repairCost) {
                this.repairCost = repairCost;
            }

            public String getRepairName() {
                return repairName;
            }

            public void setRepairName(String repairName) {
                this.repairName = repairName;
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

            public int getSelectStatus() {
                return selectStatus;
            }

            public void setSelectStatus(int selectStatus) {
                this.selectStatus = selectStatus;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public static class ParamsBean {
            }
        }
    }
}
