package studio.stilip.tensorkinopoisk.domain.usecases.films

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class GetFilmInfoByIdUseCase @Inject constructor(private val filmRepository: MovieRepository) {
    operator fun invoke(id: String): Single<MovieInfo> {
        return filmRepository.getFilmInfoById(id)
    }
}