package com.glassera.stracker.activity.dashboard.ui.payment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.glassera.stracker.service.ServiceLocator;

public class PaymentViewModel extends ViewModel {

    private MutableLiveData<PaymentResult> paymentResult;

    public PaymentViewModel() {
        paymentResult = new MutableLiveData<>();
    }

    public LiveData<PaymentResult> getPaymentInfo() {
        new Thread(() -> {
            paymentResult.postValue(new PaymentResult(ServiceLocator.getStrackerService().getPaymentInfo()));
        }).start();
        return paymentResult;
    }

    public MutableLiveData<PaymentResult> getPaymentInfoResult() {
        return paymentResult;
    }
}