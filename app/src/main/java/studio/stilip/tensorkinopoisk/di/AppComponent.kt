package studio.stilip.tensorkinopoisk.di

import dagger.Component
import studio.stilip.tensorkinopoisk.ui.films.FilmsFragment
import javax.inject.Singleton


@Component(modules = [RepositoryModule::class, RetrofitModule::class])
@Singleton
interface AppComponent {
    fun inject(fragment: FilmsFragment)
}