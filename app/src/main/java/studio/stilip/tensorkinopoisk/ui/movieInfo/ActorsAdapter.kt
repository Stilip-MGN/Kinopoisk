package studio.stilip.tensorkinopoisk.ui.movieInfo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import studio.stilip.tensorkinopoisk.databinding.CardActorBinding
import studio.stilip.tensorkinopoisk.domain.entities.Actor

class ActorsAdapter : RecyclerView.Adapter<ActorsAdapter.ActorsHolder>() {

    class ActorsHolder(val viewBinding: CardActorBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    private var actors: List<Actor> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsHolder {
        val binding = CardActorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorsHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorsHolder, position: Int) {
        val item = actors[position]
        with(holder.viewBinding) {
            fullName.text = item.fullName

            Glide.with(photo.context)
                .load(item.urlPhoto)
                .centerCrop()
                .into(photo)
        }
    }

    override fun getItemCount(): Int = actors.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Actor>) {
        actors = list
        notifyDataSetChanged()
    }
}