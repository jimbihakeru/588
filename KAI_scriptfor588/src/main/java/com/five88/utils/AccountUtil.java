package com.five88.utils;

import com.five88.models.AccountModel;

public class AccountUtil {

    static AccountUtil instance;

    public static AccountUtil getInstance() {
        if (instance == null)
            instance = new AccountUtil();
        return instance;
    }

    public AccountModel getAvailableAccount() {
        return new AccountModel("f88autotest", "qwer1234", "0911212121");
    }

    public AccountModel getAvailableAccountWithMoney() {
        return new AccountModel("testautof88", "qwer1234", "0901212121");
    }

    public AccountModel createRandomAccount() {
        String user = Constant.APP_PREFIX + Util.generateRandomeString(8) + Constant.APP_SUFFIX;
        String pass = Util.generateRandomeString(8);
        String phone = String.format("098%s", Util.randomNumber(7));
        return new AccountModel(user, pass, phone);
    }

    public AccountModel createAccWithAccented() {
        String user = "trần văn tí";
        String pass = Util.generateRandomeString(8);
        String phone = String.format("098%s", Util.randomNumber(7));
        return new AccountModel(user, pass, phone);
    }

    public AccountModel createAccWithUserLen(int len) {
        String user = Util.generateRandomeString(len);
        String pass = Util.generateRandomeString(8);
        String phone = String.format("098%s", Util.randomNumber(7));
        return new AccountModel(user, pass, phone);
    }

    public AccountModel createAccWithPassLen(int len) {
        String user = Util.generateRandomeString(8);
        String pass = Util.generateRandomeString(len);
        String phone = String.format("098%s", Util.randomNumber(7));
        return new AccountModel(user, pass, phone);
    }

    public AccountModel createAccWithPhoneLen(int len) {
        String user = Util.generateRandomeString(8);
        String pass = Util.generateRandomeString(8);
        String phone = Util.randomNumber(len);
        return new AccountModel(user, pass, phone);
    }

}
