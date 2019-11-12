package id.kotlin.belajar.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.kotlin.belajar.data.HomeResponse.Result

class HomeFactory(
    val datasource: HomeDatasource
) : DataSource.Factory<Long, Result>() {

  val home: MutableLiveData<HomeDatasource> = MutableLiveData()

  override fun create(): DataSource<Long, Result> {
    return datasource.also { home.postValue(datasource) }
  }
}