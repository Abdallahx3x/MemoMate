package com.abdo.memomate.presentation.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.fragment.NavHostFragment;
import com.abdo.memomate.R;
import com.abdo.memomate.databinding.FragmentDetailsBinding;
import com.abdo.memomate.presentation.base.BaseFragment;
import com.abdo.memomate.presentation.shared.NoteUiEffect;

public class DetailsFragment extends BaseFragment {
    private FragmentDetailsBinding fragmentDetailsBinding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        fragmentDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
        return fragmentDetailsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupBinding(fragmentDetailsBinding);
    }

    private void setupBinding(FragmentDetailsBinding binding) {
        binding.setViewModel(noteViewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.saveButton.setOnClickListener(v -> noteInteractionListener.onClickSaveButton());
        binding.toolbar.setNavigationOnClickListener(v -> noteInteractionListener.onClickBackButton());
        binding.toolbar.getMenu().findItem(R.id.action_delete).setOnMenuItemClickListener(item -> {
            noteInteractionListener.onClickDeleteButton();
            return true;
        });
    }

    @Override
    protected void onEffect(NoteUiEffect effect) {
        if (effect instanceof NoteUiEffect.NavigateBack) {
            NavHostFragment.findNavController(this).popBackStack();
        }
    }
}

