package com.example.viewmodelscopedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]


        viewModel.getUserData()

        viewModel.users.observe(this) {
            

                users ->
        }

        setContentView(R.layout.activity_main)
    }
}