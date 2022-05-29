package studio.stilip.tensorkinopoisk.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import studio.stilip.tensorkinopoisk.data.dao.FavoriteMovieListDao
import studio.stilip.tensorkinopoisk.data.entities.FavoriteMovie

@Database(
    entities = [
        FavoriteMovie::class,
    ],
    version = 1
)
abstract class FavoriteMovieDatabase : RoomDatabase() {
    abstract fun favoriteMovieListDao(): FavoriteMovieListDao
}