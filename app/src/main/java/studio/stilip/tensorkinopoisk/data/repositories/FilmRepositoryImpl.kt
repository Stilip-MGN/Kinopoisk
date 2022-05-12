package studio.stilip.tensorkinopoisk.data.repositories

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.data.api.RetrofitServiceFilm
import studio.stilip.tensorkinopoisk.data.dto.toDomain
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.entities.films.FilmInfo
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(private val retrofitService: RetrofitServiceFilm) :
    FilmRepository {

    override fun getFilmsInfo(): Single<List<Film>> {

        return retrofitService.getFilms()
            .map { list ->
                list.docs.map { m -> m.toDomain() }
            }
    }

    override fun getFilmInfoById(id: String): Single<FilmInfo> {
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