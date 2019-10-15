package id.kotlin.belajar.di.module

import dagger.Module
import dagger.Provides
import id.kotlin.belajar.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

  @Provides
  @Singleton
  fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
      level = when (BuildConfig.DEBUG) {
        true -> Level.BODY
        false -> Level.NONE
      }
    }
  }

  @Provides
  @Singleton
  fun providesHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder().apply {
      retryOnConnectionFailure(true)
      addInterceptor(interceptor)
    }.build()
  }

  @Provides
  @Singleton
  fun providesHttpAdapter(client: OkHttpClient): Retrofit {
    return Retrofit.Builder().apply {
      client(client)
      baseUrl(BuildConfig.BASE_URL)
      addConverterFactory(GsonConverterFactory.create())
    }.build()
  }
}