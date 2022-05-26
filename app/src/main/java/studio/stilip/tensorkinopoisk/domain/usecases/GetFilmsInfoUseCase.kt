package studio.stilip.tensorkinopoisk.domain.usecases

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class GetFilmsInfoUseCase @Inject constructor(private val filmRepository: MovieRepository) {
    operator fun invoke(): Single<List<Film>> {
        return filmRepository.getFilmsInfo()
    }
}