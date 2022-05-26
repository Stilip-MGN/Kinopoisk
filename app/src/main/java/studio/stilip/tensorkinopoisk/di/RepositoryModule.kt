package studio.stilip.tensorkinopoisk.di

import dagger.Binds
import dagger.Module
import studio.stilip.tensorkinopoisk.data.repositories.MovieRepositoryImpl
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideFilmRepository(RepositoryImpl: MovieRepositoryImpl):
            MovieRepository
}