package com.glassera.stracker.activity.dashboard.ui.liability;

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
import com.glassera.stracker.activity.dashboard.ui.liability.LiabilityViewModel;
import com.glassera.stracker.databinding.FragmentLiabilityBinding;

public class LiabilityFragment extends Fragment {

    private LiabilityViewModel liabilityViewModel;
    private FragmentLiabilityBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        liabilityViewModel =
                new ViewModelProvider(this).get(LiabilityViewModel.class);

        binding = FragmentLiabilityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLiability;
        liabilityViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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