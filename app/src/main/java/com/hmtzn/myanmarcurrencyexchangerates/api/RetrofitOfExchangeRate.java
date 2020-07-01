package com.hmtzn.myanmarcurrencyexchangerates.api;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitOfExchangeRate {

    private static ApiInterface getApiInterface;
    private static Retrofit retrofit;
    private static Cache cache;
    private static OkHttpClient okClient;
    private static final String BASE_URL = "https://forex.cbm.gov.mm/api/";

    public static Call<RetrofitOfExchangeRate> getRetrofitInstance(final Context context) {
        if (getApiInterface == null) {

            //setup cache
            File httpCacheDirectory = new File(context.getCacheDir(), "responses");
            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            cache = new Cache(httpCacheDirectory, cacheSize);

            final OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();
            okClientBuilder.readTimeout(1, TimeUnit.MINUTES);
            okClientBuilder.connectTimeout(1, TimeUnit.MINUTES);
            okClientBuilder.writeTimeout(1, TimeUnit.MINUTES);

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                okClientBuilder.addInterceptor(logging);
            }

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            getApiInterface = retrofit.create(ApiInterface.class);
        }
        return getApiInterface.getLatest();
    }




    private static class BuildConfig {
        public static final boolean DEBUG = true;
    }
}
