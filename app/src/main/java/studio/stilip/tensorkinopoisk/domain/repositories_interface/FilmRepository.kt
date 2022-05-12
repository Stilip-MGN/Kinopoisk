package studio.stilip.tensorkinopoisk.domain.repositories_interface

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.entities.films.FilmInfo

interface FilmRepository {
    fun getFilmsInfo(): Single<List<Film>>

    fun getFilmInfoById(id:String): Single<FilmInfo>

    fun addFilmByIdToFavorite(id:String): Boolean

    fun removeFilmByIdToFavorite(id:String): Boolean
}