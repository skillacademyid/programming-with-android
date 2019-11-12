package id.kotlin.belajar.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import id.kotlin.belajar.data.HomeDatasource
import id.kotlin.belajar.data.HomeFactory
import id.kotlin.belajar.data.HomeService
import id.kotlin.belajar.di.scope.ViewModelKey
import id.kotlin.belajar.presentation.HomeViewModel
import retrofit2.Retrofit

@Suppress("unused")
@Module
abstract class HomeModule {

  @Module
  companion object {

    @JvmStatic
    @Provides
    fun providesHomeService(retrofit: Retrofit): HomeService {
      return retrofit.create(HomeService::class.java)
    }

    @JvmStatic
    @Provides
    fun providesHomeDatasource(service: HomeService): HomeDatasource {
      return HomeDatasource(service)
    }

    @JvmStatic
    @Provides
    fun providesHomeFactory(datasource: HomeDatasource): HomeFactory {
      return HomeFactory(datasource)
    }
  }

  @Binds
  @IntoMap
  @ViewModelKey(HomeViewModel::class)
  abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}