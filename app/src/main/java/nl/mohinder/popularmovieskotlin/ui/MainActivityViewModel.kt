package nl.mohinder.popularmovieskotlin.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import nl.mohinder.popularmovieskotlin.model.Movie
import nl.mohinder.popularmovieskotlin.model.MovieResponse
import nl.mohinder.popularmovieskotlin.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepository : MovieRepository = MovieRepository()

    val movieList = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    val year = MutableLiveData<Int>()

    fun updateMovies() {
        if (isValidYear()) {
            getMoviesByYear(year.value)
        } else {
            error.value = "Entered a wrong year!"
        }
    }

    private fun getMoviesByYear(year: Int?) {
        movieRepository.getMoviesByYear(year!!).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                error.value = t.message
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movieResponse = response.body()
                movieList.value = movieResponse?.movies
                Log.i("1233333", movieList.value?.size.toString())
            }
        })
    }

    private fun isValidYear() : Boolean {
        return when {
            year.value == null -> {
                false
            }
            else -> {
                true
            }
        }
    }
}