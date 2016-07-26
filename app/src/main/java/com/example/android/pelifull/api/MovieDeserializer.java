package com.example.android.pelifull.api;

import com.example.android.pelifull.models.Movie;
import com.example.android.pelifull.models.MovieResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by felipe on 11/07/16.
 */
public class MovieDeserializer implements JsonDeserializer<MovieResponse> {
    @Override
    public MovieResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Gson gson = new Gson();
        MovieResponse movieResponse = gson.fromJson(jsonElement,MovieResponse.class);
        JsonArray moviesArray= jsonElement.getAsJsonObject().getAsJsonArray("results");
        movieResponse.setMovies(extractMovie(moviesArray));
        return movieResponse;
    }

    private ArrayList<Movie> extractMovie(JsonArray moviesArray) {
        ArrayList<Movie> movieArrayLIst = new ArrayList<>();
        for (int i = 0; i< movieArrayLIst.size();i++){
            JsonObject movieData = moviesArray.get(i).getAsJsonObject();
            String id = movieData.get("id").getAsString();
            String title = movieData.get("title").getAsString();
            String release_date = movieData.get("release_date").getAsString();
            String poster_path = movieData.get("poster_path").getAsString();
            String vote_average = movieData.get("vote_average").getAsString();
            String overview = movieData.get("overview").getAsString();
            Movie currentMovie = new Movie(id,title,release_date,poster_path,vote_average,overview);
            movieArrayLIst.add(currentMovie);

        }
        return movieArrayLIst;
    }

}
