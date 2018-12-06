package com.androidarchitectureproject.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class ApiService {

    private static ApiService apiService = new ApiService();
    public static ApiInterface apiInterface;
    public static Retrofit retrofit;


    private ApiService() { reset();}

    public static ApiService getInstance() {
        return apiService;
    }

    public void reset() {
        Gson gson = new GsonBuilder()
                //.setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {

                Request.Builder builder = chain.request().newBuilder();
                /*
                builder.addHeader("Content-Type", ApiConstans.LN_CONTENT_TYPE_JSON);
                builder.addHeader("DeviceType", ApiConstans.LN_CLIENT_TAG_ANDROID);
                //builder.addHeader("DeviceType", ApiConstans.LN_CLIENT_TAG_IOS);
                builder.addHeader("AccountId", ApiConstans.LN_ACCOUNT_ID);
                builder.addHeader("LanguageId", ApiConstans.LN_LANGUAGE_ID);
                */

                Request request = builder.build();
                return chain.proceed(request);
            }
        });


        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstans.API_PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        // Service setup
        apiInterface = retrofit.create(ApiInterface.class);
    }
}
