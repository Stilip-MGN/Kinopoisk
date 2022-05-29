package studio.stilip.tensorkinopoisk.data.dao

import androidx.room.*
import io.reactivex.Single
import studio.stilip.tensorkinopoisk.data.entities.FavoriteMovie
import studio.stilip.tensorkinopoisk.data.entities.FavoriteMovie.Companion.TABLE_NAME

@Dao
interface FavoriteMovieListDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllMovies(): Single<List<FavoriteMovie>>

    @Delete(entity = FavoriteMovie::class)
    fun deleteMovie(favoriteMovie: FavoriteMovie)

    @Insert(entity = FavoriteMovie::class, onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(favoriteMovie: FavoriteMovie)
}