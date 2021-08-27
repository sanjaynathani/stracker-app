package com.glassera.stracker.service;

import com.glassera.stracker.service.dto.UserDto;

public interface StrackerService {

    UserDto authenticate(String username, String password);

    UserDto logOut(String token);

}
