package com.example.apitestmpv.screen

import com.example.apitestmpv.data.model.Movie
import com.example.apitestmpv.data.source.MovieRepository
import com.example.apitestmpv.data.source.remote.OnFetchDataListener
import com.example.apitestmpv.screen.HomContract.Presenter
import java.lang.Exception

class HomePresenter internal constructor(private val repository: MovieRepository?): Presenter {
    private var view : HomContract.View? = null

    override fun getMovies() {
        repository?.getMovie(object : OnFetchDataListener<MutableList<Movie>>{
            override fun onSuccess(data: MutableList<Movie>) {
               view?.onGetMovieSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }

        })
    }

    override fun onStart() {
        getMovies()
    }

    override fun onStop() {}

    override fun setView(view: HomContract.View?) {
        this.view = view
    }


}