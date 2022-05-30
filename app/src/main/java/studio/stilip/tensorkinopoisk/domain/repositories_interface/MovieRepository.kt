package studio.stilip.tensorkinopoisk.domain.repositories_interface

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo

interface MovieRepository {
    fun getFilmsInfo(): Single<List<Film>>

    fun getFilmsByName(name: String): Single<List<Film>>

    fun getFilmInfoById(id: String): Single<MovieInfo>

    fun addFilmByIdToFavorite(id: String): Boolean

    fun removeFilmByIdToFavorite(id: String): Boolean

    fun getSeriesInfo(): Single<List<Film>>

    fun getSeriesByName(name: String): Single<List<Film>>

    fun setMovieToDB(movie: MovieInfo)
}