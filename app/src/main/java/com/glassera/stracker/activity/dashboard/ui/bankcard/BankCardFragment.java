package com.glassera.stracker.activity.dashboard.ui.bankcard;

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
import com.glassera.stracker.databinding.FragmentBankCardBinding;
import com.glassera.stracker.service.dto.BankCardDto;

import java.util.List;

public class BankCardFragment extends Fragment {

    private static final String TAG = "BankCardFragment";
    private BankCardViewModel bankCardViewModel;
    private FragmentBankCardBinding binding;

    //private BankAdapter bankAdapter;
    private BankCardListAdapter bankCardListAdapter;
    private ExpandableListView expandableListView;
    private List<BankCardDto> bankCardInfo;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bankCardViewModel =
                new ViewModelProvider(this).get(BankCardViewModel.class);

        binding = FragmentBankCardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        progressBar = binding.resultProgressBar;
        layoutManager = new LinearLayoutManager(getActivity());

        expandableListView = binding.expandableListView;
        bankCardViewModel.getBankCardInfo();
        bankCardViewModel.getBankCardInfoResult().observe(getViewLifecycleOwner(), bankCardInfo -> {
            this.bankCardInfo = bankCardInfo.getBankCardDtoList();
            bankCardListAdapter = new BankCardListAdapter(getContext(), this.bankCardInfo);
            expandableListView.setAdapter(bankCardListAdapter);
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