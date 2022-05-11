package studio.stilip.tensorkinopoisk.domain.usecases

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import javax.inject.Inject

class GetFilmInfoByIdUseCase @Inject constructor(private val filmRepository: FilmRepository) {
    operator fun invoke(id: String): Single<Film> {
        return filmRepository.getFilmInfoById(id)
    }
}