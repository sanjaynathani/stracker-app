package com.glassera.stracker.service;

import com.glassera.stracker.service.dto.BankCardDto;
import com.glassera.stracker.service.dto.BankDto;
import com.glassera.stracker.service.dto.InsuranceDto;
import com.glassera.stracker.service.dto.InvestmentDto;
import com.glassera.stracker.service.dto.LiabilityDto;
import com.glassera.stracker.service.dto.PaymentDto;
import com.glassera.stracker.service.dto.UserDto;

import java.util.List;

public interface StrackerService {

    UserDto authenticate(String username, String password);

    UserDto logOut();

    List<BankDto> getBankInfo();

    List<BankCardDto> getBankCardInfo();

    List<InvestmentDto> getInvestmentInfo();

    List<LiabilityDto> getLiabilityInfo();

    List<PaymentDto> getPaymentInfo();

    List<InsuranceDto> getInsuranceInfo();

}
