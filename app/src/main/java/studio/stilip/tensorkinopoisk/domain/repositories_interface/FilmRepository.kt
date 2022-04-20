package studio.stilip.tensorkinopoisk.domain.repositories_interface

import studio.stilip.tensorkinopoisk.domain.entities.films.Film

interface FilmRepository {
    fun getFilmsInfo(): List<Film>

    fun getFilmInfoById(id:String): Film

    fun addFilmByIdToFavorite(id:String): Boolean

    fun removeFilmByIdToFavorite(id:String): Boolean
}