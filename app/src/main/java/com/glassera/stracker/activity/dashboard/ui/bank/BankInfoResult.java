package com.glassera.stracker.activity.dashboard.ui.bank;

import androidx.annotation.Nullable;
import com.glassera.stracker.service.dto.BankDto;

import java.util.List;

public class BankInfoResult {

    @Nullable
    private List<BankDto> bankDtoList;

    public BankInfoResult(@Nullable List<BankDto> bankDtoList) {
        this.bankDtoList = bankDtoList;
    }

    @Nullable
    public List<BankDto> getBankDtoList() {
        return bankDtoList;
    }
}
