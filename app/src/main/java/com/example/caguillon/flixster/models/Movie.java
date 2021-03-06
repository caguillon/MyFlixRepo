package com.example.caguillon.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by caguillon on 6/15/16.
 */
public class Movie {
    //Walkthrough - Afternoon

    //Getters:
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    //"public" in front of the Strings?
    public String posterPath;
    public String originalTitle;
    public String overview;

    //Constructor
    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }

    //Method
    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();
        for(int x = 0; x < array.length(); x++){
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    //Lecture code/notes - Morning
    /*public String title;
    public String posterUrl;
    public int rating;

    public Movie(String title, String posterUrl, int rating) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.rating = rating;
    }

    public static ArrayList<Movie> getFakeMovies(){
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i = 0; i < 60; i++){
            movies.add(new Movie("The Social Network", "", 75));
            movies.add(new Movie("The Internship", "", 50));
            movies.add(new Movie("The Lion King", "", 100));
        }
        return movies;
    }

    @Override
    public String toString(){
        return title + "-" + rating;
    }*/
}
