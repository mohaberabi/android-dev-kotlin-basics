package com.example.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var btnDownloadUserData: Button
    private lateinit var btnCount: Button
    private lateinit var tvCount: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDownloadUserData = findViewById(R.id.btnDownloadUserData)
        btnCount = findViewById(R.id.btnCount)
        tvCount = findViewById(R.id.tvCount)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
//        btnDownloadUserData.setOnClickListener {
//
//            CoroutineScope(Dispatchers.IO).launch {
//
//                val stock1 = async { getStock1() }
//
//                val stock2 = async { getStock2() }
//
//                val total = stock1.await() + stock2.await()
//
//                Log.i("tag", total.toString())
//            }
//        }


//        btnDownloadUserData.setOnClickListener {
//            CoroutineScope(Dispatchers.Main).launch {
//                tvCount.text = UseDataManager1().getTotalUsersCount().toString()
//
//            }
//        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
//                tvCount.text = UnstructuredConcurrncy().getTotalUsersCountAsync().toString()
                tvCount.text = StructuredConcurrency().getTotalUsersCount().toString()

            }
        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {

            withContext(Dispatchers.Main) {
                tvCount.text = "DOWNLAODING ${i} From ${Thread.currentThread().name}"
            }
        }
    }

    private suspend fun getStock1(): Int {
        delay(10000)
        return 100
    }

    private suspend fun getStock2(): Int {
        delay(12000)
        return 200
    }
}