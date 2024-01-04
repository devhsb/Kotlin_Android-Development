package com.example.marsphotos.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable // convert and save the parsed json objects here
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src") //actual name of json image id
    var imgSrc: String
)