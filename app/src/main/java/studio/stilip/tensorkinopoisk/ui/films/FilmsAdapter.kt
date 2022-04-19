package studio.stilip.tensorkinopoisk.ui.films

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import studio.stilip.tensorkinopoisk.databinding.CardFilmBinding
import studio.stilip.tensorkinopoisk.domain.entities.films.Film

class FilmsAdapter(private val clickListener: (Film) -> Unit) :
    RecyclerView.Adapter<FilmsAdapter.FilmsHolder>() {
    private var films: List<Film> = emptyList()

    class FilmsHolder(val viewBinding: CardFilmBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsHolder {
        val binding = CardFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FilmsHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmsHolder, position: Int) {
        val item = films[position]
        with(holder.viewBinding) {
            title.text = item.title
            genre.text = item.genre
        }

        holder.itemView.setOnClickListener {
            clickListener.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return films.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Film>) {
        films = list
        notifyDataSetChanged()
    }

}