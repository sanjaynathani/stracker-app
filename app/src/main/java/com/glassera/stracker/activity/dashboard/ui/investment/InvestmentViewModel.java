package com.glassera.stracker.activity.dashboard.ui.investment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.glassera.stracker.activity.dashboard.ui.bankcard.BankCardResult;
import com.glassera.stracker.service.ServiceLocator;

public class InvestmentViewModel extends ViewModel {

    private MutableLiveData<InvestmentResult> investmentResult;

    public InvestmentViewModel() {
        investmentResult = new MutableLiveData<>();
    }

    public LiveData<InvestmentResult> getInvestmentInfo() {
        new Thread(() -> {
            investmentResult.postValue(new InvestmentResult(ServiceLocator.getStrackerService().getInvestmentInfo()));
        }).start();
        return investmentResult;
    }

    public MutableLiveData<InvestmentResult> getInvestmentInfoResult() {
        return investmentResult;
    }
}