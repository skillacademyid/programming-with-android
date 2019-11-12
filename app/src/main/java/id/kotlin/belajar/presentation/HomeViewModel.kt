package id.kotlin.belajar.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.kotlin.belajar.data.HomeDatasource
import id.kotlin.belajar.data.HomeFactory
import id.kotlin.belajar.data.HomeResponse.Result
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val factory: HomeFactory
) : ViewModel(), HomeView {

  private val config = PagedList.Config.Builder().apply {
    setEnablePlaceholders(true)
    setPageSize(20)
  }.build()

  override val states: LiveData<HomeViewState>
    get() = Transformations.switchMap<HomeDatasource, HomeViewState>(
        factory.home,
        HomeDatasource::states
    )

  override val paged: LiveData<PagedList<Result>>
    get() = LivePagedListBuilder<Long, Result>(
        factory,
        config
    ).build()

  override fun onCleared() {
    super.onCleared()
    factory.datasource.disposables.clear()
  }
}