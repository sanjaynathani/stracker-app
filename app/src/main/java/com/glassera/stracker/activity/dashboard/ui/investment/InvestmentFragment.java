package com.glassera.stracker.activity.dashboard.ui.investment;

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
import com.glassera.stracker.databinding.FragmentInvestmentBinding;
import com.glassera.stracker.service.dto.InvestmentDto;

import java.util.List;

public class InvestmentFragment extends Fragment {

    private static final String TAG = "InvestmentFragment";
    private InvestmentViewModel investmentViewModel;
    private FragmentInvestmentBinding binding;

    //private BankAdapter bankAdapter;
    private InvestmentListAdapter investmentListAdapter;
    private ExpandableListView expandableListView;
    private List<InvestmentDto> investmentInfo;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        investmentViewModel =
                new ViewModelProvider(this).get(InvestmentViewModel.class);

        binding = FragmentInvestmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        progressBar = binding.resultProgressBar;
        layoutManager = new LinearLayoutManager(getActivity());

        expandableListView = binding.expandableListView;
        investmentViewModel.getInvestmentInfo();
        investmentViewModel.getInvestmentInfoResult().observe(getViewLifecycleOwner(), investmentInfo -> {
            this.investmentInfo = investmentInfo.getInvestmentDtoList();
            investmentListAdapter = new InvestmentListAdapter(getContext(), this.investmentInfo);
            expandableListView.setAdapter(investmentListAdapter);
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