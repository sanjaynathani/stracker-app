package com.glassera.stracker.activity.dashboard.ui.payment;

import androidx.annotation.Nullable;
import com.glassera.stracker.service.dto.InvestmentDto;
import com.glassera.stracker.service.dto.PaymentDto;

import java.util.List;

public class PaymentResult {

    @Nullable
    private List<PaymentDto> paymentDtoList;

    public PaymentResult(@Nullable List<PaymentDto> paymentDtoList) {
        this.paymentDtoList = paymentDtoList;
    }

    @Nullable
    public List<PaymentDto> getPaymentDtoList() {
        return paymentDtoList;
    }
}
