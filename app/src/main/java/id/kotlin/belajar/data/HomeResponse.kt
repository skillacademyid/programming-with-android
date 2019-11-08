package id.kotlin.belajar.data

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("results")
    val results: List<Result>
)

data class Result(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String
)