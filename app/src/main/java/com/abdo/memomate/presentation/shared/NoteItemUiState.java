package com.abdo.memomate.presentation.shared;

public class NoteItemUiState {
    public final int id;
    public String title;
    public String details;

    public NoteItemUiState(int id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;
    }
}
