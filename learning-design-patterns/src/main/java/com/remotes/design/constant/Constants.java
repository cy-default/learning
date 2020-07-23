package com.remotes.design.constant;

/**
 * 常量池
 * @author yuan.chen
 * @email yuan.chen@ingeek.com
 * @company INGEEK
 * @Date 2019-05-14
 */
public class Constants {

    /**
     * 策略模式
     */
    public enum Strategy{

        /**
         * 专属会员
         */
        ParticularlyVipBuyer("ParticularlyVipBuyer", "专属会员"),

        /**
         * 超级会员
         */
        SuperVipBuyer("SuperVipBuyer", "超级会员"),

        /**
         * 普通会员
         */
        VipBuyer("VipBuyer", "普通会员");


        private String code;
        private String name;

        Strategy(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
