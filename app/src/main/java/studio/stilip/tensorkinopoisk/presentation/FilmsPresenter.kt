package studio.stilip.tensorkinopoisk.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import studio.stilip.tensorkinopoisk.base.BasePresenter
import studio.stilip.tensorkinopoisk.domain.usecases.films.GetFilmsByNameUseCase
import studio.stilip.tensorkinopoisk.domain.usecases.films.GetFilmsInfoUseCase
import studio.stilip.tensorkinopoisk.views.FilmView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FilmsPresenter @Inject constructor(
    private val getFilmsInfo: GetFilmsInfoUseCase,
    private val getFilmsByNameInfo: GetFilmsByNameUseCase
) : BasePresenter<FilmView>() {

    override fun onFirstViewAttach() {
        getFilms()
    }

    fun getFilmsByName(name: String) {
        getFilmsByNameInfo(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                viewState.showFilms(list)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }

    fun getFilms() {
        getFilmsInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                viewState.showFilms(list)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }

}