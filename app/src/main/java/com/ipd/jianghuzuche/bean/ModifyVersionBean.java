package com.ipd.jianghuzuche.bean;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/6/10.
 */
public class ModifyVersionBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"versionYes":{"searchValue":null,"createBy":null,"createTime":"2019-06-25 11:53:24","updateBy":null,"updateTime":null,"remark":null,"params":{},"versionId":1,"versionNo":"1.0","platform":1,"intro":"安卓第一个版本\n","modify":1,"news":1,"type":1}}
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
         * versionYes : {"searchValue":null,"createBy":null,"createTime":"2019-06-25 11:53:24","updateBy":null,"updateTime":null,"remark":null,"params":{},"versionId":1,"versionNo":"1.0","platform":1,"intro":"安卓第一个版本\n","modify":1,"news":1,"type":1}
         */

        private VersionYesBean versionYes;

        public VersionYesBean getVersionYes() {
            return versionYes;
        }

        public void setVersionYes(VersionYesBean versionYes) {
            this.versionYes = versionYes;
        }

        public static class VersionYesBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : 2019-06-25 11:53:24
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * versionId : 1
             * versionNo : 1.0
             * platform : 1
             * intro : 安卓第一个版本
             * modify : 1
             * news : 1
             * type : 1
             */

            private Object searchValue;
            private Object createBy;
            private String createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBean params;
            private int versionId;
            private String versionNo;
            private int platform;
            private String intro;
            private int modify;
            private int news;
            private int type;

            public Object getSearchValue() {
                return searchValue;
            }

            public void setSearchValue(Object searchValue) {
                this.searchValue = searchValue;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(Object updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public int getVersionId() {
                return versionId;
            }

            public void setVersionId(int versionId) {
                this.versionId = versionId;
            }

            public String getVersionNo() {
                return versionNo;
            }

            public void setVersionNo(String versionNo) {
                this.versionNo = versionNo;
            }

            public int getPlatform() {
                return platform;
            }

            public void setPlatform(int platform) {
                this.platform = platform;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public int getModify() {
                return modify;
            }

            public void setModify(int modify) {
                this.modify = modify;
            }

            public int getNews() {
                return news;
            }

            public void setNews(int news) {
                this.news = news;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public static class ParamsBean {
            }
        }
    }
}
