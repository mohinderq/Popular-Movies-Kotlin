package nl.mohinder.popularmovieskotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(

    @SerializedName("id")
    var id: Int,

    @SerializedName("original_title")
    var name: String,

    @SerializedName("poster_path")
    var imageURL: String,

    @SerializedName("backdrop_path")
    var backURL: String,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("vote_average")
    var voteAverage: Double,

    @SerializedName("overview")
    var description: String,

    var rank: Int
) : Parcelable {
    companion object {
        const val imageBasePath = "https://image.tmdb.org/t/p/w500/"
    }
}