package com.abdo.memomate.presentation.shared;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.abdo.memomate.domain.NoteRepository;
import com.abdo.memomate.presentation.NoteMapper;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NoteViewModel extends ViewModel {

    private final MutableLiveData<NoteUiState> _state = new MutableLiveData<>();
    public final LiveData<NoteUiState> state = _state;
    private final Executor executor;
    private final NoteRepository noteRepository;

    @Inject
    public NoteViewModel(NoteRepository noteRepository, Executor executor) {
        this.noteRepository = noteRepository;
        this.executor = executor;
        _state.setValue(new NoteUiState());
        this.executor.execute(this::getOrUpdateDate);
    }

    private void getOrUpdateDate() {
        List<NoteItemUiState> getlist = NoteMapper.toNoteItemsUiState(noteRepository.getNotes());
        NoteUiState noteUiState = new NoteUiState();
        noteUiState.setList(getlist);
        _state.postValue(noteUiState);
    }

    public void addNote() {
        executor.execute(() -> {
            NoteItemUiState noteItemUiState = _state.getValue() != null ? _state.getValue().getNoteDetails() : null;
            if (noteItemUiState != null) {
                noteRepository.addNote(NoteMapper.toNoteFromUiState(noteItemUiState));
                getOrUpdateDate();
            }
        });
    }

    public void updateNote() {
        executor.execute(() -> {
            NoteItemUiState noteItemUiState = _state.getValue() != null ? _state.getValue().getNoteDetails() : null;
            if (noteItemUiState == null) return;
            noteRepository.updateNote(NoteMapper.toNoteFromUiState(noteItemUiState));
            getOrUpdateDate();

        });
    }

    public void setDetails(NoteItemUiState item) {
        NoteUiState currentState = _state.getValue() != null ? _state.getValue() : new NoteUiState();
        currentState.setNoteDetails(item);
        _state.setValue(state.getValue());
    }

    public void deleteNote() {
        executor.execute(() -> {
            NoteItemUiState noteItemUiState = _state.getValue() != null ? _state.getValue().getNoteDetails() : null;
            if (noteItemUiState == null) return;
            noteRepository.deleteNote(noteItemUiState.id);
            getOrUpdateDate();
        });
    }

    public void initDetails() {
        NoteUiState noteUiState = _state.getValue() != null ? _state.getValue() : null;
        if (noteUiState == null) return;
        noteUiState.setNoteDetails(new NoteItemUiState(0, "", ""));
        _state.setValue(noteUiState);
    }
}
