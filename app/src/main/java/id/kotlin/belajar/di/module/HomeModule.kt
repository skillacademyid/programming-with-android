package id.kotlin.belajar.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import id.kotlin.belajar.data.HomeDatasource
import id.kotlin.belajar.di.scope.ViewModelKey
import id.kotlin.belajar.presentation.HomeViewModel
import retrofit2.Retrofit

@Module
abstract class HomeModule {

  @Module
  companion object {

    @JvmStatic
    @Provides
    fun providesHomeDatasource(retrofit: Retrofit): HomeDatasource =
        retrofit.create(HomeDatasource::class.java)
  }

  @Binds
  @IntoMap
  @ViewModelKey(HomeViewModel::class)
  abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}