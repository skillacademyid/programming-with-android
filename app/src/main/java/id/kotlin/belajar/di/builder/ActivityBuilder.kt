package id.kotlin.belajar.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.belajar.di.module.HomeModule
import id.kotlin.belajar.di.scope.Presentation
import id.kotlin.belajar.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

  @Presentation
  @ContributesAndroidInjector(modules = [HomeModule::class])
  abstract fun contributeHomeActivity(): HomeActivity
}