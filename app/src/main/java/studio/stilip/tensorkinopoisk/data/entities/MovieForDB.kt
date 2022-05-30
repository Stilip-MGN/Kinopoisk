package studio.stilip.tensorkinopoisk.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import studio.stilip.tensorkinopoisk.domain.entities.Actor

@Entity(tableName = MovieForDB.TABLE_NAME)
data class MovieForDB(

    @PrimaryKey @ColumnInfo(name = "movie_id")
    val id: String,

    @ColumnInfo(name = "movie_name")
    val name: String,

    @ColumnInfo(name = "movie_description")
    val description: String,

    @ColumnInfo(name = "movie_year")
    val year: Int,

    @ColumnInfo(name = "movie_poster")
    val poster: String,

    @ColumnInfo(name = "movie_rating")
    val rating: Double,

    @ColumnInfo(name = "movie_genre")
    val genre: List<String>,

    @ColumnInfo(name = "movie_persons")
    val persons: List<Actor>,

    ) {
    companion object {
        const val TABLE_NAME = "favorite_movie"
    }
}