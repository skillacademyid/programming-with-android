package id.kotlin.belajar.di.module

import dagger.Module
import dagger.Provides
import id.kotlin.belajar.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

  @Singleton
  @Provides
  fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
      level = when (BuildConfig.DEBUG) {
        true -> Level.BODY
        false -> Level.NONE
      }
    }
  }

  @Singleton
  @Provides
  fun providesHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder().apply {
      retryOnConnectionFailure(true)
      addInterceptor(interceptor)
    }.build()
  }

  @Singleton
  @Provides
  fun providesHttpAdapter(client: OkHttpClient): Retrofit {
    return Retrofit.Builder().apply {
      client(client)
      baseUrl(BuildConfig.BASE_URL)
      addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
      addConverterFactory(GsonConverterFactory.create())
    }.build()
  }
}