package com.sunflower.submission1androidexpert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    private class ViewHolder {
        private TextView title_movie, rating, moviedate, movieduration, moviegenre, moviedesc;
        private ImageView imgPhoto;
        private RatingBar ratingBar;

        ViewHolder(View view) {
            title_movie = view.findViewById(R.id.tv_title_movie);
            rating = view.findViewById(R.id.tv_rating);
            moviedate = view.findViewById(R.id.tv_date);
            moviedesc = view.findViewById(R.id.tv_moviedesc);
            moviegenre = view.findViewById(R.id.tv_moviegenre);
            movieduration = view.findViewById(R.id.tv_duration);
            imgPhoto = view.findViewById(R.id.img_photo);
            ratingBar = view.findViewById(R.id.ratingBar);
        }

        void bind(Movie movie) {
            title_movie.setText(movie.getTitle_movie());
            rating.setText(movie.getRating());
            ratingBar.setRating(Float.parseFloat(movie.getRating())/2);
            moviedate.setText(movie.getDate_movie());
            moviedesc.setText(movie.getMovie_desc().substring(0,95)+"...");
            moviegenre.setText(movie.getMovie_genre());
            movieduration.setText(movie.getDuration_movie() + " min");
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }



}