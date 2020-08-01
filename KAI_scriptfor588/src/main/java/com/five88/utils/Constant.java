package com.five88.utils;

public class Constant {

    public static final boolean DEBUG = false;
    public static final AppEnum.DriverType BROSER_TYPE = AppEnum.DriverType.CHROME;

    public static final int TIME_OUT = 5;
    public static final int TIME_OUT_LONG = 30;
    public static final String APP_NAME = "Five88";
    public static final String APP_PREFIX = "f88-";
    public static final String APP_SUFFIX = "-f88";

    public static final String FIVE88_SUITE = "five88_suite.xml";
    public static final String FIVE88_SUITE_2 = "five88_suite_2.xml";
    public static final String FIVE88_TESTCASE_FILE = "five88.xlsx";
    public static final String FIVE88_TESTCASE_SHEET = " Auto Test Case- Desktop";

    // Message
    public static final String ERROR_MSG_SOME_THING_WRONG = "Đã có lỗi xảy ra.";
    public static final String ERROR_MSG_DATA_FORMAT_WRONG = "Dữ liệu không đúng định đạng";

    // Excel KEY
    public static final String[] KEY_TC = new String[]{
            "_home_",
            "_register_",
            "_login_",
            "_logout_",
            "_fivepay_",
            "_banking_",
            "_atm_",
            "_quaygd_",
            "_card_",
            "_account_",
            "_sport_",
            "_lode_",
            "_casino_",
            "_ng_",
            "_keno_",
            "_game_"
    };
}
