package com.glassera.stracker.activity.dashboard.ui.investment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InvestmentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InvestmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is investment fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}