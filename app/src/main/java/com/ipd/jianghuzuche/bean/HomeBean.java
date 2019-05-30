package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/28.
 */
public class HomeBean {

    /**
     * code : 200
     * msg : 操作成功
     * data : {"pictureList":[{"pictureId":3,"title":"11","picPath":"picture/profile/JYJY197108909620190429161510.jpg","status":1,"content":"<p>111<\/p>","type":1,"creteTime":"2019-04-29 16:15:15","pictureType":1},{"pictureId":4,"title":"1111","picPath":"picture/profile/JYJY197213490020190429161521.jpg","status":1,"content":"<p>11111<\/p>","type":1,"creteTime":"2019-04-29 16:15:26","pictureType":2},{"pictureId":5,"title":"111","picPath":"picture/profile/JYJY197308142120190429161530.jpg","status":1,"content":"<p>11111<\/p>","type":1,"creteTime":"2019-04-29 16:15:34","pictureType":1},{"pictureId":6,"title":"111","picPath":"picture/profile/JYJY197414012920190429161541.jpg","status":1,"content":"<p>111<\/p>","type":1,"creteTime":"2019-04-29 16:15:46","pictureType":1}]}
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
        private List<PictureListBean> pictureList;

        public List<PictureListBean> getPictureList() {
            return pictureList;
        }

        public void setPictureList(List<PictureListBean> pictureList) {
            this.pictureList = pictureList;
        }

        public static class PictureListBean {
            /**
             * pictureId : 3
             * title : 11
             * picPath : picture/profile/JYJY197108909620190429161510.jpg
             * status : 1
             * content : <p>111</p>
             * type : 1
             * creteTime : 2019-04-29 16:15:15
             * pictureType : 1
             */

            private int pictureId;
            private String title;
            private String picPath;
            private int status;
            private String content;
            private int type;
            private String creteTime;
            private int pictureType;

            public int getPictureId() {
                return pictureId;
            }

            public void setPictureId(int pictureId) {
                this.pictureId = pictureId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getCreteTime() {
                return creteTime;
            }

            public void setCreteTime(String creteTime) {
                this.creteTime = creteTime;
            }

            public int getPictureType() {
                return pictureType;
            }

            public void setPictureType(int pictureType) {
                this.pictureType = pictureType;
            }
        }
    }
}
