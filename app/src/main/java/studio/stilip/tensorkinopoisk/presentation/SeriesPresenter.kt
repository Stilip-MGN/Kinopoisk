package studio.stilip.tensorkinopoisk.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import studio.stilip.tensorkinopoisk.base.BasePresenter
import studio.stilip.tensorkinopoisk.domain.usecases.series.GetSeriesByNameUseCase
import studio.stilip.tensorkinopoisk.domain.usecases.series.GetSeriesInfoUseCase
import studio.stilip.tensorkinopoisk.views.SeriesView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class SeriesPresenter @Inject constructor(
    private val getSeriesInfo: GetSeriesInfoUseCase,
    private val getSeriesByNameInfo: GetSeriesByNameUseCase
) : BasePresenter<SeriesView>() {

    override fun onFirstViewAttach() {
        getSeries()
    }

    fun getSeries() {
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

    fun getSeriesByName(name: String) {
        getSeriesByNameInfo(name)
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