package com.example.caguillon.flixster;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.caguillon.flixster.models.Movie;

import java.util.ArrayList;

/**
 * Created by caguillon on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie>{
    //Lecture - Morning; Note: not included in walkthrough (MovieArrayAdapter is the correct one)
    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        //ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);

        // Populate the data into the template view using the data object
        tvTitle.setText(movie.originalTitle);

        Log.d("MoviesAdapter", "Position: " + position);

        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        //Picasso.with(getContext()).load(imageUri).into(ivPoster);

        // Return the completed view to render on screen
        return convertView;
    }

}
