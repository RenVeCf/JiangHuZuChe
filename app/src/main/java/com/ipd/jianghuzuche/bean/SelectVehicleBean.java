package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class SelectVehicleBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehicleOrstatus":[{"orstatusId":68,"vestatusName":"大灯头部","damagedCost":2,"status":2,"orderId":58,"statusId":3,"userId":null,"createTime":"2019-05-13 18:08:30","type":null},{"orstatusId":69,"vestatusName":"大灯2","damagedCost":2,"status":1,"orderId":58,"statusId":4,"userId":null,"createTime":"2019-05-13 18:08:30","type":null}],"vehiclePic":{"vehicleInfoId":49,"picPath":"picture/vehicle/JYJY190933291220190513180813.jpg,picture/vehicle/JYJY190936078720190513180813.jpg,picture/vehicle/JYJY190933788620190513180813.jpg,picture/vehicle/JYJY190936508420190513180813.jpg","plateNumber":"123","orderId":58,"createTime":null}}
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
         * vehicleOrstatus : [{"orstatusId":68,"vestatusName":"大灯头部","damagedCost":2,"status":2,"orderId":58,"statusId":3,"userId":null,"createTime":"2019-05-13 18:08:30","type":null},{"orstatusId":69,"vestatusName":"大灯2","damagedCost":2,"status":1,"orderId":58,"statusId":4,"userId":null,"createTime":"2019-05-13 18:08:30","type":null}]
         * vehiclePic : {"vehicleInfoId":49,"picPath":"picture/vehicle/JYJY190933291220190513180813.jpg,picture/vehicle/JYJY190936078720190513180813.jpg,picture/vehicle/JYJY190933788620190513180813.jpg,picture/vehicle/JYJY190936508420190513180813.jpg","plateNumber":"123","orderId":58,"createTime":null}
         */

        private VehiclePicBean vehiclePic;
        private List<VehicleOrstatusBean> vehicleOrstatus;

        public VehiclePicBean getVehiclePic() {
            return vehiclePic;
        }

        public void setVehiclePic(VehiclePicBean vehiclePic) {
            this.vehiclePic = vehiclePic;
        }

        public List<VehicleOrstatusBean> getVehicleOrstatus() {
            return vehicleOrstatus;
        }

        public void setVehicleOrstatus(List<VehicleOrstatusBean> vehicleOrstatus) {
            this.vehicleOrstatus = vehicleOrstatus;
        }

        public static class VehiclePicBean {
            /**
             * vehicleInfoId : 49
             * picPath : picture/vehicle/JYJY190933291220190513180813.jpg,picture/vehicle/JYJY190936078720190513180813.jpg,picture/vehicle/JYJY190933788620190513180813.jpg,picture/vehicle/JYJY190936508420190513180813.jpg
             * plateNumber : 123
             * orderId : 58
             * createTime : null
             */

            private int vehicleInfoId;
            private String picPath;
            private String plateNumber;
            private int orderId;
            private Object createTime;

            public int getVehicleInfoId() {
                return vehicleInfoId;
            }

            public void setVehicleInfoId(int vehicleInfoId) {
                this.vehicleInfoId = vehicleInfoId;
            }

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public String getPlateNumber() {
                return plateNumber;
            }

            public void setPlateNumber(String plateNumber) {
                this.plateNumber = plateNumber;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }
        }

        public static class VehicleOrstatusBean {
            /**
             * orstatusId : 68
             * vestatusName : 大灯头部
             * damagedCost : 2
             * status : 2
             * orderId : 58
             * statusId : 3
             * userId : null
             * createTime : 2019-05-13 18:08:30
             * type : null
             */

            private int orstatusId;
            private String vestatusName;
            private int damagedCost;
            private int status;
            private int orderId;
            private int statusId;
            private Object userId;
            private String createTime;
            private Object type;

            public int getOrstatusId() {
                return orstatusId;
            }

            public void setOrstatusId(int orstatusId) {
                this.orstatusId = orstatusId;
            }

            public String getVestatusName() {
                return vestatusName;
            }

            public void setVestatusName(String vestatusName) {
                this.vestatusName = vestatusName;
            }

            public int getDamagedCost() {
                return damagedCost;
            }

            public void setDamagedCost(int damagedCost) {
                this.damagedCost = damagedCost;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getStatusId() {
                return statusId;
            }

            public void setStatusId(int statusId) {
                this.statusId = statusId;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }
        }
    }
}
