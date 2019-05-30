package com.ipd.jianghuzuche.bean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/26.
 */
public class ExtendTimeListBean {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"vehicleServices":[{"servicesId":6,"servicesName":"充电服务","servicesCost":998,"status":null,"createTime":"2019-05-27 11:15:38","params":{}}]}
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
        private List<VehicleServicesBean> vehicleServices;

        public List<VehicleServicesBean> getVehicleServices() {
            return vehicleServices;
        }

        public void setVehicleServices(List<VehicleServicesBean> vehicleServices) {
            this.vehicleServices = vehicleServices;
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
