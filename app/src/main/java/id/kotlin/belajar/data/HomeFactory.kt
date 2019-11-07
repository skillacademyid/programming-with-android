package id.kotlin.belajar.data

import id.kotlin.belajar.BuildConfig
import io.reactivex.Single

class HomeFactory(private val datasource: HomeDatasource) {

  fun discoverMovie(page: Long): Single<HomeResponse> =
      datasource.discoverMovie(
          apiKey = BuildConfig.API_KEY,
          page = page
      )
}