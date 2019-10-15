package id.kotlin.belajar.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.belajar.data.HomeDatasource
import id.kotlin.belajar.presentation.HomeActivity
import id.kotlin.belajar.presentation.HomePresenter
import id.kotlin.belajar.presentation.HomeView
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
    fun providesHomePresenter(
        view: HomeView,
        datasource: HomeDatasource
    ): HomePresenter = HomePresenter(view, datasource)
  }

  @Binds
  abstract fun bindHomeView(activity: HomeActivity): HomeView
}