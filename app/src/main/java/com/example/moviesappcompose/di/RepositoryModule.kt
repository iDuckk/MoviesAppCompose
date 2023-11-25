package com.example.moviesappcompose.di

import android.content.Context
import com.example.moviesappcompose.data.repository.MovieRepositoryImpl
import com.example.moviesappcompose.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class  RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        repositoryImpl: MovieRepositoryImpl,
        @ApplicationContext context: Context
    ): MovieRepository {
        return repositoryImpl
    }
}