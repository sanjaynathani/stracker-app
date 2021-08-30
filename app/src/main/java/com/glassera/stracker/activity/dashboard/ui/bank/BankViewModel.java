package com.glassera.stracker.activity.dashboard.ui.bank;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BankViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BankViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is bank fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}