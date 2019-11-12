package id.kotlin.belajar.data

import id.kotlin.belajar.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {

  @GET("/3/discover/movie")
  fun discoverMovie(
      @Query("api_key")
      apiKey: String = BuildConfig.API_KEY,

      @Query("page")
      page: Long
  ): Single<HomeResponse>
}