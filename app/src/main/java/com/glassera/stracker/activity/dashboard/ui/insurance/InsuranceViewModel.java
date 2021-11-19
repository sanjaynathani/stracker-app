package com.glassera.stracker.activity.dashboard.ui.insurance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.glassera.stracker.activity.dashboard.ui.bank.BankInfoResult;
import com.glassera.stracker.service.ServiceLocator;

public class InsuranceViewModel extends ViewModel {

    private MutableLiveData<InsuranceResult> insuranceResult = new MutableLiveData<>();

    public InsuranceViewModel() {
        insuranceResult = new MutableLiveData<>();
    }

    public LiveData<InsuranceResult> getInsuranceInfo() {
        new Thread(() -> {
            insuranceResult.postValue(new InsuranceResult(ServiceLocator.getStrackerService().getInsuranceInfo()));
        }).start();
        return insuranceResult;
    }

    public MutableLiveData<InsuranceResult> getInsuranceResult() {
        return insuranceResult;
    }
}
