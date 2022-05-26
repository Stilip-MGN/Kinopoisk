package studio.stilip.tensorkinopoisk.domain.usecases.series

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import javax.inject.Inject

class GetSeriesInfoUseCase @Inject constructor(private val seriesRepository: FilmRepository) {
    operator fun invoke(): Single<List<Film>> {
        return seriesRepository.getSeriesInfo()
    }
}