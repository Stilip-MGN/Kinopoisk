package studio.stilip.tensorkinopoisk.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import studio.stilip.tensorkinopoisk.base.BasePresenter
import studio.stilip.tensorkinopoisk.domain.usecases.GetFilmInfoByIdUseCase
import studio.stilip.tensorkinopoisk.domain.usecases.GetFilmsByNameUseCase
import studio.stilip.tensorkinopoisk.domain.usecases.GetFilmsInfoUseCase
import studio.stilip.tensorkinopoisk.domain.usecases.series.GetSeriesInfoUseCase
import studio.stilip.tensorkinopoisk.views.FilmView
import studio.stilip.tensorkinopoisk.views.SeriesView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class SeriesPresenter @Inject constructor(
    private val getSeriesInfo: GetSeriesInfoUseCase,
) : BasePresenter<SeriesView>() {

    override fun onFirstViewAttach() {
        getFilms()
    }

    fun getFilms() {
        getSeriesInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                viewState.showSeries(list)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }

}