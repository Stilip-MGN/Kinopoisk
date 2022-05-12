package studio.stilip.tensorkinopoisk.ui.films.filmInfo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import studio.stilip.tensorkinopoisk.R
import studio.stilip.tensorkinopoisk.databinding.ActivityFilmInfoBinding

class FilmInfoActivity : AppCompatActivity() {

    private val binding: ActivityFilmInfoBinding by lazy {
        ActivityFilmInfoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
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

    companion object {

        private const val EXTRA_FILM_ID = "extra_film_id"

        fun createIntent(context: Context, filmId: String): Intent {
            return Intent(context, FilmInfoActivity::class.java).apply {
                putExtra(EXTRA_FILM_ID, filmId)
            }
        }
    }
}