package com.suren.myandroidtemplate.di;


import androidx.annotation.NonNull;

import com.suren.myandroidtemplate.BuildConfig;
import com.suren.myandroidtemplate.api.RestaurantService;
import com.suren.myandroidtemplate.rest.LiveDataCallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.suren.myandroidtemplate.AppConstants.CONNECT_TIMEOUT;
import static com.suren.myandroidtemplate.AppConstants.READ_TIMEOUT;
import static com.suren.myandroidtemplate.AppConstants.WRITE_TIMEOUT;
import static com.suren.myandroidtemplate.BuildConfig.BASE_URL;

/**
 * This class is responsible for setting up Retrofit and anything related to network calls.
 */

@Module
public class NetworkModule {


    @Provides
    @Singleton
    HttpLoggingInterceptor provideOkHttpInterceptors() {
        return new HttpLoggingInterceptor().
                setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    /**
     * Configure OkHttpClient. This helps us override some of the default configuration. Like the
     * connection timeout.
     *
     * @return OkHttpClient
     */
    @Provides
    @Singleton
    OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {

        return new OkHttpClient.Builder()
/*                .addInterceptor(new AuthInterceptor())*/
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofitClient(@NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()) // Serialize Objects
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Set call to return {@link Observable}
                .build();
    }


    @Provides
    @Singleton
    RestaurantService provideRestaurantService(@NonNull Retrofit retrofit) {
        return retrofit.create(RestaurantService.class);
    }
}
