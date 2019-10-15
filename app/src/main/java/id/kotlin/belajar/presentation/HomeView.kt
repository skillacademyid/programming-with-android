package id.kotlin.belajar.presentation

import id.kotlin.belajar.data.Result

interface HomeView {

  fun onShowLoading()
  fun onHideLoading()
  fun onResponse(results: List<Result>)
  fun onFailure(error: Throwable)
}