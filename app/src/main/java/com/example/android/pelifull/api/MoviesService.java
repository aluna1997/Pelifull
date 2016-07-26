package com.example.android.pelifull.api;

import com.example.android.pelifull.models.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by felipe on 11/07/16.
 */
public interface MoviesService {

    @GET("{order}" + Constant.URL + Constant.API_KEY)
    Call<MovieResponse>getMovies(@Path("order")String order);
}
