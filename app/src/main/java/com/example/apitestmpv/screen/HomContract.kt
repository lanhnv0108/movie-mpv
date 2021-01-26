package com.example.apitestmpv.screen

import com.example.apitestmpv.data.model.Movie
import com.example.apitestmpv.utils.BasePresenter
import java.lang.Exception

interface HomContract {
    /**
     * View
     */
    interface View{
        fun onGetMovieSuccess(movies : MutableList<Movie>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View>{
        fun getMovies()
    }
}