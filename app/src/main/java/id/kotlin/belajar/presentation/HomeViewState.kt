package id.kotlin.belajar.presentation

sealed class HomeViewState {

  object Loading : HomeViewState()
  object Done : HomeViewState()
  object Page : HomeViewState()

  data class Failed(val error: Throwable) : HomeViewState()
}