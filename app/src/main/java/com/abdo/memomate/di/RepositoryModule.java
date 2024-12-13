package com.abdo.memomate.di;

import com.abdo.memomate.data.repository.NotesRepositoryImpl;
import com.abdo.memomate.domain.NoteRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class RepositoryModule {
    @Binds
    @Singleton
    public abstract NoteRepository bindNoteRepository(NotesRepositoryImpl impl);

}