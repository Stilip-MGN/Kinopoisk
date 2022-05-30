package studio.stilip.tensorkinopoisk.di

import dagger.Module
import dagger.Provides
import studio.stilip.tensorkinopoisk.data.dao.MovieForDBDao
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideMovieForDBDao(daoProvider: DaoProvider): MovieForDBDao {
        return daoProvider.movieForDBDao
    }
}