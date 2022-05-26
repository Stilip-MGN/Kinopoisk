package studio.stilip.tensorkinopoisk.ui.series

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import studio.stilip.tensorkinopoisk.R
import studio.stilip.tensorkinopoisk.databinding.CardFilmBinding
import studio.stilip.tensorkinopoisk.domain.entities.films.Film

class SeriesAdapter(private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<SeriesAdapter.FilmsHolder>() {
    private var series: List<Film> = emptyList()

    class FilmsHolder(val viewBinding: CardFilmBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsHolder {
        val binding = CardFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FilmsHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmsHolder, position: Int) {
        val item = series[position]

        with(holder.viewBinding) {
            title.text = item.title
            year.text = if (item.year != 0) item.year.toString() else ""
            rating.text = item.rating.toString()

            when {
                item.rating > 7 -> rating.setBackgroundColor(
                    ContextCompat.getColor(
                        rating.context,
                        R.color.green
                    )
                )
                item.rating > 4 -> rating.setBackgroundColor(
                    ContextCompat.getColor(
                        rating.context,
                        R.color.yellow
                    )
                )
                else -> rating.setBackgroundColor(
                    ContextCompat.getColor(
                        rating.context,
                        R.color.red
                    )
                )
            }

            Glide.with(poster.context)
                .load(item.poster)
                .centerCrop()
                .into(poster)

        }

        holder.itemView.setOnClickListener {
            clickListener.invoke(item.id)
        }
    }

    override fun getItemCount(): Int {
        return series.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Film>) {
        series = list
        notifyDataSetChanged()
    }

}