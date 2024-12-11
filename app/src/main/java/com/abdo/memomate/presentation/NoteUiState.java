package com.abdo.memomate.presentation;

import java.util.List;

public class NoteUiState {
    String title, description;
    List<NoteItemUiState> noteList;

    // constructor to initialize
    // the variables
    public NoteUiState(String title, String description, List<NoteItemUiState> noteList) {
        this.title = title;
        this.description = description;
        this.noteList = noteList;
    }

    // getter and setter methods
    // for email variable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // getter and setter methods
    // for password variable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<NoteItemUiState> getNoteList() {
        return noteList;
    }

    public void setList(List<NoteItemUiState> list) {
        this.noteList = list;
    }
}

