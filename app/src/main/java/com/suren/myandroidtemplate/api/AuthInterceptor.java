package com.suren.myandroidtemplate.api;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


public class AuthInterceptor implements Interceptor {

    /**
     * Default constructor.
     */
    public AuthInterceptor() {
    }

    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder()
                .addQueryParameter("api_key", "")
                .build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
