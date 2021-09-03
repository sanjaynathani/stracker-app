package com.glassera.stracker.activity.dashboard.ui.investment;

import androidx.annotation.Nullable;
import com.glassera.stracker.service.dto.BankCardDto;
import com.glassera.stracker.service.dto.InvestmentDto;

import java.util.List;

public class InvestmentResult {

    @Nullable
    private List<InvestmentDto> investmentDtoList;

    public InvestmentResult(@Nullable List<InvestmentDto> investmentDtoList) {
        this.investmentDtoList = investmentDtoList;
    }

    @Nullable
    public List<InvestmentDto> getInvestmentDtoList() {
        return investmentDtoList;
    }
}
