package com.erp.constants;

/**
 * @author xielulin
 * @create 2018-11-18 13:36
 * @desc RedisConstans
 **/

public class Constant {

    /**
     * @description 返回结果状态码
     * @author xielulin
     * @date 2018/12/28
     */
    public static final class ResultConstant{
        public static final int FAIL = 10000;
        public static final int SUCCESS = 200;
    }

    /**
     * @description redis数据库码
     * @author xielulin
     * @date 2018/12/28
     */
    public static final class RedisConstant {
        //第0个库
        public static final int DATABASE_0 = 0;

        public static final int DATABASE_1 = 1;

        public static final int DATABASE_2 = 2;

        public static final int DATABASE_3 = 3;

        public static final int DATABASE_4 = 4;

        public static final int DATABASE_5 = 5;

        public static final int DATABASE_6 = 6;

        public static final int DATABASE_7 = 7;

        public static final int DATABASE_8 = 8;

        public static final int DATABASE_9 = 9;

        public static final int DATABASE_10 = 10;

        public static final int DATABASE_11 = 11;

        public static final int DATABASE_12 = 12;

        public static final int DATABASE_13 = 13;

        public static final int DATABASE_14 = 14;

        public static final int DATABASE_15 = 15;

        public static final String TOKEN_KEY = "Authentication:";
        /**
         * 验证码有效时间
         */
        public static final Integer VERIFICATION_CODE_ALIVE_TIME = 5;
        public static final String VERIFICATION_CODE_KEY = "verificationCode:";
    }

    /**
     * @description 用户状态码
     * @author xielulin
     * @date 2018/12/28
     */
    public static final class UserStatusConstant{
        /**
         * @description 正常状态
         **/
        public static final byte UNDELETE = 1;  //正常状态
        public static final byte LOCKED = 2;    //被锁定状态
        public static final byte DELETE = 3;    //删除状态
    }

    /**
     * @description 企业等级状态码
     * @author xielulin
     * @date 2018/12/28
     */
    public static final class CompanyLevelConstant{

        public static final byte NORMAL = 1;  //普通企业
        public static final byte VIP = 2;    //vip企业 数据+图表
        public static final byte DATA = 3;  //数据
        public static final byte CHART = 4; //图表
    }

    public static final class UserLevelConstant{
        public static final byte MAIN = 1;  //主账号
        public static final byte CHIRED = 2;    //子账号
    }
}

