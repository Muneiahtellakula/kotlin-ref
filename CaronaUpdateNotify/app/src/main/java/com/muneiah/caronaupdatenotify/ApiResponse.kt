package com.muneiah.caronaupdatenotify

import com.squareup.moshi.Json

data class ApiResponse(
    @Json(name = "statewise")
    val stateWiseDetails: List<Details>
)