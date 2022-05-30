package studio.stilip.tensorkinopoisk.ui.series

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tinkoff_hr.utils.ui.Dp
import com.example.tinkoff_hr.utils.ui.PaddingItemDecoration
import com.example.tinkoff_hr.utils.ui.dpToPx
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import studio.stilip.tensorkinopoisk.App
import studio.stilip.tensorkinopoisk.R
import studio.stilip.tensorkinopoisk.databinding.FragmentSeriesBinding
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.presentation.SeriesPresenter
import studio.stilip.tensorkinopoisk.ui.FilmsAdapter
import studio.stilip.tensorkinopoisk.ui.movieInfo.MovieInfoActivity
import studio.stilip.tensorkinopoisk.views.SeriesView
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

class SeriesFragment : MvpAppCompatFragment(R.layout.fragment_series), SeriesView {

    private lateinit var binding: FragmentSeriesBinding
    private lateinit var seriesAdapter: FilmsAdapter

    @Inject
    lateinit var presenterProvider: Provider<SeriesPresenter>

    val seriesPresenter: SeriesPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSeriesBinding.bind(view)

        seriesAdapter = FilmsAdapter{ id ->
            startActivity(
                MovieInfoActivity.createIntent(
                    requireContext(),
                    id
                )
            )
        }

        with(binding) {
            recSeries.apply {
                layoutManager = GridLayoutManager(this@SeriesFragment.context, 2)
                adapter = seriesAdapter

            }

            recSeries.addItemDecoration(
                PaddingItemDecoration(
                    bottom = requireContext().dpToPx(EDUCATION_LIST_BOTTOM_PADDING),
                    filter = { holder ->

                        holder.adapterPosition == seriesAdapter.itemCount - 1
                    })
            )

            textSearch.setEndIconOnClickListener {
                val searchName = fieldSearch.text.toString()
                seriesPresenter.getSeriesByName(searchName)
            }

            fieldSearch.addTextChangedListener {
                if (fieldSearch.text.toString().isEmpty())
                    seriesPresenter.getSeries()
            }
        }
    }

    override fun showSeries(list: List<Film>) {
        seriesAdapter.setList(list)
    }

    override fun showError(message: String) {
        Timber.e(message)
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    private companion object {
        @Dp
        const val EDUCATION_LIST_BOTTOM_PADDING = 30F
    }

}