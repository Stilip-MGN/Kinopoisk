package studio.stilip.tensorkinopoisk.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import studio.stilip.tensorkinopoisk.data.converter.DataConverter
import studio.stilip.tensorkinopoisk.data.dao.FavoriteMovieListDao
import studio.stilip.tensorkinopoisk.data.dao.MovieForDBDao
import studio.stilip.tensorkinopoisk.data.entities.FavoriteMovie
import studio.stilip.tensorkinopoisk.data.entities.MovieForDB

@Database(
    entities = [
        MovieForDB::class,
    ],
    version = 2
)
@TypeConverters(value = [DataConverter::class])
abstract class MovieDatabase : RoomDatabase() {
    abstract fun MovieForDBDao(): MovieForDBDao
}