package studio.stilip.tensorkinopoisk.domain.usecases

import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class AddFilmByIdToFavoriteUseCase @Inject constructor(private val filmRepository: MovieRepository) {
    operator fun invoke(id: String): Boolean {
        return filmRepository.addFilmByIdToFavorite(id)
    }
}
