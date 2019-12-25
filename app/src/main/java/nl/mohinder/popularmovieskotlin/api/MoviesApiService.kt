package nl.mohinder.popularmovieskotlin.api

import nl.mohinder.popularmovieskotlin.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    @GET("discover/movie")
    fun getMoviesByYear(
        @Query("api_key") api_key : String,
        @Query("year") year : Int,
        @Query("language") language : String
    ) : Call<MovieResponse>

}