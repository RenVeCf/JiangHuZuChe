package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/24.
 */
public class MsgBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"messageList":[{"messageId":32,"userId":7,"title":"您的订单1907092875以支付成功","content":"请您在预约时间内去门店取出","createTime":"2019-05-23 11:27:50"},{"messageId":30,"userId":7,"title":"您的订单1963699680以支付成功","content":"请您在预约时间内去门店取出","createTime":"2019-05-23 11:03:56"},{"messageId":29,"userId":7,"title":"您的订单1957312396以支付成功","content":"请您在预约时间内去门店取出","createTime":"2019-05-23 11:02:53"},{"messageId":27,"userId":7,"title":"您的订单1933144987以支付成功","content":"请您在预约时间内去门店取出","createTime":"2019-05-22 15:15:31"},{"messageId":15,"userId":7,"title":"您的订单1927069035以支付成功","content":"请您在预约时间内去门店取出","createTime":"2019-05-21 14:14:30"},{"messageId":13,"userId":7,"title":"您的订单1984739498以支付成功","content":"请您在预约时间内去门店取出","createTime":"2019-05-20 18:24:07"},{"messageId":12,"userId":7,"title":"您的订单1924450771以支付成功","content":"请您在预约时间内去门店取出","createTime":"2019-05-20 18:14:04"}]}
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
        private List<MessageListBean> messageList;

        public List<MessageListBean> getMessageList() {
            return messageList;
        }

        public void setMessageList(List<MessageListBean> messageList) {
            this.messageList = messageList;
        }

        public static class MessageListBean {
            /**
             * messageId : 32
             * userId : 7
             * title : 您的订单1907092875以支付成功
             * content : 请您在预约时间内去门店取出
             * createTime : 2019-05-23 11:27:50
             */

            private int messageId;
            private int userId;
            private String title;
            private String content;
            private String createTime;

            public int getMessageId() {
                return messageId;
            }

            public void setMessageId(int messageId) {
                this.messageId = messageId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
