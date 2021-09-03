package com.glassera.stracker.activity.dashboard.ui.liability;

import androidx.annotation.Nullable;
import com.glassera.stracker.service.dto.LiabilityDto;

import java.util.List;

public class LiabilityResult {

    @Nullable
    private List<LiabilityDto> liabilityDtoList;

    public LiabilityResult(@Nullable List<LiabilityDto> liabilityDtoList) {
        this.liabilityDtoList = liabilityDtoList;
    }

    @Nullable
    public List<LiabilityDto> getInvestmentDtoList() {
        return liabilityDtoList;
    }
}
