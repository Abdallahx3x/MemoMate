package com.abdo.memomate.presentation.base;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.abdo.memomate.presentation.shared.NoteInteractionListener;
import com.abdo.memomate.presentation.shared.NoteUiEffect;
import com.abdo.memomate.presentation.shared.NoteViewModel;

import org.jetbrains.annotations.Nullable;

abstract public class BaseFragment extends Fragment {
    protected NoteViewModel noteViewModel;
    protected NoteInteractionListener noteInteractionListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteViewModel = new ViewModelProvider(requireActivity()).get(NoteViewModel.class);
        noteInteractionListener = noteViewModel;
        noteViewModel.effect.observe(this, this::onEffect);
    }

    protected abstract void onEffect(NoteUiEffect effect);
}
