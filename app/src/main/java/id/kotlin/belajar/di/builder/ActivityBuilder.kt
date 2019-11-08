package id.kotlin.belajar.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.belajar.di.factory.ViewModelFactory
import id.kotlin.belajar.di.module.HomeModule
import id.kotlin.belajar.di.scope.Presentation
import id.kotlin.belajar.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @Presentation
  @ContributesAndroidInjector(modules = [HomeModule::class])
  abstract fun contributeHomeActivity(): HomeActivity
}