package com.abdo.memomate.data;

import com.abdo.memomate.repository.Note;

import java.util.List;

public interface NoteRepository {
    List<Note> getNotes();

    Note getNote();

    void addNote(Note note);

    void updateNote(Note note);

    void deleteNote(Note note);
}
