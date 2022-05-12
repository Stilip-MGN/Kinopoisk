package studio.stilip.tensorkinopoisk.ui.films.filmInfo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import studio.stilip.tensorkinopoisk.App
import studio.stilip.tensorkinopoisk.R
import studio.stilip.tensorkinopoisk.databinding.ActivityFilmInfoBinding
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.presentation.FilmInfoPresenter
import studio.stilip.tensorkinopoisk.views.FilmInfoView
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

class FilmInfoActivity : MvpAppCompatActivity(), FilmInfoView {

    private val binding: ActivityFilmInfoBinding by lazy {
        ActivityFilmInfoBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var presenterProvider: Provider<FilmInfoPresenter>

    val filmPresenter: FilmInfoPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showFilm(film: Film) {

    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    companion object {

        private const val EXTRA_FILM_ID = "extra_film_id"

        fun createIntent(context: Context, filmId: String): Intent {
            return Intent(context, FilmInfoActivity::class.java).apply {
                putExtra(EXTRA_FILM_ID, filmId)
            }
        }
    }
}