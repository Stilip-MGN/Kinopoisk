package studio.stilip.tensorkinopoisk.data.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import studio.stilip.tensorkinopoisk.data.entities.MovieForDB

@Dao
interface MovieForDBDao {

    @Query("SELECT * FROM ${MovieForDB.TABLE_NAME}")
    fun getAllMovies(): Single<List<MovieForDB>>

    @Query("SELECT * FROM ${MovieForDB.TABLE_NAME} WHERE movie_id = :id")
    fun getMovieById(id: String): Single<MovieForDB>

    @Delete
    fun deleteMovie(movie: MovieForDB): Completable

    @Insert
    fun insertMovie(movie: MovieForDB): Completable

    @Update
    fun updateMovie(movie: MovieForDB): Completable
}