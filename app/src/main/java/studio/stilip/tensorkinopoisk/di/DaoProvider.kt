package studio.stilip.tensorkinopoisk.di

import android.content.Context
import androidx.room.Room
import studio.stilip.tensorkinopoisk.BuildConfig
import studio.stilip.tensorkinopoisk.data.database.FavoriteMovieDatabase
import studio.stilip.tensorkinopoisk.data.database.MovieDatabase
import javax.inject.Inject

class DaoProvider @Inject constructor(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        FavoriteMovieDatabase::class.java,
        BuildConfig.DB_NAME
    ).build()

    val favoriteMovieListDao
        get() = db.favoriteMovieListDao()

    private val database = Room.databaseBuilder(
        context,
        MovieDatabase::class.java,
        BuildConfig.DB_NAME_MOVIE
    ).build()

    val movieForDBDao
        get() = database.MovieForDBDao()
}