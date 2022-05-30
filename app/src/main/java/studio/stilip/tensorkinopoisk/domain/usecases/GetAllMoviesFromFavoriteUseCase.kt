package studio.stilip.tensorkinopoisk.domain.usecases

import io.reactivex.Completable
import io.reactivex.Single
import studio.stilip.tensorkinopoisk.data.entities.MovieForDB
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class GetAllMoviesFromFavoriteUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Single<List<Film>> {
        return repository.getAllMoviesFromDB()
    }
}