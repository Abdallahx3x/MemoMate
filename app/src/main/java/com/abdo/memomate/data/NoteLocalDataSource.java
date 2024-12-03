package com.abdo.memomate.data;

import java.util.List;

public interface NoteLocalDataSource {
    public List<NoteDto> getAllNotes();
    public void addOrUpdateNote(NoteDto note);
    public void deleteNote(int id);
    public NoteDto getNoteById (int id);
}
