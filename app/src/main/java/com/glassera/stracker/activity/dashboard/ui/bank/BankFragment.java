package com.glassera.stracker.activity.dashboard.ui.bank;

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
import com.glassera.stracker.databinding.FragmentBankBinding;

public class BankFragment extends Fragment {

    private BankViewModel bankViewModel;
    private FragmentBankBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bankViewModel =
                new ViewModelProvider(this).get(BankViewModel.class);

        binding = FragmentBankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBank;
        bankViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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