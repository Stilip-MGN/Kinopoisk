package studio.stilip.tensorkinopoisk.data.api.series

import io.reactivex.Single
import retrofit2.http.GET
import studio.stilip.tensorkinopoisk.BuildConfig
import studio.stilip.tensorkinopoisk.data.entities.FilmsListResponse

interface RetrofitServiceSeries {

    @GET("/movie?field=typeNumber&search=2&page=2&limit=10&sortField=votes.imdb&sortType=-1&token=${BuildConfig.API_TOKEN}")
    fun getSeries(): Single<FilmsListResponse>

}
//ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06 test