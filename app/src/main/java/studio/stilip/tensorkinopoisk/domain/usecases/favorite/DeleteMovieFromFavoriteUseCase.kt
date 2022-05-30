package studio.stilip.tensorkinopoisk.domain.usecases.favorite

import io.reactivex.Completable
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class DeleteMovieFromFavoriteUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(movie: MovieInfo): Completable {
        return repository.deleteMovieFromDB(movie)
    }
}