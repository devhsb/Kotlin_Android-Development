package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

// interface which defines the way of retrofit talking with the web server using http
 //in this case when the interface called it retrofit append "photos" endpoint to the end of BASE_URI to get the photos
interface MarsApiService {
    @GET("photos") // photos is the endpoint for the BASE_URL
    suspend fun getPhotos(): List<MarsPhoto>
}
