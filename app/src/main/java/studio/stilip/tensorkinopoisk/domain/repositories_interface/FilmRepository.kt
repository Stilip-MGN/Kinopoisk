package studio.stilip.tensorkinopoisk.domain.repositories_interface

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film

interface FilmRepository {
    fun getFilmsInfo(): List<Film>

    fun getFilmInfoById(id:String): Single<Film>

    fun addFilmByIdToFavorite(id:String): Boolean

    fun removeFilmByIdToFavorite(id:String): Boolean
}