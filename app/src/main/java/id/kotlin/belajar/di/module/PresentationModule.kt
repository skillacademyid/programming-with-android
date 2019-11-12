package id.kotlin.belajar.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.belajar.di.factory.ViewModelFactory
import id.kotlin.belajar.presentation.HomeActivity

@Suppress("unused")
@Module
abstract class PresentationModule {

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

  @ContributesAndroidInjector(modules = [HomeModule::class])
  abstract fun contributeHomeActivity(): HomeActivity
}