package id.kotlin.belajar.di.module

import dagger.Module
import dagger.Provides
import id.kotlin.belajar.domain.executor.JobExecutor
import id.kotlin.belajar.domain.executor.UIThread
import javax.inject.Singleton

@Module
class ApplicationModule {

  @Provides
  @Singleton
  fun providesJobExecutor(): JobExecutor = JobExecutor()

  @Provides
  @Singleton
  fun providesUIThread(): UIThread = UIThread()
}