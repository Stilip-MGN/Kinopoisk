package studio.stilip.tensorkinopoisk.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import studio.stilip.tensorkinopoisk.BuildConfig
import studio.stilip.tensorkinopoisk.data.entities.FilmInfoResponse
import studio.stilip.tensorkinopoisk.data.entities.MoviesListResponse

interface RetrofitServiceMovie {

    @GET("/movie?token=${BuildConfig.API_TOKEN}&field=id")
    fun getMovie(@Query("search") search: String): Single<FilmInfoResponse>

    @GET("/movie?field=typeNumber&search=1&sortField=votes.imdb&sortType=-1&token=${BuildConfig.API_TOKEN}")
    fun getFilms(): Single<MoviesListResponse>

    @GET("/movie?token=${BuildConfig.API_TOKEN}&sortField=votes.imdb&sortType=-1&field=typeNumber&search=1&isStrict=false&field=name")
    fun getFilmsByName(@Query("search") search: String): Single<MoviesListResponse>

    @GET("/movie?field=typeNumber&search=2&page=2&limit=10&sortField=votes.imdb&sortType=-1&token=${BuildConfig.API_TOKEN}")
    fun getSeries(): Single<MoviesListResponse>
}
//ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06 test