package com.glassera.stracker.service.impl;

import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glassera.stracker.service.StrackerService;
import com.glassera.stracker.service.dto.BankDto;
import com.glassera.stracker.service.dto.UserDto;
import com.glassera.stracker.util.Constants;
import com.glassera.stracker.util.HttpClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class StrackerServiceImpl implements StrackerService {

    private static final String TAG = "StrackerServiceImpl";
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static OkHttpClient client = HttpClient.getClient();
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Override
    public UserDto authenticate(String username, String password) {
        try {
            final UserDto userDto = new UserDto();
            userDto.setUsername(username);
            userDto.setPassword(password);
            String json = objectMapper.writeValueAsString(userDto);
            RequestBody requestBody = RequestBody.create(json, Constants.JSON);
            Request request = new Request.Builder()
                    .url(Constants.BASE_URL + Constants.AUTH + Constants.LOGIN)
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            UserDto user = objectMapper.readValue(response.body().string(), UserDto.class);
            user.setUsername(username);
            HttpClient.createNewInstance(user.getToken());
            client = HttpClient.getClient();
            return user;
        } catch (Exception e) {
            Log.e(TAG, "Exception in authenticate", e);
        }
        return null;
    }

    @Override
    public UserDto logOut() {
        Future<UserDto> future = executorService.submit(() -> doLogOut());
        try {
            return future.get();
        } catch (Exception e) {
            Log.e(TAG, "Thread execution error in logOut", e);
        }
        return null;
    }

    private UserDto doLogOut() {
        try {
            Request request = new Request.Builder()
                    .url(Constants.BASE_URL + Constants.AUTH + Constants.LOGOUT)
                    .post(RequestBody.create("", Constants.JSON))
                    .build();
            Response response = client.newCall(request).execute();
            UserDto userDto = objectMapper.readValue(response.body().string(), UserDto.class);
            return userDto;
        } catch (Exception e) {
            Log.e(TAG, "Exception in doLogOut", e);
        }
        return null;
    }

    @Override
    public List<BankDto> getBankInfo() {
        try {
            Request request = new Request.Builder()
                    .url(Constants.BASE_URL + Constants.GDATA + Constants.BANK)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            List<BankDto> bankDtos = Arrays.asList(objectMapper.readValue(response.body().string(), BankDto[].class));
            return bankDtos;
        } catch (Exception e) {
            Log.e(TAG, "Exception in getBankInfo", e);
        }
        return null;
    }
}
