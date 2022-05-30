package studio.stilip.tensorkinopoisk.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import studio.stilip.tensorkinopoisk.data.dao.FavoriteMovieListDao
import studio.stilip.tensorkinopoisk.data.dao.MovieForDBDao
import studio.stilip.tensorkinopoisk.data.entities.FavoriteMovie
import studio.stilip.tensorkinopoisk.data.entities.MovieForDB

@Database(
    entities = [
        MovieForDB::class,
    ],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun MovieForDBDao(): MovieForDBDao
}