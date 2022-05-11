package studio.stilip.tensorkinopoisk.data.repositories

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.data.api.RetrofitServiceFilm
import studio.stilip.tensorkinopoisk.data.dto.toDomain
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(private val retrofitService: RetrofitServiceFilm) :
    FilmRepository {

    private val films: List<Film> = listOf(
        Film("1", "Мама", "https//", "ужас"),
        Film("2", "Папа", "https//", "комедия"),
    )

    override fun getFilmsInfo(): Single<List<Film>> {

        return retrofitService.getFilms()
            .map { list ->
                list.docs.map { m -> m.toDomain() }
            }
    }

    override fun getFilmInfoById(id: String): Single<Film> {
        return retrofitService.getMovie().map { m -> m.toDomain() }
    }

    override fun addFilmByIdToFavorite(id: String): Boolean {
        return true
        TODO("Not yet implemented")
    }

    override fun removeFilmByIdToFavorite(id: String): Boolean {
        return true
        TODO("Not yet implemented")
    }
}