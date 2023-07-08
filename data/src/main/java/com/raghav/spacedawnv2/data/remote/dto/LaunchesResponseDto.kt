package com.raghav.spacedawnv2.data.remote.dto

import androidx.annotation.Keep
import com.raghav.spacedawnv2.domain.model.LaunchesResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// @JsonClass is used to make sure that Moshi uses code-gen instead of Reflection
// for Serializing and Deserializing data
@JsonClass(generateAdapter = true)
@Keep
data class LaunchesResponseDto(
    @Json(name = "count")
    val count: Int?,
    @Json(name = "next")
    val next: String?,
    @Json(name = "previous")
    val previous: Any?,
    @Json(name = "results")
    val results: List<LaunchDetailDto?>?
)

fun LaunchesResponseDto.toDomain(): LaunchesResponse {
    return LaunchesResponse(
        count = count,
        next = next,
        previous = previous,
        results = results?.map { it?.toLaunchDetail() }
    )
}
