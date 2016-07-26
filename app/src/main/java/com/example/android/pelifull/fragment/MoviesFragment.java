package com.example.android.pelifull.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.pelifull.R;
import com.example.android.pelifull.adapter.MoviesAdapter;
import com.example.android.pelifull.api.MovieApiAdapter;
import com.example.android.pelifull.models.MovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private RecyclerView rvMovies;
    private MoviesAdapter moviesAdapter;


    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moviesAdapter = new MoviesAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        rvMovies = (RecyclerView) view.findViewById(R.id.rv_movies);
        rvMovies.setLayoutManager(new GridLayoutManager(getContext(),2));
        rvMovies.setAdapter(moviesAdapter);
        callApi();
        return view;
    }
    private void callApi(){
        Call<MovieResponse> call = MovieApiAdapter.getApiService().getMovies("popular");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call,Response<MovieResponse> response) {
                moviesAdapter.addAll(response.body().getMovies());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
