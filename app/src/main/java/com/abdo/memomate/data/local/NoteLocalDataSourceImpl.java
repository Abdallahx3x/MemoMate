package com.abdo.memomate.data.local;

import android.content.Context;

import androidx.room.Room;

import com.abdo.memomate.data.repository.NoteLocalDataSource;

import java.util.List;

public class NoteLocalDataSourceImpl implements NoteLocalDataSource {
    private final NoteDao noteDao;

    public NoteLocalDataSourceImpl(Context context) {
        AppDatabase db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database-name").build();
        this.noteDao = db.noteDao();
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return noteDao.getAllNotes();
    }

    @Override
    public void addOrUpdateNote(NoteDto note) {
        noteDao.insertOrUpdateNote(note);
    }

    @Override
    public void deleteNote(int id) {
        noteDao.deleteNoteById(id);
    }

    @Override
    public NoteDto getNoteById(int id) {
        return noteDao.getNoteById(id);
    }
}
