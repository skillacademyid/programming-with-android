package id.kotlin.belajar.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.kotlin.belajar.BelajarApp
import id.kotlin.belajar.di.builder.ActivityBuilder
import id.kotlin.belajar.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AndroidSupportInjectionModule::class,
  NetworkModule::class,
  ActivityBuilder::class
])
interface ApplicationComponent : AndroidInjector<BelajarApp>