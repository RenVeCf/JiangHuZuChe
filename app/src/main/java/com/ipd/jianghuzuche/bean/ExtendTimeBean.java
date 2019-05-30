package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/26.
 */
public class ExtendTimeBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"lateMoney":2.6,"vehicleServices":[{"servicesId":6,"servicesName":"充电服务","servicesCost":998,"status":null,"createTime":"2019-05-27 11:15:38","params":{}}],"vehicleList":{"vehicleId":10,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192671649320190522151427.jpg","storeId":7,"equipCost":100,"deposit":1000,"vehicleRent":50,"createTime":"2019-05-22 15:14:39","rentOften":3,"details":"<p>185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087<\/p>"}}
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
         * lateMoney : 2.6
         * vehicleServices : [{"servicesId":6,"servicesName":"充电服务","servicesCost":998,"status":null,"createTime":"2019-05-27 11:15:38","params":{}}]
         * vehicleList : {"vehicleId":10,"vehicleName":"小刀电动车","vehicleModel":"xs25445","vehicleLogo":"picture/profile/JYJY192671649320190522151427.jpg","storeId":7,"equipCost":100,"deposit":1000,"vehicleRent":50,"createTime":"2019-05-22 15:14:39","rentOften":3,"details":"<p>185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087<\/p>"}
         */

        private double lateMoney;
        private VehicleListBean vehicleList;
        private List<VehicleServicesBean> vehicleServices;

        public double getLateMoney() {
            return lateMoney;
        }

        public void setLateMoney(double lateMoney) {
            this.lateMoney = lateMoney;
        }

        public VehicleListBean getVehicleList() {
            return vehicleList;
        }

        public void setVehicleList(VehicleListBean vehicleList) {
            this.vehicleList = vehicleList;
        }

        public List<VehicleServicesBean> getVehicleServices() {
            return vehicleServices;
        }

        public void setVehicleServices(List<VehicleServicesBean> vehicleServices) {
            this.vehicleServices = vehicleServices;
        }

        public static class VehicleListBean {
            /**
             * vehicleId : 10
             * vehicleName : 小刀电动车
             * vehicleModel : xs25445
             * vehicleLogo : picture/profile/JYJY192671649320190522151427.jpg
             * storeId : 7
             * equipCost : 100.0
             * deposit : 1000.0
             * vehicleRent : 50.0
             * createTime : 2019-05-22 15:14:39
             * rentOften : 3
             * details : <p>185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087185029940871850299408718502994087</p>
             */

            private int vehicleId;
            private String vehicleName;
            private String vehicleModel;
            private String vehicleLogo;
            private int storeId;
            private double equipCost;
            private double deposit;
            private double vehicleRent;
            private String createTime;
            private int rentOften;
            private String details;

            public int getVehicleId() {
                return vehicleId;
            }

            public void setVehicleId(int vehicleId) {
                this.vehicleId = vehicleId;
            }

            public String getVehicleName() {
                return vehicleName;
            }

            public void setVehicleName(String vehicleName) {
                this.vehicleName = vehicleName;
            }

            public String getVehicleModel() {
                return vehicleModel;
            }

            public void setVehicleModel(String vehicleModel) {
                this.vehicleModel = vehicleModel;
            }

            public String getVehicleLogo() {
                return vehicleLogo;
            }

            public void setVehicleLogo(String vehicleLogo) {
                this.vehicleLogo = vehicleLogo;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public double getEquipCost() {
                return equipCost;
            }

            public void setEquipCost(double equipCost) {
                this.equipCost = equipCost;
            }

            public double getDeposit() {
                return deposit;
            }

            public void setDeposit(double deposit) {
                this.deposit = deposit;
            }

            public double getVehicleRent() {
                return vehicleRent;
            }

            public void setVehicleRent(double vehicleRent) {
                this.vehicleRent = vehicleRent;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getRentOften() {
                return rentOften;
            }

            public void setRentOften(int rentOften) {
                this.rentOften = rentOften;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }
        }

        public static class VehicleServicesBean {
            /**
             * servicesId : 6
             * servicesName : 充电服务
             * servicesCost : 998.0
             * status : null
             * createTime : 2019-05-27 11:15:38
             * params : {}
             */

            private int servicesId;
            private String servicesName;
            private double servicesCost;
            private Object status;
            private String createTime;
            private ParamsBean params;

            public int getServicesId() {
                return servicesId;
            }

            public void setServicesId(int servicesId) {
                this.servicesId = servicesId;
            }

            public String getServicesName() {
                return servicesName;
            }

            public void setServicesName(String servicesName) {
                this.servicesName = servicesName;
            }

            public double getServicesCost() {
                return servicesCost;
            }

            public void setServicesCost(double servicesCost) {
                this.servicesCost = servicesCost;
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
