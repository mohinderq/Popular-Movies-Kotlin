package nl.mohinder.popularmovieskotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    @Expose
    val movies: List<Movie>
)