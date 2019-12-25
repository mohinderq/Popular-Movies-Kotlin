package nl.mohinder.popularmovieskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import nl.mohinder.popularmovieskotlin.model.Movie

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_fav -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initView() {
        val movie : Movie = intent.getParcelableExtra("MOVIE")
        Glide.with(this).load(Movie.imageBasePath + movie.imageURL).into(ivPoster)
        Glide.with(this).load(Movie.imageBasePath + movie.backURL).into(ivBanner)
        tvTitle.text = movie.name
        tvReleaseDate.text = movie.releaseDate
        tvRating.text = movie.voteAverage.toString()
        tvDescription.text = movie.description
    }

}
