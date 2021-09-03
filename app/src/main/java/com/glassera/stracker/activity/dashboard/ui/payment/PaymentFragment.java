package com.glassera.stracker.activity.dashboard.ui.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.glassera.stracker.activity.dashboard.ui.investment.InvestmentListAdapter;
import com.glassera.stracker.activity.dashboard.ui.investment.InvestmentViewModel;
import com.glassera.stracker.activity.dashboard.ui.payment.PaymentViewModel;
import com.glassera.stracker.databinding.FragmentInvestmentBinding;
import com.glassera.stracker.databinding.FragmentPaymentBinding;
import com.glassera.stracker.service.dto.InvestmentDto;
import com.glassera.stracker.service.dto.PaymentDto;

import java.util.List;

public class PaymentFragment extends Fragment {

    private static final String TAG = "PaymentFragment";
    private PaymentViewModel paymentViewModel;
    private FragmentPaymentBinding binding;

    //private BankAdapter bankAdapter;
    private PaymentListAdapter paymentListAdapter;
    private ExpandableListView expandableListView;
    private List<PaymentDto> paymentInfo;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        paymentViewModel =
                new ViewModelProvider(this).get(PaymentViewModel.class);

        binding = FragmentPaymentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        progressBar = binding.resultProgressBar;
        layoutManager = new LinearLayoutManager(getActivity());

        expandableListView = binding.expandableListView;
        paymentViewModel.getPaymentInfo();
        paymentViewModel.getPaymentInfoResult().observe(getViewLifecycleOwner(), paymentInfo -> {
            this.paymentInfo = paymentInfo.getPaymentDtoList();
            paymentListAdapter = new PaymentListAdapter(getContext(), this.paymentInfo);
            expandableListView.setAdapter(paymentListAdapter);
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