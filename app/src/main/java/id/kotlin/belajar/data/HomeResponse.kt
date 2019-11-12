package id.kotlin.belajar.data

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("page")
    val page: Long,

    @SerializedName("total_pages")
    val totalPages: Long,

    @SerializedName("results")
    val results: List<Result>
) {

  data class Result(
      @SerializedName("id")
      val id: Long,

      @SerializedName("title")
      val title: String,

      @SerializedName("overview")
      val overview: String
  )
}