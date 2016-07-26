package com.example.android.pelifull.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by felipe on 11/07/16.
 */
public class Movie {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("relase_date")
    private String relase_date;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("vote_average")
    private String vote_average;
    @SerializedName("overview")
    private String overview;

    public Movie(String id, String title, String relase_date, String poster_path, String vote_average, String overview) {
        this.id = id;
        this.title = title;
        this.relase_date = relase_date;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelase_date() {
        return relase_date;
    }

    public void setRelase_date(String relase_date) {
        this.relase_date = relase_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

}
