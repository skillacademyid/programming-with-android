package id.kotlin.belajar.data

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("page")
    val page: Long? = -1L,

    @SerializedName("total_pages")
    val totalPages: Long? = -1L,

    @SerializedName("results")
    val results: List<Result>? = emptyList()
)

data class Result(
    @SerializedName("title")
    val title: String? = null,

    @SerializedName("overview")
    val overview: String? = null
)