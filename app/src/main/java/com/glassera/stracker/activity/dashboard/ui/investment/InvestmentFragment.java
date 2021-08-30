package com.glassera.stracker.activity.dashboard.ui.investment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.glassera.stracker.activity.dashboard.ui.investment.InvestmentViewModel;
import com.glassera.stracker.databinding.FragmentInvestmentBinding;

public class InvestmentFragment extends Fragment {

    private InvestmentViewModel investmentViewModel;
    private FragmentInvestmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        investmentViewModel =
                new ViewModelProvider(this).get(InvestmentViewModel.class);

        binding = FragmentInvestmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textInvestment;
        investmentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}