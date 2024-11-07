package com.abdo.memomate.data;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class NoteLocalDataSourceImpl implements NoteLocalDataSource {
    private Context context;

    public NoteLocalDataSourceImpl(Context context) {
        this.context = context;
    }

    public final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "database-name").build();
    private final NoteDao noteDao = db.noteDao();

    @Override
    public List<NoteDto> getAllNotes() {
        return noteDao.getAllNotes();
    }

    @Override
    public void addOrUpdateNote(NoteDto note) {
        noteDao.insertOrUpdateNote(note);
    }

    @Override
    public void deleteNote(NoteDto note) {
        noteDao.deleteNoteById(note.id);
    }

    @Override
    public void getNoteById(NoteDto note) {
        noteDao.getNoteById(note.id);
    }
}
