package com.hasib.amphibians.data

import com.hasib.amphibians.network.AmphibianApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val amphibianRepository: NetworkAmphibiansRepository
}

class DefaultAppContainer : AppContainer {
    val api_url = "https://android-kotlin-fun-mars-server.appspot.com"
    val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(api_url)
        .build()

    val getRetrofit by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }

    override val amphibianRepository by lazy {
        NetworkAmphibiansRepository(getRetrofit)
    }
}