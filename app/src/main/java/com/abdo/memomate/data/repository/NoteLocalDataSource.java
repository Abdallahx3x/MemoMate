package com.abdo.memomate.data.repository;

import com.abdo.memomate.data.local.NoteDto;

import java.util.List;

public interface NoteLocalDataSource {
    List<NoteDto> getAllNotes();

    void addOrUpdateNote(NoteDto note);

    void deleteNote(int id);

    NoteDto getNoteById(int id);
}
