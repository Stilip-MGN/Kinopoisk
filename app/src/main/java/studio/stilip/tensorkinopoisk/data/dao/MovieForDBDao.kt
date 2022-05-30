package studio.stilip.tensorkinopoisk.data.dao

import androidx.room.*
import io.reactivex.Single
import studio.stilip.tensorkinopoisk.data.entities.MovieForDB

@Dao
interface MovieForDBDao {

    @Query("SELECT * FROM ${MovieForDB.TABLE_NAME}")
    fun getAllMovies(): Single<List<MovieForDB>>

    @Query("SELECT * FROM ${MovieForDB.TABLE_NAME} WHERE movie_id = :id")
    fun getMovieById(id: String): Single<MovieForDB>

    @Delete
    fun deleteMovie(movie: MovieForDB)

    @Insert
    fun insertMovie(movie: MovieForDB)

    @Update
    fun updateMovie(movie: MovieForDB)
}