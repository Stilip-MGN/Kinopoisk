package studio.stilip.tensorkinopoisk.views

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import studio.stilip.tensorkinopoisk.base.BaseView
import studio.stilip.tensorkinopoisk.domain.entities.films.FilmInfo

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FilmInfoView : BaseView {
    fun showFilm(film: FilmInfo)
}