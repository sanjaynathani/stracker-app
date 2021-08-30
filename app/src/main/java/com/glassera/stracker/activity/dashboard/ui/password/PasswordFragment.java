package com.glassera.stracker.activity.dashboard.ui.password;

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
import com.glassera.stracker.activity.dashboard.ui.password.PasswordViewModel;
import com.glassera.stracker.databinding.FragmentPasswordBinding;

public class PasswordFragment extends Fragment {

    private PasswordViewModel passwordViewModel;
    private FragmentPasswordBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        passwordViewModel =
                new ViewModelProvider(this).get(PasswordViewModel.class);

        binding = FragmentPasswordBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPassword;
        passwordViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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