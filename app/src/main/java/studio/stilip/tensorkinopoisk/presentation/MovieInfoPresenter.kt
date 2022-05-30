package studio.stilip.tensorkinopoisk.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import studio.stilip.tensorkinopoisk.base.BasePresenter
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo
import studio.stilip.tensorkinopoisk.domain.usecases.DeleteMovieFromFavoriteUseCase
import studio.stilip.tensorkinopoisk.domain.usecases.GetMovieByIdFromFavoriteUseCase
import studio.stilip.tensorkinopoisk.domain.usecases.SetMovieToFavoriteUseCase
import studio.stilip.tensorkinopoisk.domain.usecases.films.GetFilmInfoByIdUseCase
import studio.stilip.tensorkinopoisk.views.FilmInfoView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class MovieInfoPresenter @Inject constructor(
    private val getMovieById: GetFilmInfoByIdUseCase,
    private val setMovieToFavorite: SetMovieToFavoriteUseCase,
    private val deleteMovieFromFavorite: DeleteMovieFromFavoriteUseCase,
    //private val getMovieByIdFromFavorite: GetMovieByIdFromFavoriteUseCase,
) : BasePresenter<FilmInfoView>() {

    private lateinit var movie: MovieInfo

    fun getMovie(id: String) {
        getMovieById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ film ->
                movie = film
                viewState.showFilm(movie)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }

    fun addMovieToFavorite() {
        return setMovieToFavorite(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showSuccess("Был добавлен в избранное")
            }, { error ->
                viewState.showError("Не смогли доавить в избранное, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }

    fun deleteMovieFromFavorite() {
        return deleteMovieFromFavorite(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showSuccess("Был удалён из избранное")
            }, { error ->
                viewState.showError("Не смогли доавить в избранное, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }
/*
    fun isMovieFavorite(id: String) {
        getMovieByIdFromFavorite(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ film ->
                movie = film
                viewState.showFilm(movie)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)

            }).disposeOnFinish()
    }
*/
}