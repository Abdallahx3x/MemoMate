package com.abdo.memomate.data;

import java.util.List;

public interface NoteLocalDataSource {
    public List<NoteDto> getAllNotes();
    public void addOrUpdateNote(NoteDto note);
    public void deleteNote(NoteDto note);
    public void   getNoteById (NoteDto note);
}
