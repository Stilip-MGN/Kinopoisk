package studio.stilip.tensorkinopoisk.di

import dagger.Module
import dagger.Provides
import studio.stilip.tensorkinopoisk.data.api.RetrofitProvider
import studio.stilip.tensorkinopoisk.data.api.RetrofitServiceMovie

@Module
class RetrofitModule {

    @Provides
    fun provideRetrofitServiceFilm(retrofitProvider: RetrofitProvider): RetrofitServiceMovie {
        return retrofitProvider.retrofitServiceFilm
    }
}