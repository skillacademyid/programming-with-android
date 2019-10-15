package id.kotlin.belajar.data

import id.kotlin.belajar.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDatasource {

  @GET("/3/discover/movie")
  fun discoverMovie(
      @Query("api_key")
      apiKey: String = BuildConfig.API_KEY
  ): Call<HomeResponse>
}