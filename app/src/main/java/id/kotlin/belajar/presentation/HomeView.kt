package id.kotlin.belajar.presentation

import androidx.lifecycle.LiveData

interface HomeView {

  val states: LiveData<HomeViewState>

  fun discoverMovie()
}