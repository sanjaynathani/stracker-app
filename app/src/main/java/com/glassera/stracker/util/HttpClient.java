package com.glassera.stracker.util;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class HttpClient  {

    private static HttpClient instance;
    private static OkHttpClient client = new OkHttpClient();

    private HttpClient(String token) {
        client = new OkHttpClient().newBuilder().authenticator((route, response) -> {
            if (responseCount(response) >= 3) {
                return null;
            }
            String credential = Credentials.basic(token, "");
            return response.request().newBuilder().header("Authorization", credential).build();
        }).build();
    }

    public static OkHttpClient getClient() {
        return client;
    }

    public static HttpClient createNewInstance(String token) {
        instance = new HttpClient(token);
        return instance;
    }


    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result ++;
        }
        return result;
    }

}
