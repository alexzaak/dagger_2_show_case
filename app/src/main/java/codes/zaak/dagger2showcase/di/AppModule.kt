package codes.zaak.dagger2showcase.di

import codes.zaak.dagger2showcase.BuildConfig
import codes.zaak.dagger2showcase.utils.RxSchedulers
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun rxJava2CallAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    fun moshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            builder.addInterceptor(interceptor)
        }

        return builder.build()
    }

    @Provides
    fun moshiRetrofitBuilder(
        rxAdapter: RxJava2CallAdapterFactory,
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit.Builder = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(rxAdapter)

    @Provides
    fun restAdapter(retrofitBuilder: Retrofit.Builder): Retrofit =
        retrofitBuilder
            .baseUrl(BuildConfig.YES_NO_API_URL)
            .build()

    @Provides
    @Singleton
    fun rxSchedulers(): RxSchedulers = RxSchedulers()
}