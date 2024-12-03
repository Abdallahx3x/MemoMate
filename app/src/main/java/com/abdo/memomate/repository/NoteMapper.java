package com.abdo.memomate.repository;

import android.annotation.SuppressLint;

import com.abdo.memomate.data.NoteDto;
import com.abdo.memomate.presentation.NoteItemUiState;

import java.util.List;
import java.util.stream.Collectors;

public class NoteMapper {

    // Convert NoteDto to Note
    public static Note toNoteFromDto(NoteDto noteDto) {
        Note note = new Note();
        note.id = noteDto.id;
        note.title = noteDto.title;
        note.content = noteDto.content;
        return note;
    }

    // Convert Note to NoteDto
    public static NoteDto toNoteDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.title = note.title;
        noteDto.content = note.content;
        return noteDto;
    }

    // Convert List<NoteDto> to List<Note>
    @SuppressLint("NewApi")
    public static List<Note> toNoteListFromDto(List<NoteDto> noteDtoList) {
        return noteDtoList.stream()
                .map(NoteMapper::toNoteFromDto)
                .collect(Collectors.toList());
    }

    // Convert List<Note> to List<NoteDto>
    @SuppressLint("NewApi")
    public static List<NoteDto> toNoteDtoList(List<Note> noteList) {
        return noteList.stream()
                .map(NoteMapper::toNoteDto)
                .collect(Collectors.toList());
    }

    public static NoteItemUiState NoteItemUiState(Note note) {
        return new NoteItemUiState(
                String.valueOf(note.id),
                note.title,
                note.content
        );
    }

    @SuppressLint("NewApi")
    public static List<NoteItemUiState> toNoteItemsUiState(List<Note> notes) {
        return notes.stream()
                .map(NoteMapper::NoteItemUiState)
                .collect(Collectors.toList());
    }

    public static Note toNoteFromUiState(NoteItemUiState noteList) {
        Note note = new Note();
        note.id = Integer.parseInt(noteList.id);
        note.title = noteList.title;
        note.content = noteList.details;
        return note;
    }

    @SuppressLint("NewApi")
    public static List<Note> toNoteListFromUiState(List<NoteItemUiState> notes) {
        return notes.stream()
                .map(NoteMapper::toNoteFromUiState)
                .collect(Collectors.toList());
    }
}
