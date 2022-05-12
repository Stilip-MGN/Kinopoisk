package studio.stilip.tensorkinopoisk.ui.films

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tinkoff_hr.utils.ui.Dp
import com.example.tinkoff_hr.utils.ui.PaddingItemDecoration
import com.example.tinkoff_hr.utils.ui.dpToPx
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import studio.stilip.tensorkinopoisk.App
import studio.stilip.tensorkinopoisk.R
import studio.stilip.tensorkinopoisk.data.api.RetrofitProvider
import studio.stilip.tensorkinopoisk.data.api.RetrofitServiceFilm
import studio.stilip.tensorkinopoisk.data.repositories.FilmRepositoryImpl
import studio.stilip.tensorkinopoisk.databinding.FragmentFilmsBinding
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.usecases.GetFilmInfoByIdUseCase
import studio.stilip.tensorkinopoisk.presentation.FilmsPresenter
import studio.stilip.tensorkinopoisk.ui.films.filmInfo.FilmInfoActivity
import studio.stilip.tensorkinopoisk.views.FilmView
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

class FilmsFragment : MvpAppCompatFragment(R.layout.fragment_films), FilmView {

    private lateinit var binding: FragmentFilmsBinding
    private lateinit var filmsAdapter: FilmsAdapter

    @Inject
    lateinit var presenterProvider: Provider<FilmsPresenter>

    val filmsPresenter: FilmsPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFilmsBinding.bind(view)

        filmsAdapter = FilmsAdapter { id ->
            startActivity(
                FilmInfoActivity.createIntent(
                    requireContext(),
                    id
                )
            )
        }

        with(binding) {
            recFilms.apply {
                layoutManager = GridLayoutManager(this@FilmsFragment.context, 2)
                adapter = filmsAdapter

            }

            recFilms.addItemDecoration(
                PaddingItemDecoration(
                    bottom = requireContext().dpToPx(EDUCATION_LIST_BOTTOM_PADDING),
                    filter = { holder ->

                        holder.adapterPosition == filmsAdapter.itemCount - 1
                    })
            )

            textSearch.setEndIconOnClickListener {

                (textSearch)
            }

            textSearch.setEndIconOnClickListener {
                val searchName = fieldSearch.text.toString()
                filmsPresenter.getFilmsByName(searchName)
            }

            fieldSearch.addTextChangedListener {
                if (fieldSearch.text.toString().isEmpty())
                    filmsPresenter.getFilms()
            }
        }


    }

    override fun showFilms(list: List<Film>) {
        filmsAdapter.setList(list)
    }

    override fun showError(message: String) {
        Timber.e(message)
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    private companion object {
        @Dp
        const val EDUCATION_LIST_BOTTOM_PADDING = 90F
    }
}