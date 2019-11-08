package id.kotlin.belajar.presentation

import id.kotlin.belajar.data.Result

interface HomeViewModelCallback {

  fun onSuccess(results: List<Result>)
  fun onError(error: Throwable)
}