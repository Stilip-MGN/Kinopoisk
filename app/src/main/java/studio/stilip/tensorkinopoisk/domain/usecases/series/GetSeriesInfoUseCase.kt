package studio.stilip.tensorkinopoisk.domain.usecases.series

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import studio.stilip.tensorkinopoisk.domain.repositories_interface.SeriesRepository
import javax.inject.Inject

class GetSeriesInfoUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    operator fun invoke(): Single<List<Film>> {
        return seriesRepository.getSeriesInfo()
    }
}