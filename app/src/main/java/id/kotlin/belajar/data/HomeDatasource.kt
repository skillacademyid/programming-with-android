package id.kotlin.belajar.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDatasource {

  @GET("/3/discover/movie")
  fun discoverMovie(
      @Query("api_key")
      apiKey: String,

      @Query("page")
      page: Long
  ): Single<HomeResponse>
}