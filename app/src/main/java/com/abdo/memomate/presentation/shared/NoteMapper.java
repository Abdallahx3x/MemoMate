package com.abdo.memomate.presentation.shared;

import android.annotation.SuppressLint;

import com.abdo.memomate.domain.Note;
import java.util.List;
import java.util.stream.Collectors;

public class NoteMapper {
    public static NoteItemUiState toNoteItemUiState(Note note) {
        return new NoteItemUiState(
                note.id,
                note.title,
                note.content
        );
    }

    @SuppressLint("NewApi")
    public static List<NoteItemUiState> toNoteItemsUiState(List<Note> notes) {
        return notes.stream()
                .map(NoteMapper::toNoteItemUiState)
                .collect(Collectors.toList());
    }

    public static Note toNoteFromUiState(NoteItemUiState noteItemUiState) {
        Note note = new Note();
        note.id = noteItemUiState.id;
        note.title = noteItemUiState.title;
        note.content = noteItemUiState.details;
        return note;
    }
}
