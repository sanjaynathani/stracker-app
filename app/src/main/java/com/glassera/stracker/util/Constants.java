package com.glassera.stracker.util;

import okhttp3.MediaType;

public class Constants {

    public static final String PREFERENCE = "STRACKER_PREF";
    public static final String USER_NAME = "USER_NAME";
    public static final String USER_FIRST_NAME = "USER_FIRST_NAME";
    public static final String USER_LAST_NAME = "USER_LAST_NAME";
    public static final String USER_DISPLAY_NAME = "USER_DISPLAY_NAME";
    public static final String USER_EMAIL = "USER_EMAIL";
    public static final String USER_MOBILE = "USER_MOBILE";
    public static final String AUTH_TOKEN = "AUTH_TOKEN";

    public static final String BASE_URL = "https://stracker-service.herokuapp.com/v1";
    //public static final String BASE_URL = "http://192.168.0.255:50000/v1";
    public static final String STOCKS = "/stocks";
    public static final String CRYPTO = "/crypto";
    public static final String AUTH = "/auth";
    public static final String GDATA = "/gdata";

    // Operations
    public static final String  LATEST_PRICE = "/latest_price";
    public static final String  LOGIN = "/login";
    public static final String  LOGOUT = "/logout";
    public static final String  BANK = "/bank";
    public static final String  BANK_CARD = "/bankc";
    public static final String  Investment = "/investment";
    public static final String  LIABILITY = "/liability";
    public static final String  PAYMENT = "/payment";
    public static final String  INSURANCE = "/insurance";
    // Params
    public static final String  TICKER = "ticker=<VAL>";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
}
