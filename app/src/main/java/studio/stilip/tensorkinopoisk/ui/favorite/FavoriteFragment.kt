package studio.stilip.tensorkinopoisk.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tinkoff_hr.utils.ui.Dp
import com.example.tinkoff_hr.utils.ui.PaddingItemDecoration
import com.example.tinkoff_hr.utils.ui.dpToPx
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import studio.stilip.tensorkinopoisk.App
import studio.stilip.tensorkinopoisk.R
import studio.stilip.tensorkinopoisk.databinding.FragmentFavoriteBinding
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.presentation.FavoritePresenter
import studio.stilip.tensorkinopoisk.ui.films.FilmsAdapter
import studio.stilip.tensorkinopoisk.ui.movieInfo.MovieInfoActivity
import studio.stilip.tensorkinopoisk.views.FavoriteView
import javax.inject.Inject
import javax.inject.Provider

class FavoriteFragment : MvpAppCompatFragment(R.layout.fragment_favorite), FavoriteView {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var filmsAdapter: FilmsAdapter

    @Inject
    lateinit var presenterProvider: Provider<FavoritePresenter>

    val favoritePresenter: FavoritePresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFavoriteBinding.bind(view)

        filmsAdapter = FilmsAdapter { id ->
            startActivity(
                MovieInfoActivity.createIntent(
                    requireContext(),
                    id
                )
            )
        }

        with(binding) {
            recMovies.apply {
                layoutManager = GridLayoutManager(this@FavoriteFragment.context, 2)
                adapter = filmsAdapter

            }

            recMovies.addItemDecoration(
                PaddingItemDecoration(
                    bottom = requireContext().dpToPx(EDUCATION_LIST_BOTTOM_PADDING),
                    filter = { holder ->

                        holder.adapterPosition == filmsAdapter.itemCount - 1
                    })
            )
        }
    }

    private companion object {
        @Dp
        const val EDUCATION_LIST_BOTTOM_PADDING = 30F
    }

    override fun showFilms(list: List<Film>) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }
}