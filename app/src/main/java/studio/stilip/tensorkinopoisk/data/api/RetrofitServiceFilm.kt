package studio.stilip.tensorkinopoisk.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import studio.stilip.tensorkinopoisk.BuildConfig
import studio.stilip.tensorkinopoisk.data.entities.FilmInfoResponse
import studio.stilip.tensorkinopoisk.data.entities.FilmResponse

interface RetrofitServiceFilm {

    @GET("/movie?token=${BuildConfig.API_TOKEN}&field=id")
    fun getMovie(@Query("search") search: String): Single<FilmInfoResponse>

    @GET("/movie?search=2021&field=year&token=${BuildConfig.API_TOKEN}")
    fun getFilms(): Single<FilmsListResponse>
}
//ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06 test