package id.kotlin.belajar.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.belajar.data.HomeDatasource
import id.kotlin.belajar.data.HomeFactory
import id.kotlin.belajar.di.scope.Presentation
import id.kotlin.belajar.domain.HomeRepository
import id.kotlin.belajar.domain.HomeRepositoryImpl
import id.kotlin.belajar.domain.HomeUsecase
import id.kotlin.belajar.domain.executor.JobExecutor
import id.kotlin.belajar.domain.executor.UIThread
import id.kotlin.belajar.presentation.HomeActivity
import id.kotlin.belajar.presentation.HomePresenter
import id.kotlin.belajar.presentation.HomeView
import retrofit2.Retrofit

@Module
abstract class HomeModule {

  @Module
  companion object {

    @JvmStatic
    @Presentation
    @Provides
    fun providesDatasource(retrofit: Retrofit): HomeDatasource =
        retrofit.create(HomeDatasource::class.java)

    @JvmStatic
    @Presentation
    @Provides
    fun providesFactory(datasource: HomeDatasource): HomeFactory =
        HomeFactory(datasource)

    @JvmStatic
    @Presentation
    @Provides
    fun providesRepository(factory: HomeFactory): HomeRepositoryImpl =
        HomeRepositoryImpl(factory)

    @JvmStatic
    @Presentation
    @Provides
    fun providesUsecase(
        repository: HomeRepository,
        executor: JobExecutor,
        thread: UIThread
    ): HomeUsecase = HomeUsecase(repository, executor, thread)

    @JvmStatic
    @Presentation
    @Provides
    fun providesPresenter(
        view: HomeView,
        usecase: HomeUsecase
    ): HomePresenter = HomePresenter(view, usecase)
  }

  @Binds
  abstract fun bindRepository(repositoryImpl: HomeRepositoryImpl): HomeRepository

  @Binds
  abstract fun bindView(activity: HomeActivity): HomeView
}