package com.hasib.amphibians.network

import com.hasib.amphibians.data.AmphibianModel
import retrofit2.http.GET

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians() : List<AmphibianModel>
}