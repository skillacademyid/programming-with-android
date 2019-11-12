package id.kotlin.belajar.presentation

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.kotlin.belajar.data.HomeResponse.Result

interface HomeView {

  val states: LiveData<HomeViewState>
  val paged: LiveData<PagedList<Result>>
}