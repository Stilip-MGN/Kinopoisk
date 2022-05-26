package studio.stilip.tensorkinopoisk.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import studio.stilip.tensorkinopoisk.data.api.series.RetrofitServiceSeries
import javax.inject.Inject

class RetrofitProvider @Inject constructor() {
    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
        .build()

    val retrofitServiceFilm: RetrofitServiceFilm = Retrofit.Builder()
        .baseUrl("https://api.kinopoisk.dev")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RetrofitServiceFilm::class.java)

    val retrofitServiceSeries: RetrofitServiceSeries = Retrofit.Builder()
        .baseUrl("https://api.kinopoisk.dev")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RetrofitServiceSeries::class.java)

}