package com.example.retrofitexample.network

import com.example.retrofitexample.Album
import com.example.retrofitexample.Albums
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.concurrent.TimeUnit


object Constants {
    const val baseUrl = "https://jsonplaceholder.typicode.com"

    const val albumsEndPoint = "/albums"
    const val albumPathParam = "${albumsEndPoint}/{id}"

}

interface AlbumsServices {
    @GET(Constants.albumsEndPoint)
    suspend fun getAlbums(): Response<Albums>

    @POST(Constants.albumsEndPoint)
    suspend fun saveAlbum(@Body album: Album): Response<Album>


    @GET(Constants.albumPathParam)
    suspend fun getAlbumById(@Path("id") id: Int): Response<Album>

    @GET(Constants.albumsEndPoint)
    suspend fun getAlbumsSorted(@Query("userId") userId: Int): Response<Albums>
}


class RetrofitFactory {


    companion object {
        private val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val client = OkHttpClient.Builder().apply {
            addInterceptor(interceptor).connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()

        fun retrofit(): Retrofit {
            return Retrofit.Builder().baseUrl(Constants.baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }

}




