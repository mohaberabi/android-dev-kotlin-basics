package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.retrofitexample.network.AlbumsServices
import com.example.retrofitexample.network.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    private lateinit var retroFit: AlbumsServices
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        retroFit = RetrofitFactory.retrofit()
            .create(AlbumsServices::class.java)

//        val albumLiveData: LiveData<Response<Album>> = liveData {
////
////
////            val album = retrofitServices.getAlbumById(3)
////
////            emit(album)
//        }
//
//        albumLiveData.observe(this) {
//            textView.text = it.body()!!.title
//        }
//        val responseLiveData: LiveData<Response<Albums>> = liveData {
//            val response = retrofitServices.getAlbums()
//            emit(response)
//        }
//
//        responseLiveData.observe(this) {
//
//
//            val items = it.body() ?: emptyList()
//
//            for (item in items) {
//                Log.i("item", item.title)
//            }
//        }

    }


    private fun getAlbumById() {

    }

    private fun getAllAlbums() {

    }

    private fun getAlbumsSorted() {

    }

    private fun saveAlbum() {
        val album = Album(1, 1, "")

        val postResponse: LiveData<Response<Album>> = liveData {
            val newAlbumRes = retroFit.saveAlbum(album)
            emit(newAlbumRes)
        }

        postResponse.observe(this) {

        }
    }
}