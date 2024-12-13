package com.abdo.memomate.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM NoteDto")
    List<NoteDto> getAllNotes();

    @Query("SELECT * FROM NoteDto WHERE id = :id")
    NoteDto getNoteById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdateNote(NoteDto note);

    @Query("DELETE FROM NoteDto WHERE id = :id")
    void deleteNoteById(int id);
}
