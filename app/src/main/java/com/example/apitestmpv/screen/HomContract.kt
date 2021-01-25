package com.example.apitestmpv.screen

interface HomContract {
    interface View{
        fun setData()
    }
    interface Presenter{
        fun loadData()

    }
}