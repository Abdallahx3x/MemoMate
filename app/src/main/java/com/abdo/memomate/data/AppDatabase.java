package com.abdo.memomate.data;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = { NoteDto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}