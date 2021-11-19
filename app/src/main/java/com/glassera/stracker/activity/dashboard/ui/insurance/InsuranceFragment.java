package com.glassera.stracker.activity.dashboard.ui.insurance;

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
import com.glassera.stracker.databinding.FragmentInsuranceBinding;
import com.glassera.stracker.service.dto.InsuranceDto;

import java.util.List;

public class InsuranceFragment extends Fragment {

    private static final String TAG = "InsuranceFragment";
    private InsuranceViewModel insuranceViewModel;
    private FragmentInsuranceBinding binding;

    //private BankAdapter bankAdapter;
    private InsuranceListAdapter insuranceListAdapter;
    private ExpandableListView expandableListView;
    private List<InsuranceDto> insuranceInfo;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        insuranceViewModel =
                new ViewModelProvider(this).get(InsuranceViewModel.class);

        binding = FragmentInsuranceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        progressBar = binding.resultProgressBar;
        layoutManager = new LinearLayoutManager(getActivity());

        expandableListView = binding.expandableListView;
        insuranceViewModel.getInsuranceInfo();
        insuranceViewModel.getInsuranceResult().observe(getViewLifecycleOwner(), insuranceInfo -> {
            this.insuranceInfo = insuranceInfo.getInsuranceDtoList();
            insuranceListAdapter = new InsuranceListAdapter(getContext(), this.insuranceInfo);
            expandableListView.setAdapter(insuranceListAdapter);
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
