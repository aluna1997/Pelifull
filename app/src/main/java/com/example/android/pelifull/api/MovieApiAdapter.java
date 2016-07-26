package com.example.android.pelifull.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felipe on 11/07/16.
 */
public class MovieApiAdapter {
    private static MoviesService API_SERVICE;
    public static MoviesService getApiService(){
        if (API_SERVICE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(buildMoviesApiGsonConverter()))
                    .build();
            API_SERVICE = retrofit.create(MoviesService.class);
        }
        return API_SERVICE;
    }

    private static Gson buildMoviesApiGsonConverter() {
    return new GsonBuilder()
            .registerTypeAdapter(MovieApiAdapter.class, new MovieDeserializer())
            .create();
    }
}
