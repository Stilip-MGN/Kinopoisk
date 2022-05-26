package studio.stilip.tensorkinopoisk.ui.movieInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import studio.stilip.tensorkinopoisk.App
import studio.stilip.tensorkinopoisk.R
import studio.stilip.tensorkinopoisk.databinding.ActivityFilmInfoBinding
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo
import studio.stilip.tensorkinopoisk.presentation.MovieInfoPresenter
import studio.stilip.tensorkinopoisk.views.FilmInfoView
import javax.inject.Inject
import javax.inject.Provider

class MovieInfoActivity : MvpAppCompatActivity(), FilmInfoView {

    @Inject
    lateinit var presenterProvider: Provider<MovieInfoPresenter>

    private val filmPresenter: MovieInfoPresenter by moxyPresenter { presenterProvider.get() }

    private val binding: ActivityFilmInfoBinding by lazy {
        ActivityFilmInfoBinding.inflate(layoutInflater)
    }

    private lateinit var actorsAdapter: ActorsAdapter

    private val filmId: String by lazy { intent.getStringExtra(EXTRA_FILM_ID)!! }

    private var isDescriptionOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        filmPresenter.getMovie(filmId)
        actorsAdapter = ActorsAdapter()

        with(binding) {
            recActors.apply {
                layoutManager =
                    GridLayoutManager(this.context, 3, GridLayoutManager.HORIZONTAL, false)
                adapter = actorsAdapter
            }
        }

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

    override fun showFilm(film: MovieInfo) {
        with(binding) {
            filmName.text = film.name
            rating.text = film.rating.toString()
            year.text = film.year.toString()
            genre.text = film.genre.joinToString(", ")

            description.text = film.description
            description.setOnClickListener {
                if (isDescriptionOpen) {
                    isDescriptionOpen = false
                    description.maxLines = 4
                } else {
                    isDescriptionOpen = true
                    description.maxLines = 50
                }
            }

            Glide.with(poster.context)
                .load(film.poster)
                .centerCrop()
                .into(poster)

            actorsAdapter.setList(film.actors)

            when {
                film.rating > 7 -> rating.setTextColor(
                    ContextCompat.getColor(
                        rating.context,
                        R.color.green
                    )
                )
                film.rating > 4 -> rating.setTextColor(
                    ContextCompat.getColor(
                        rating.context,
                        R.color.yellow
                    )
                )
                else -> rating.setTextColor(
                    ContextCompat.getColor(
                        rating.context,
                        R.color.red
                    )
                )
            }
        }
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
            return Intent(context, MovieInfoActivity::class.java).apply {
                putExtra(EXTRA_FILM_ID, filmId)
            }
        }
    }
}