package studio.stilip.tensorkinopoisk.data.api

import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitServiceFilm {

    @GET("/movie?search=326&field=id&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06")
    fun getMovie(): Single<MovieResponse>
}