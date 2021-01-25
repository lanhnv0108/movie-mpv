package com.example.apitestmpv.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apitestmpv.R

class HomeActivity : AppCompatActivity() , HomContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setData() {
        TODO("Not yet implemented")
    }
}