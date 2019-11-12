package id.kotlin.belajar.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.kotlin.belajar.BelajarApp
import id.kotlin.belajar.di.module.NetworkModule
import id.kotlin.belajar.di.module.PresentationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AndroidSupportInjectionModule::class,
  NetworkModule::class,
  PresentationModule::class
])
interface ApplicationComponent : AndroidInjector<BelajarApp>