package nl.mohinder.popularmovieskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import nl.mohinder.popularmovieskotlin.model.Movie
import nl.mohinder.popularmovieskotlin.ui.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel: MainActivityViewModel

    private val moviesList = arrayListOf<Movie>()
    private val moviesAdapter = MoviesAdapter(moviesList, { movie -> onMovieClick(movie) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        rvMovies.layoutManager = StaggeredGridLayoutManager(2, 1)
        rvMovies.adapter = moviesAdapter

        btnSubmit.setOnClickListener {
            mainActivityViewModel.year.value = etYear.text.toString().toIntOrNull()
            mainActivityViewModel.updateMovies()
        }
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProviders
            .of(this)
            .get(MainActivityViewModel::class.java)

        mainActivityViewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        mainActivityViewModel.movieList.observe(this, Observer {
            moviesList.clear()
            moviesList.addAll(it)
            moviesAdapter.notifyDataSetChanged()
        })
    }

    private fun onMovieClick(movie: Movie) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("MOVIE", movie)
        startActivity(intent)
    }
}
