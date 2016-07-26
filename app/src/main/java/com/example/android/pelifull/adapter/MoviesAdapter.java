package com.example.android.pelifull.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.pelifull.R;
import com.example.android.pelifull.api.Constant;
import com.example.android.pelifull.models.Movie;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by felipe on 12/07/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {
    private ArrayList<Movie> movies;
    private Context context;
    public MoviesAdapter(Context context) {
        this.movies = new ArrayList<>();
        this.context = context;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.movie_item, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        holder.ponerImagenes();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    public void addAll(ArrayList<Movie> movies) {
        if(!this.movies.isEmpty()){
            this.movies.clear();
        }
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    protected class MoviesViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView moviePoster;

        public MoviesViewHolder(View gatitoFeliz) {
            super(gatitoFeliz);
            moviePoster = (SimpleDraweeView) gatitoFeliz.findViewById(R.id.movieImage);
        }
        public void ponerImagenes() {
            int pos = getAdapterPosition();
            Movie currentMovie = movies.get(pos);
            Uri uri = Uri.parse(Constant.IMAGE_BASE_URL + currentMovie.getPoster_path());
            moviePoster.setImageURI(uri);

        }
    }
}