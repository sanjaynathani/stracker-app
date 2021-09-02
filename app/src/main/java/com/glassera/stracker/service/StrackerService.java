package com.glassera.stracker.service;

import com.glassera.stracker.service.dto.BankDto;
import com.glassera.stracker.service.dto.UserDto;

import java.util.List;

public interface StrackerService {

    UserDto authenticate(String username, String password);

    UserDto logOut();

    List<BankDto> getBankInfo();

}
