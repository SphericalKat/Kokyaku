package bio.kat.kokyaku.data

import bio.kat.kokyaku.data.network.JishoApi
import bio.kat.kokyaku.data.network.models.JlptAdapter
import bio.kat.kokyaku.di.AppScope
import bio.kat.kokyaku.di.SingleIn
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.moshi.Moshi
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


@ContributesTo(AppScope::class)
@Module
object DataModule {
    @Provides
    @SingleIn(AppScope::class)
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(JlptAdapter())
            .build()
    }

    @Provides
    @SingleIn(AppScope::class)
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                    redactHeader("Authorization")
                }
            )
            .build()
    }

    @Provides
    @SingleIn(AppScope::class)
    fun provideRetrofit(
        moshi: Moshi,
        okHttpClientLazy: Lazy<OkHttpClient>,
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://jisho.org/api/v1/")
            .callFactory { okHttpClientLazy.get().newCall(it) }
            .build()
    }

    @Provides
    @SingleIn(AppScope::class)
    fun provideJishoApi(
        baseRetrofit: Retrofit,
        okHttpClientLazy: Lazy<OkHttpClient>,
    ): JishoApi {
        return baseRetrofit
            .newBuilder()
            .callFactory { okHttpClientLazy.get().newCall(it) }
            .build()
            .create<JishoApi>()
    }
}