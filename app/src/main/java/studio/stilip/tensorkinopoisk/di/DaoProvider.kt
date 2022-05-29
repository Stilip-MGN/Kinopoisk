package studio.stilip.tensorkinopoisk.di

import android.content.Context
import androidx.room.Room
import studio.stilip.tensorkinopoisk.BuildConfig
import studio.stilip.tensorkinopoisk.data.database.FavoriteMovieDatabase
import javax.inject.Inject

class DaoProvider @Inject constructor(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        FavoriteMovieDatabase::class.java,
        BuildConfig.DB_NAME
    ).build()

    val favoriteMovieListDao
        get() = db.favoriteMovieListDao()
}