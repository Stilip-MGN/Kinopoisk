package studio.stilip.tensorkinopoisk.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import studio.stilip.tensorkinopoisk.base.BasePresenter
import studio.stilip.tensorkinopoisk.domain.usecases.films.GetFilmInfoByIdUseCase
import studio.stilip.tensorkinopoisk.views.FilmInfoView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FilmInfoPresenter @Inject constructor(
    private val getMovieById: GetFilmInfoByIdUseCase,
) : BasePresenter<FilmInfoView>() {

    fun getFilm(id: String) {
        getMovieById(id)
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