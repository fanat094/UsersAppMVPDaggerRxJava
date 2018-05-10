package com.example.dima.usersappmvpdaggerrxjava.di;

import com.example.dima.usersappmvpdaggerrxjava.api.ApiMethods;
import com.example.dima.usersappmvpdaggerrxjava.api.RetrofitService;

import javax.inject.Singleton;
import dagger.Provides;
import okhttp3.OkHttpClient.Builder;
import dagger.Module;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public Builder provideHttpClient(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        Builder httpClient = new Builder();
        httpClient.addInterceptor(loggingInterceptor);
        return httpClient;
    }

    @Singleton
    @Provides
    public Retrofit retrofit(Builder httpClient){

        return new Retrofit.Builder().baseUrl(ApiMethods.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Singleton
    @Provides
    public RetrofitService provideRetrofitService(Retrofit retrofit){
        return (RetrofitService) retrofit.create(RetrofitService.class);
    }
}

