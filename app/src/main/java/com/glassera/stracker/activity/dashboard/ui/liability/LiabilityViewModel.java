package com.glassera.stracker.activity.dashboard.ui.liability;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiabilityViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LiabilityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is liability fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}