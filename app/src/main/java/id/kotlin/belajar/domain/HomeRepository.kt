package id.kotlin.belajar.domain

import io.reactivex.Single

interface HomeRepository {

  fun discoverMovie(param: HomeParam): Single<HomeEntity>
}