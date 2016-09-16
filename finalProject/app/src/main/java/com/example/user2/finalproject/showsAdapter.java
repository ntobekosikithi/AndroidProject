package com.example.user2.finalproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.squareup.picasso.Picasso;

public class showsAdapter extends RecyclerView.Adapter<showsAdapter.MovieViewHolder> {

    private List<Result> Result;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView moviePoster;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            moviePoster=(ImageView)v.findViewById(R.id.poster);
        }
    }

    public showsAdapter(List<Result> Result, int rowLayout, Context context) {
        this.Result = Result;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public showsAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(Result.get(position).getName());
        holder.data.setText("Date:  "+Result.get(position).getFirstAirDate());
        holder.movieDescription.setText(Result.get(position).getOverview());
        holder.rating.setText(Result.get(position).getVoteAverage().toString());
        Picasso.with(context).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2"+Result.get(position).getPosterPath().toString()).into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return Result.size();
    }
}
