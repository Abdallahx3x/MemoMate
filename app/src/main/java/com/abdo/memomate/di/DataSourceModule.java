package com.abdo.memomate.di;

import com.abdo.memomate.data.local.NoteLocalDataSourceImpl;
import com.abdo.memomate.data.repository.NoteLocalDataSource;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class DataSourceModule {
    @Binds
    @Singleton
    public abstract NoteLocalDataSource bindNoteLocalDataSource(NoteLocalDataSourceImpl impl);
}
