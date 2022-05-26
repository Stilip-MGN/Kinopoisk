package studio.stilip.tensorkinopoisk.domain.usecases.films

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class GetFilmsByNameUseCase @Inject constructor(private val filmRepository: MovieRepository) {
    operator fun invoke(name: String): Single<List<Film>> {
        return filmRepository.getFilmsByName(name)
    }
}