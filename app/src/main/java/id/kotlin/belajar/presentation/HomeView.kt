package id.kotlin.belajar.presentation

import id.kotlin.belajar.domain.HomeEntity

interface HomeView {

  fun onShowLoading()
  fun onHideLoading()

  fun onSuccess(entity: HomeEntity)
  fun onError(error: Throwable)

  fun onPaginationSuccess(entity: HomeEntity)
  fun onPaginationError(error: Throwable)
}