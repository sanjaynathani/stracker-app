package com.glassera.stracker.activity.dashboard.ui.liability;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.glassera.stracker.databinding.FragmentLiabilityBinding;
import com.glassera.stracker.service.dto.LiabilityDto;

import java.util.List;

public class LiabilityFragment extends Fragment {

    private static final String TAG = "LiabilityFragment";
    private LiabilityViewModel liabilityViewModel;
    private FragmentLiabilityBinding binding;

    //private BankAdapter bankAdapter;
    private LiabilityListAdapter liabilityListAdapter;
    private ExpandableListView expandableListView;
    private List<LiabilityDto> liabilityInfo;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        liabilityViewModel =
                new ViewModelProvider(this).get(LiabilityViewModel.class);

        binding = FragmentLiabilityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        progressBar = binding.resultProgressBar;
        layoutManager = new LinearLayoutManager(getActivity());

        expandableListView = binding.expandableListView;
        liabilityViewModel.getLiabilityInfo();
        liabilityViewModel.getLiabilityInfoResult().observe(getViewLifecycleOwner(), investmentInfo -> {
            this.liabilityInfo = investmentInfo.getInvestmentDtoList();
            liabilityListAdapter = new LiabilityListAdapter(getContext(), this.liabilityInfo);
            expandableListView.setAdapter(liabilityListAdapter);
            progressBar.setVisibility(View.GONE);
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}