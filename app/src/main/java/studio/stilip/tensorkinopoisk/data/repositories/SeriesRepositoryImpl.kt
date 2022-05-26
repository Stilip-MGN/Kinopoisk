package studio.stilip.tensorkinopoisk.data.repositories

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.data.api.RetrofitServiceFilm
import studio.stilip.tensorkinopoisk.data.api.series.RetrofitServiceSeries
import studio.stilip.tensorkinopoisk.data.dto.toDomain
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.entities.films.FilmInfo
import studio.stilip.tensorkinopoisk.domain.repositories_interface.FilmRepository
import studio.stilip.tensorkinopoisk.domain.repositories_interface.SeriesRepository
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(private val retrofitService: RetrofitServiceSeries) :
    SeriesRepository {

    override fun getSeriesInfo(): Single<List<Film>> {
        return retrofitService.getSeries()
            .map { list ->
                list.docs.map { m -> m.toDomain() }
            }
    }

}