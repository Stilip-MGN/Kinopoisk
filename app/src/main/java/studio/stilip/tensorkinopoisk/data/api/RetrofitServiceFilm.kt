package studio.stilip.tensorkinopoisk.data.api

import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitServiceFilm {

    @GET("/movie?search=387&field=id&token=CK8P20A-T6N4XPV-JSD67GF-6NKR399")
    fun getMovie(): Single<MovieResponse>

    @GET("/movie?search=2019&field=year&token=CK8P20A-T6N4XPV-JSD67GF-6NKR399")
    fun getFilms(): Single<FilmsListResponse>
}
//CK8P20A-T6N4XPV-JSD67GF-6NKR399 my
//ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06 test