package studio.stilip.tensorkinopoisk.domain.usecases

import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import javax.inject.Inject

class RemoveFilmByIdToFavoriteUseCase @Inject constructor(private val filmRepository: FilmRepository) {
    operator fun invoke(id: String): Boolean {
        return filmRepository.removeFilmByIdToFavorite(id)
    }
}
