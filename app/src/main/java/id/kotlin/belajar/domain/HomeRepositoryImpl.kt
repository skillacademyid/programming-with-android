package id.kotlin.belajar.domain

import id.kotlin.belajar.data.HomeFactory
import id.kotlin.belajar.domain.HomeEntity.Result
import io.reactivex.Single

class HomeRepositoryImpl(
    private val factory: HomeFactory
) : HomeRepository {

  override fun discoverMovie(param: HomeParam): Single<HomeEntity> =
      factory.discoverMovie(param.page).map { response ->
        HomeEntity(
            page = response.page ?: -1L,
            totalPages = response.totalPages ?: -1L,
            results = response.results?.map { result ->
              Result(
                  title = result.title ?: "Untitled",
                  overview = result.overview ?: "No Description"
              )
            }?.toMutableList() ?: mutableListOf()
        )
      }
}