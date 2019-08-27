package com.sunflower.submission1androidexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] movietitle,moviedate,movieduration,rating;
    private MovieAdapter adapter;
    private TypedArray movieposter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();
    }

    private void prepare() {
        movietitle = getResources().getStringArray(R.array.movie_title);
        rating = getResources().getStringArray(R.array.movie_rating);
        moviedate = getResources().getStringArray(R.array.movie_date);
        movieduration = getResources().getStringArray(R.array.movie_duration);
        movieposter = getResources().obtainTypedArray(R.array.data_photo);


    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < movietitle.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(movieposter.getResourceId(i, -1));
            movie.setTitle_movie(movietitle[i]);
            movie.setRating(rating[i]);
            movie.setDuration_movie(movieduration[i]);
            movie.setDate_movie(moviedate[i]);
            movies.add(movie);
        }
        adapter.setHeroes(movies);
    }
}
