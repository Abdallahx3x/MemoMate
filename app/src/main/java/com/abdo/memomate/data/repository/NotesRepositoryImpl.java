package com.abdo.memomate.data.repository;

import android.annotation.SuppressLint;

import com.abdo.memomate.data.local.NoteDto;
import com.abdo.memomate.domain.Note;
import com.abdo.memomate.domain.NoteRepository;

import java.util.List;

import javax.inject.Inject;

public class NotesRepositoryImpl implements NoteRepository {
    private final NoteLocalDataSource noteLocalDataSource;

    @Inject
    public NotesRepositoryImpl(NoteLocalDataSource noteLocalDataSource) {
        this.noteLocalDataSource =noteLocalDataSource;
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
