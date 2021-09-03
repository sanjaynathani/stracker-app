package com.glassera.stracker.activity.dashboard.ui.bankcard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.glassera.stracker.service.ServiceLocator;

public class BankCardViewModel extends ViewModel {

    private MutableLiveData<BankCardResult> bankCardResult;

    public BankCardViewModel() {
        bankCardResult = new MutableLiveData<>();
    }

    public LiveData<BankCardResult> getBankCardInfo() {
        new Thread(() -> {
            bankCardResult.postValue(new BankCardResult(ServiceLocator.getStrackerService().getBankCardInfo()));
        }).start();
        return bankCardResult;
    }

    public MutableLiveData<BankCardResult> getBankCardInfoResult() {
        return bankCardResult;
    }
}