package studio.stilip.tensorkinopoisk.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import studio.stilip.tensorkinopoisk.ui.favorite.FavoriteFragment
import studio.stilip.tensorkinopoisk.ui.films.FilmsFragment
import studio.stilip.tensorkinopoisk.ui.movieInfo.MovieInfoActivity
import studio.stilip.tensorkinopoisk.ui.series.SeriesFragment
import javax.inject.Singleton


@Component(modules = [RepositoryModule::class, RetrofitModule::class, RoomModule::class])
@Singleton
interface AppComponent {
    fun inject(fragment: FilmsFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(fragment: SeriesFragment)
    fun inject(activity: MovieInfoActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}