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

    //View lookup cache
    private static class ViewHolder{
        //TextView name
        TextView tvTitle;
        //TextView home
        TextView tvOverview;
    }

    //Constructor
    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for position
        Movie movie = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; //view lookup cache stored in tag

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            //can also implement with ImageView
            convertView.setTag(viewHolder);

        } else{
            viewHolder = (ViewHolder) convertView.getTag();
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
