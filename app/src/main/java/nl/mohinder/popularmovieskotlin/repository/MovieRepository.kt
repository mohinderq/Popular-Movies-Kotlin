package nl.mohinder.popularmovieskotlin.repository

import nl.mohinder.popularmovieskotlin.api.MoviesApi
import nl.mohinder.popularmovieskotlin.api.MoviesApiService

class MovieRepository {

    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMoviesByYear(year: Int) = moviesApi.getMoviesByYear(apiKey, year, "en-US")

    companion object {
        private const val apiKey = "1178a7d42c17577398fcc1710d7fbcc4"
    }
}