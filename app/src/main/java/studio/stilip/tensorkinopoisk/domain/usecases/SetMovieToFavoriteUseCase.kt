package studio.stilip.tensorkinopoisk.domain.usecases

import io.reactivex.Completable
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class SetMovieToFavoriteUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(movie: MovieInfo): Completable {
        return repository.setMovieToDB(movie)
    }
}