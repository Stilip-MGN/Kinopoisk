package studio.stilip.tensorkinopoisk.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import studio.stilip.tensorkinopoisk.base.BasePresenter
import studio.stilip.tensorkinopoisk.domain.usecases.GetFilmInfoByIdUseCase
import studio.stilip.tensorkinopoisk.views.FilmView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FilmsPresenter @Inject constructor(
    private val getMovieById: GetFilmInfoByIdUseCase
) : BasePresenter<FilmView>() {

    fun getFilm() {
        getMovieById("1")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ film ->
                viewState.showFilm(film)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }

}