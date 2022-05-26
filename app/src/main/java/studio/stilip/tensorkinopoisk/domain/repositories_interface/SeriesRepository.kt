package studio.stilip.tensorkinopoisk.domain.repositories_interface

import io.reactivex.Single
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.entities.films.FilmInfo

interface SeriesRepository {
    fun getSeriesInfo(): Single<List<Film>>
}