package studio.stilip.tensorkinopoisk.data.repositories

import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor() : FilmRepository {

    private val films: List<Film> = listOf(
        Film("1", "Мама", "https//", "ужас"),
        Film("2", "Папа", "https//", "комедия"),
    )

    override fun getFilmsInfo(): List<Film> {
        return films
        TODO("Not yet implemented")
    }

    override fun getFilmInfoById(id: String): Film {
        return films.first { film -> film.id == id }
        TODO("Not yet implemented")
    }

    override fun addFilmByIdToFavorite(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeFilmByIdToFavorite(id: String): Boolean {
        TODO("Not yet implemented")
    }
}