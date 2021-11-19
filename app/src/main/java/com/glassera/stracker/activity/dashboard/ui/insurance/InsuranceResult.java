package com.glassera.stracker.activity.dashboard.ui.insurance;

import androidx.annotation.Nullable;
import com.glassera.stracker.service.dto.InsuranceDto;

import java.util.List;

public class InsuranceResult {

    @Nullable
    private List<InsuranceDto> insuranceDtoList;

    public InsuranceResult(@Nullable List<InsuranceDto> insuranceDtoList) {
        this.insuranceDtoList = insuranceDtoList;
    }

    @Nullable
    public List<InsuranceDto> getInsuranceDtoList() {
        return insuranceDtoList;
    }
}
