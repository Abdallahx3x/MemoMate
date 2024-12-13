package com.abdo.memomate.presentation.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.fragment.NavHostFragment;

import com.abdo.memomate.R;
import com.abdo.memomate.databinding.FragmentNoteListBinding;
import com.abdo.memomate.presentation.base.BaseFragment;
import com.abdo.memomate.presentation.shared.NoteUiEffect;


public class HomeFragment extends BaseFragment {
    private FragmentNoteListBinding fragmentNoteListBinding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        fragmentNoteListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_note_list, container, false);
        return fragmentNoteListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupList(fragmentNoteListBinding);
        setupFabListener(fragmentNoteListBinding);
    }

    private void setupList(FragmentNoteListBinding binding) {
        noteViewModel.state.observe(getViewLifecycleOwner(), noteUiState -> {
            if (noteUiState != null) {
                binding.setNote(noteUiState);
                binding.list.setAdapter(new NoteListAdapter(noteUiState.getNoteList(), noteInteractionListener));
            }
        });
        binding.setLifecycleOwner(getViewLifecycleOwner());
    }

    private void setupFabListener(FragmentNoteListBinding binding) {
        binding.fab.setOnClickListener(v -> noteInteractionListener.onClickAddNote());
    }

    @Override
    protected void onEffect(NoteUiEffect effect) {
        if (effect instanceof NoteUiEffect.NavigateToDetails) {
            NavHostFragment.findNavController(this).navigate(R.id.action_noteFragment_to_detailsFragment);
        }
    }
}

