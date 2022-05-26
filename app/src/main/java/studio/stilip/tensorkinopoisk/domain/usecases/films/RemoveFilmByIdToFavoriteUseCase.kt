package studio.stilip.tensorkinopoisk.domain.usecases.films

import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class RemoveFilmByIdToFavoriteUseCase @Inject constructor(private val filmRepository: MovieRepository) {
    operator fun invoke(id: String): Boolean {
        return filmRepository.removeFilmByIdToFavorite(id)
    }
}
