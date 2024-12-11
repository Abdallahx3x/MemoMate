package com.abdo.memomate.presentation;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.abdo.memomate.data.NoteRepository;
import com.abdo.memomate.repository.NoteMapper;

import java.util.List;
import java.util.concurrent.Executors;


public class NoteViewModel extends ViewModel {


    private final MutableLiveData<NoteUiState> _state = new MutableLiveData<>();
    public LiveData<NoteUiState> state = _state;//don't forget to make it final and search of its right to do


    private final NoteRepository noteRepository;

    public NoteViewModel(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
        getDate();
    }

    public void getDate() {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<NoteItemUiState> getlist = NoteMapper.toNoteItemsUiState(noteRepository.getNotes());

            NoteUiState noteUiState = new NoteUiState("title", "description", getlist);
            _state.postValue(noteUiState);
        });

    }

    public void addNote() {
        Executors.newSingleThreadExecutor().execute(() -> {

            NoteItemUiState noteItemUiState = new NoteItemUiState("5", "title5", "description5");
            noteRepository.addNote(NoteMapper.toNoteFromUiState(noteItemUiState));
            // update the UI state with the new list
            List<NoteItemUiState> updatedList = NoteMapper.toNoteItemsUiState(noteRepository.getNotes());
            NoteUiState updatedUiState = new NoteUiState("title", "description", updatedList);
            _state.postValue(updatedUiState);
        });
    }


}
