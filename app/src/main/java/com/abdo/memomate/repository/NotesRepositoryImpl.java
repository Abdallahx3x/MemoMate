package com.abdo.memomate.repository;

import android.annotation.SuppressLint;
import android.content.Context;

import com.abdo.memomate.data.NoteDto;
import com.abdo.memomate.data.NoteLocalDataSource;
import com.abdo.memomate.data.NoteLocalDataSourceImpl;
import com.abdo.memomate.data.NoteRepository;

import java.util.List;

public class NotesRepositoryImpl implements NoteRepository {
    private final NoteLocalDataSource noteLocalDataSource;

    public NotesRepositoryImpl(Context context) {
        this.noteLocalDataSource = new NoteLocalDataSourceImpl(context);
    }

    @SuppressLint("NewApi")
    @Override
    public List<Note> getNotes() {
        List<NoteDto> noteDtoList = noteLocalDataSource.getAllNotes();
        return NoteMapper.toNoteListFromDto(noteDtoList);

    }

    @Override
    public Note getNote(int id) {
        NoteDto noteDto = noteLocalDataSource.getNoteById(id);
        return NoteMapper.toNoteFromDto(noteDto);
    }

    @Override
    public void addNote(Note note) {
        addOrUpdateNote(note);
    }

    @Override
    public void updateNote(Note note) {
        addOrUpdateNote(note);
    }

    private void addOrUpdateNote(Note note) {
        NoteDto noteDto = NoteMapper.toNoteDto(note);
        noteLocalDataSource.addOrUpdateNote(noteDto);
    }

    @Override
    public void deleteNote(int id) {
        noteLocalDataSource.deleteNote(id);
    }
}
