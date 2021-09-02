package com.glassera.stracker.activity.dashboard.ui.bank;

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
import com.glassera.stracker.databinding.FragmentBankBinding;
import com.glassera.stracker.service.dto.BankDto;

import java.util.List;

public class BankFragment extends Fragment {

    private static final String TAG = "BankFragment";
    private BankViewModel bankViewModel;
    private FragmentBankBinding binding;

    //private BankAdapter bankAdapter;
    private BankListAdapter bankListAdapter;
    private ExpandableListView expandableListView;
    private List<BankDto> bankInfo;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bankViewModel =
                new ViewModelProvider(this).get(BankViewModel.class);

        binding = FragmentBankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        progressBar = binding.bankProgressBar;
        layoutManager = new LinearLayoutManager(getActivity());

        expandableListView = binding.expandableListView;
        bankViewModel.getBankInfo();
        bankViewModel.getBankInfoResult().observe(getViewLifecycleOwner(), bankInfo -> {
            this.bankInfo = bankInfo.getBankDtoList();
            bankListAdapter = new BankListAdapter(getContext(), this.bankInfo);
            expandableListView.setAdapter(bankListAdapter);
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