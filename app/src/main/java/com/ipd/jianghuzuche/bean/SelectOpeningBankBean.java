package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class SelectOpeningBankBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"bankcardList":[{"bankcardId":1,"bankcardIcon":"picture/profile/JYJY197108909620190429161510.jpg","bankcardName":"中国建设","status":"1","createTime":"2019-04-12 17:14:15","params":{}},{"bankcardId":2,"bankcardIcon":"picture/profile/JYJY197108909620190429161510.jpg","bankcardName":"中国银行","status":"1","createTime":"2019-04-29 16:02:59","params":{}}]}
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
        private List<BankcardListBean> bankcardList;

        public List<BankcardListBean> getBankcardList() {
            return bankcardList;
        }

        public void setBankcardList(List<BankcardListBean> bankcardList) {
            this.bankcardList = bankcardList;
        }

        public static class BankcardListBean {
            /**
             * bankcardId : 1
             * bankcardIcon : picture/profile/JYJY197108909620190429161510.jpg
             * bankcardName : 中国建设
             * status : 1
             * createTime : 2019-04-12 17:14:15
             * params : {}
             */

            private int bankcardId;
            private String bankcardIcon;
            private String bankcardName;
            private String status;
            private String createTime;
            private ParamsBean params;

            public int getBankcardId() {
                return bankcardId;
            }

            public void setBankcardId(int bankcardId) {
                this.bankcardId = bankcardId;
            }

            public String getBankcardIcon() {
                return bankcardIcon;
            }

            public void setBankcardIcon(String bankcardIcon) {
                this.bankcardIcon = bankcardIcon;
            }

            public String getBankcardName() {
                return bankcardName;
            }

            public void setBankcardName(String bankcardName) {
                this.bankcardName = bankcardName;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public static class ParamsBean {
            }
        }
    }
}
