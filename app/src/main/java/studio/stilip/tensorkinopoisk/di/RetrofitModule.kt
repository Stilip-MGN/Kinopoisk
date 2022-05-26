package studio.stilip.tensorkinopoisk.di

import dagger.Module
import dagger.Provides
import studio.stilip.tensorkinopoisk.data.api.RetrofitProvider
import studio.stilip.tensorkinopoisk.data.api.RetrofitServiceFilm
import studio.stilip.tensorkinopoisk.data.api.series.RetrofitServiceSeries

@Module
class RetrofitModule {

    @Provides
    fun provideRetrofitServiceFilm(retrofitProvider: RetrofitProvider): RetrofitServiceFilm {
        return retrofitProvider.retrofitServiceFilm
    }

    @Provides
    fun provideRetrofitServiceSeries(retrofitProvider: RetrofitProvider): RetrofitServiceSeries {
        return retrofitProvider.retrofitServiceSeries
    }
}