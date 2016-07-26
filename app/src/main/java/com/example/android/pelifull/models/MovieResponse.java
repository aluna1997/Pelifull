package com.example.android.pelifull.models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by felipe on 11/07/16.
 */
public class MovieResponse {
    @SerializedName("results")
    private ArrayList<Movie> movies;
    public ArrayList<Movie> getMovies(){
        return movies;
    }
    public void setMovies(ArrayList<Movie> movies){
        this.movies = movies;
    }
}
