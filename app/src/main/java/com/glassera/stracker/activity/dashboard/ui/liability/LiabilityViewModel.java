package com.glassera.stracker.activity.dashboard.ui.liability;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.glassera.stracker.activity.dashboard.ui.investment.InvestmentResult;
import com.glassera.stracker.service.ServiceLocator;

public class LiabilityViewModel extends ViewModel {

    private MutableLiveData<LiabilityResult> liabilityResult;

    public LiabilityViewModel() {
        liabilityResult = new MutableLiveData<>();
    }

    public LiveData<LiabilityResult> getLiabilityInfo() {
        new Thread(() -> {
            liabilityResult.postValue(new LiabilityResult(ServiceLocator.getStrackerService().getLiabilityInfo()));
        }).start();
        return liabilityResult;
    }

    public MutableLiveData<LiabilityResult> getLiabilityInfoResult() {
        return liabilityResult;
    }
}