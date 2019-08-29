package com.sunflower.submission1androidexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] movietitle, moviedate, movieduration, rating, moviedesc, moviegnre,ratingbar;
    private MovieAdapter adapter;
    private TypedArray movieposter;
    private ArrayList<Movie> movies = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = new Movie();
                movie.setTitle_movie(movies.get(i).getTitle_movie());
                movie.setMovie_desc(movies.get(i).getMovie_desc());
                movie.setDuration_movie(movies.get(i).getDuration_movie());
                movie.setDate_movie(movies.get(i).getDate_movie());
                movie.setRating(movies.get(i).getRating());
                movie.setRatingbar(movies.get(i).getRating());
                movie.setMovie_genre(movies.get(i).getMovie_genre());
                movie.setPhoto(movies.get(i).getPhoto());
                Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailMovie.class);
                moveWithObjectIntent.putExtra(DetailMovie.EXTRA_MOVIE, movie);
                startActivity(moveWithObjectIntent);
            }
        });

    }


    private void prepare() {
        movietitle = getResources().getStringArray(R.array.movie_title);
        rating = getResources().getStringArray(R.array.movie_rating);
        ratingbar = getResources().getStringArray(R.array.movie_rating);
        moviedate = getResources().getStringArray(R.array.movie_date);
        movieduration = getResources().getStringArray(R.array.movie_duration);
        moviedesc = getResources().getStringArray(R.array.movie_desc);
        moviegnre = getResources().getStringArray(R.array.movie_genre);
        movieposter = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < movietitle.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(movieposter.getResourceId(i, -1));
            movie.setTitle_movie(movietitle[i]);
            movie.setRating(rating[i]);
            movie.setRatingbar(ratingbar[i]);
            movie.setDuration_movie(movieduration[i]);
            movie.setDate_movie(moviedate[i]);
            movie.setMovie_desc(moviedesc[i]);
            movie.setMovie_genre(moviegnre[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }


}
