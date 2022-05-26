package studio.stilip.tensorkinopoisk.di

import dagger.Binds
import dagger.Module
import studio.stilip.tensorkinopoisk.data.repositories.FilmRepositoryImpl
import studio.stilip.tensorkinopoisk.data.repositories.SeriesRepositoryImpl
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import studio.stilip.tensorkinopoisk.domain.repositories_interface.SeriesRepository

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideFilmRepository(RepositoryImpl: FilmRepositoryImpl):
            FilmRepository

    @Binds
    abstract fun provideSeriesRepository(RepositoryImpl: SeriesRepositoryImpl):
            SeriesRepository
}