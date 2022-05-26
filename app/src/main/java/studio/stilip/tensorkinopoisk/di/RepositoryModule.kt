package studio.stilip.tensorkinopoisk.di

import dagger.Binds
import dagger.Module
import studio.stilip.tensorkinopoisk.data.repositories.FilmRepositoryImpl
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideFilmRepository(RepositoryImpl: FilmRepositoryImpl):
            FilmRepository
}