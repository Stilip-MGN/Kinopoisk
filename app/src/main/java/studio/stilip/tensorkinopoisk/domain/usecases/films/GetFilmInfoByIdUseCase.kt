package studio.stilip.tensorkinopoisk.domain.usecases.films

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.FilmInfo
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class GetFilmInfoByIdUseCase @Inject constructor(private val filmRepository: MovieRepository) {
    operator fun invoke(id: String): Single<FilmInfo> {
        return filmRepository.getFilmInfoById(id)
    }
}