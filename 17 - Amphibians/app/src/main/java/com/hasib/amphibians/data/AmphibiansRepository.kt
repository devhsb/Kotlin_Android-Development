package com.hasib.amphibians.data

import com.hasib.amphibians.network.AmphibianApiService

interface AmphibianRepository {
    suspend fun getAmphibians() : List<AmphibianModel>
}

class NetworkAmphibiansRepository(
    private val amphibianApiService: AmphibianApiService
): AmphibianRepository {
    override suspend fun getAmphibians(): List<AmphibianModel> = amphibianApiService.getAmphibians()
}