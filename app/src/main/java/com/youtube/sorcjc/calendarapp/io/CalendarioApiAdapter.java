package com.youtube.sorcjc.calendarapp.io;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.youtube.sorcjc.calendarapp.bl.Utilitario;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Juarez on 11/12/2016.
 */

public class CalendarioApiAdapter {

    private static CalendarioApiService API_SERVICE;
    private static String url;

    public static CalendarioApiService getApiService(Context ctx) {

        // Creating the interceptor, and setting the log level
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        String url;
        url= Utilitario.readProperties(ctx).getProperty("IP_SERVER");
        String lsRuta = "http://" + url;

        // Adding the interceptor to a client
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.interceptors().add(logging);

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(lsRuta)
                    .addConverterFactory(buildGsonConverter())
                    .client(httpClient) // <-- using the log level
                    .build();
            API_SERVICE = retrofit.create(CalendarioApiService.class);
        }

        return API_SERVICE;
    }

    private static GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        // We don't need custom deserializers :v
        return GsonConverterFactory.create(gsonBuilder.create());
    }
}
