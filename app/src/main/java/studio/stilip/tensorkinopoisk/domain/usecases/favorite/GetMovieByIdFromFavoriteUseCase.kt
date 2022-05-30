package studio.stilip.tensorkinopoisk.domain.usecases.favorite

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class GetMovieByIdFromFavoriteUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(id: String): Single<MovieInfo> {
        return repository.getMovieByIdFromDB(id)
    }
}