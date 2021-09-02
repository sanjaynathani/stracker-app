package com.glassera.stracker.activity.dashboard.ui.bank;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.glassera.stracker.service.ServiceLocator;
import com.glassera.stracker.service.dto.BankDto;

import java.util.List;

public class BankViewModel extends ViewModel {

    private MutableLiveData<BankInfoResult> bankInfoResult = new MutableLiveData<>();

    public BankViewModel() {
        bankInfoResult = new MutableLiveData<>();
    }

    public LiveData<BankInfoResult> getBankInfo() {
        new Thread(() -> {
            bankInfoResult.postValue(new BankInfoResult(ServiceLocator.getStrackerService().getBankInfo()));
        }).start();
        return bankInfoResult;
    }

    public MutableLiveData<BankInfoResult> getBankInfoResult() {
        return bankInfoResult;
    }
}