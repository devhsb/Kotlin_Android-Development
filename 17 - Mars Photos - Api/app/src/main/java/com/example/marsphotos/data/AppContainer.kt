package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val marsPhotosRepository : NetworkMarsPhotosRepository
}

class  DefaultAppContainer() : AppContainer {
    // api link
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

    // build and create retrofit project
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) //convert json object to kotlin object
        .baseUrl(BASE_URL)
        .build()

    /*
    the lazy initializer in retrofitService variable means that it will be initialized in first usage
    and when we access it we will access the retrofit api it's object will be the only object
    that created in ti's first usage.
 */
    private val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    override val marsPhotosRepository: NetworkMarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }
}

