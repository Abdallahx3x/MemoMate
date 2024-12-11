package com.abdo.memomate.di;

import android.content.Context;

import androidx.room.Room;

import com.abdo.memomate.data.local.AppDatabase;
import com.abdo.memomate.data.local.NoteDao;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataBaseModule {
    @Provides
    public AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                "MemoMate-database"
        ).build();
    }

    @Provides
    public NoteDao provideNoteDao(AppDatabase appDatabase) {
        return appDatabase.noteDao();
    }
}
