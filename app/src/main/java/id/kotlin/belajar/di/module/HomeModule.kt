package id.kotlin.belajar.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.belajar.data.HomeDatasource
import id.kotlin.belajar.presentation.HomeActivity
import id.kotlin.belajar.presentation.HomeViewModel
import id.kotlin.belajar.presentation.HomeViewModelCallback
import retrofit2.Retrofit

@Module
abstract class HomeModule {

  @Module
  companion object {

    @JvmStatic
    @Provides
    fun providesHomeDatasource(retrofit: Retrofit): HomeDatasource =
        retrofit.create(HomeDatasource::class.java)

    @JvmStatic
    @Provides
    fun providesHomeViewModel(
        callback: HomeViewModelCallback,
        datasource: HomeDatasource
    ): HomeViewModel = HomeViewModel(callback, datasource)
  }

  @Binds
  abstract fun bindHomeViewModelCallback(activity: HomeActivity): HomeViewModelCallback
}