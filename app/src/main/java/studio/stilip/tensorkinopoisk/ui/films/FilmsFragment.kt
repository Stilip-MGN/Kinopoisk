package studio.stilip.tensorkinopoisk.ui.films

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.utils.ui.Dp
import com.example.tinkoff_hr.utils.ui.PaddingItemDecoration
import com.example.tinkoff_hr.utils.ui.dpToPx
import studio.stilip.tensorkinopoisk.R
import studio.stilip.tensorkinopoisk.databinding.FragmentFilmsBinding
import studio.stilip.tensorkinopoisk.domain.entities.films.Film

class FilmsFragment : Fragment(R.layout.fragment_films) {

    private lateinit var binding: FragmentFilmsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilmsBinding.bind(view)

        val filmsAdapter = FilmsAdapter { film -> }

        binding.recFilms.apply {
            layoutManager = GridLayoutManager(this@FilmsFragment.context, 2)
            adapter = filmsAdapter

        }

        binding.recFilms.addItemDecoration(
            PaddingItemDecoration(
                bottom = requireContext().dpToPx(EDUCATION_LIST_BOTTOM_PADDING),
                filter = { holder ->

                    holder.adapterPosition == filmsAdapter.itemCount - 1
                })
        )

        filmsAdapter.setList(
            listOf(
                Film("1", "Кино", "", "боевик"),
                Film("1", "AAAAAAAAAAAAA AAAAAAAAA", "", "боевик"),
                Film("1", "Кино", "", "боевик"),
                Film("1", "Кино", "", "боевик"),
                Film("1", "AAAAAAAAAAAAA AAAAAAAAA", "", "боевик"),
                Film("1", "Кино", "", "боевик"),
            )
        )
    }

    private companion object {
        @Dp
        const val EDUCATION_LIST_BOTTOM_PADDING = 90F
    }
}