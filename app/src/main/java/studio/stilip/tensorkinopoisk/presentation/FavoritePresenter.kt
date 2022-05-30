package studio.stilip.tensorkinopoisk.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import studio.stilip.tensorkinopoisk.base.BasePresenter
import studio.stilip.tensorkinopoisk.domain.usecases.favorite.GetAllMoviesFromFavoriteUseCase
import studio.stilip.tensorkinopoisk.views.FavoriteView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FavoritePresenter @Inject constructor(
    private val getAllMovies: GetAllMoviesFromFavoriteUseCase
) : BasePresenter<FavoriteView>() {

    fun getMovies(){
        Timber.e("ОБРАЩЕНИЕ К БАЗЕ")
        getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                viewState.showMovies(list)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }

}