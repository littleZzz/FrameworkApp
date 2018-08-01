package com.boyacx.frameworkapp.bean;

/**
 * Created by admin on 2018/8/1.
 */

public class QuestBean {

    /**
     * params : {"sourceOsType":"30500001","password":"123456","loginType":"24200004","applyType":"25800002","loginNo":"15756281581"}
     */

    private ParamsBean params;

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public static class ParamsBean {
        /**
         * sourceOsType : 30500001
         * password : 123456
         * loginType : 24200004
         * applyType : 25800002
         * loginNo : 15756281581
         */

        private String sourceOsType;
        private String password;
        private String loginType;
        private String applyType;
        private String loginNo;

        public String getSourceOsType() {
            return sourceOsType;
        }

        public void setSourceOsType(String sourceOsType) {
            this.sourceOsType = sourceOsType;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getLoginType() {
            return loginType;
        }

        public void setLoginType(String loginType) {
            this.loginType = loginType;
        }

        public String getApplyType() {
            return applyType;
        }

        public void setApplyType(String applyType) {
            this.applyType = applyType;
        }

        public String getLoginNo() {
            return loginNo;
        }

        public void setLoginNo(String loginNo) {
            this.loginNo = loginNo;
        }
    }
}
