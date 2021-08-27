package com.glassera.stracker.service.impl;

import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glassera.stracker.service.StrackerService;
import com.glassera.stracker.service.dto.UserDto;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class StrackerServiceImpl implements StrackerService {

    private static final String TAG = "StrackerServiceImpl";
    private static final String BASE_URL = "https://stracker-service.herokuapp.com/v1";
    //private static final String BASE_URL = "http://localhost:50000/v1";
    private static final String STOCKS = "/stocks";
    private static final String CRYPTO = "/crypto";
    private static final String AUTH = "/auth";
    // Operations
    private static final String  LATEST_PRICE = "/latest_price";
    private static final String  LOGIN = "/login";
    private static final String  LOGOUT = "/logout";
    // Params
    private static final String  TICKER = "ticker=<VAL>";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static OkHttpClient client = new OkHttpClient();
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Override
    public UserDto authenticate(String username, String password) {
        Future<UserDto> future = executorService.submit(() -> login(username, password));
        try {
            return future.get();
        } catch (Exception e) {
            Log.e(TAG, "Thread execution error in authenticate", e);
        }
        return null;
    }

    private UserDto login(String username, String password) {
        try {
            final UserDto userDto = new UserDto();
            userDto.setUsername(username);
            userDto.setPassword(password);
            String json = objectMapper.writeValueAsString(userDto);
            RequestBody requestBody = RequestBody.create(json, JSON);
            Request request = new Request.Builder()
                    .url(BASE_URL + AUTH + LOGIN)
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            UserDto user = objectMapper.readValue(response.body().string(), UserDto.class);
            user.setUsername(username);
            return user;
        } catch (Exception e) {
            Log.e(TAG, "Exception in authenticate", e);
        }
        return null;
    }

    @Override
    public UserDto logOut(String token) {
        return null;
    }
}
