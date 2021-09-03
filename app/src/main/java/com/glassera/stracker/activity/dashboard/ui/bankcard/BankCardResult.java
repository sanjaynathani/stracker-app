package com.glassera.stracker.activity.dashboard.ui.bankcard;

import androidx.annotation.Nullable;
import com.glassera.stracker.service.dto.BankCardDto;

import java.util.List;

public class BankCardResult {

    @Nullable
    private List<BankCardDto> bankCardDtoList;

    public BankCardResult(@Nullable List<BankCardDto> bankCardDtoList) {
        this.bankCardDtoList = bankCardDtoList;
    }

    @Nullable
    public List<BankCardDto> getBankCardDtoList() {
        return bankCardDtoList;
    }
}
