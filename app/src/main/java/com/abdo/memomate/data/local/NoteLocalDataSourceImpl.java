package com.abdo.memomate.data.local;

import com.abdo.memomate.data.repository.NoteLocalDataSource;
import java.util.List;
import javax.inject.Inject;

public class NoteLocalDataSourceImpl implements NoteLocalDataSource {
    private final NoteDao noteDao;

    @Inject
    public NoteLocalDataSourceImpl(NoteDao noteDao) {
        this.noteDao = noteDao;
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
