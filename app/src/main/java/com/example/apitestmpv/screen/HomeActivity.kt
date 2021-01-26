package com.example.apitestmpv.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apitestmpv.R
import com.example.apitestmpv.data.model.Movie
import com.example.apitestmpv.data.source.MovieRepository
import com.example.apitestmpv.screen.adapter.MainAdapter
import com.example.apitestmpv.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class HomeActivity : AppCompatActivity(), HomContract.View, OnItemRecyclerViewClickListener<Movie> {
    private val adapter: MainAdapter by lazy { MainAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onInitView()
        onInitData()
    }

    private fun onInitView() {
        recyclerViewMovie.setHasFixedSize(true)
        recyclerViewMovie.adapter = adapter
        adapter.registerItemRecyclerViewClickListener(this)

    }

    private fun onInitData() {
        val presenter = HomePresenter(MovieRepository.instance)
        presenter.setView(this)
        presenter.onStart()
    }

    override fun onGetMovieSuccess(movies: MutableList<Movie>) {
        adapter.updateData(movies)

    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: Movie?) {
        Toast.makeText(this, item?.originalTitle, Toast.LENGTH_LONG).show()
    }


}