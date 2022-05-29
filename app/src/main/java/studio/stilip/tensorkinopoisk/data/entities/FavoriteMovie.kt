package studio.stilip.tensorkinopoisk.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = FavoriteMovie.TABLE_NAME)
data class FavoriteMovie(

    @PrimaryKey @ColumnInfo(name = "movie_id")
    val id: Int
){
    companion object{
        const val TABLE_NAME = "favorite_film"
    }
}
