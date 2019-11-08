package id.kotlin.belajar.presentation

import id.kotlin.belajar.data.HomeResponse

sealed class HomeViewState {

  object Loading : HomeViewState()

  data class Success(val response: HomeResponse) : HomeViewState()
  data class Error(val error: Throwable) : HomeViewState()
}