package com.example.caguillon.flixster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caguillon.flixster.R;
import com.example.caguillon.flixster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by caguillon on 6/16/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie>{

    //Constructor
    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for position
        Movie movie = getItem(position);

        //check the existing view being reused
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        //find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);

        //clear out image from convertView
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);

        //return the view
        return convertView;
    }
}
