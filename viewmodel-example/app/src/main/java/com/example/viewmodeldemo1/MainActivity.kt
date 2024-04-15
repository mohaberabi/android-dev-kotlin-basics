package com.example.viewmodeldemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    private val newWayViewModel: MainViewModel by viewModels()

    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModelWithParam: MainViewModelParam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainViewModelFactory(200)
        viewModelWithParam =
            ViewModelProvider(this, viewModelFactory)[MainViewModelParam::class.java]
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.countText.text = viewModel.getCount().toString()
        binding.button.setOnClickListener {
            binding.countText.text = viewModel.getUpdatedCount().toString()
        }
    }
}