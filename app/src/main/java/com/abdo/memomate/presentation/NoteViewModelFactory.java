package com.abdo.memomate.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.abdo.memomate.data.NoteRepository;

class NoteViewModelFactory implements ViewModelProvider.Factory {
    private final NoteRepository noteRepository;

    public NoteViewModelFactory(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NoteViewModel.class)) {
            return (T) new NoteViewModel(noteRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
