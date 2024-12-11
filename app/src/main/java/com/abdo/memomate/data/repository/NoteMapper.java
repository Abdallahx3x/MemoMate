package com.abdo.memomate.data.repository;

import android.annotation.SuppressLint;

import com.abdo.memomate.data.local.NoteDto;
import com.abdo.memomate.domain.Note;

import java.util.List;
import java.util.stream.Collectors;

public class NoteMapper {
    public static Note toNoteFromDto(NoteDto noteDto) {
        Note note = new Note();
        note.id = noteDto.id;
        note.title = noteDto.title;
        note.content = noteDto.content;
        return note;
    }

    @SuppressLint("NewApi")
    public static List<Note> toNoteListFromDto(List<NoteDto> noteDtoList) {
        return noteDtoList.stream()
                .map(NoteMapper::toNoteFromDto)
                .collect(Collectors.toList());
    }

    public static NoteDto toNoteDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.id = note.id;
        noteDto.title = note.title;
        noteDto.content = note.content;
        return noteDto;
    }
}
