package nl.mohinder.popularmovieskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import nl.mohinder.popularmovieskotlin.R.layout.movie_item
import nl.mohinder.popularmovieskotlin.model.Movie

class MoviesAdapter(private val movieList: List<Movie>,
                    private val onClickListener: (Movie) -> Unit)
    : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private val OFFSET = 0x01

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(movie_item, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position], position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onClickListener(movieList[adapterPosition])
            }
        }

        fun bind(movie: Movie, position: Int) {
            itemView.tvRank.text = (position + OFFSET).toString()
            Glide
                .with(context)
                .load(Movie.imageBasePath + movie.imageURL)
                .into(itemView.ivMovie)
        }
    }
}