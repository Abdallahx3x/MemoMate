package com.abdo.memomate.presentation.shared;

import java.util.List;

public class NoteUiState {
    private List<NoteItemUiState> noteList;
    private NoteItemUiState noteDetails;

    public NoteUiState() {
        this.noteList = List.of();
        this.noteDetails = new NoteItemUiState(-1, "", "");
    }

    public List<NoteItemUiState> getNoteList() {
        return noteList;
    }

    public void setList(List<NoteItemUiState> list) {
        this.noteList = list;
    }

    public NoteItemUiState getNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(NoteItemUiState noteDetails) {
        this.noteDetails = noteDetails;
    }
}

