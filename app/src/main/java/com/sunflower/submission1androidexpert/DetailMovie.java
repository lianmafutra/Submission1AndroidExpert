package com.sunflower.submission1androidexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailMovie extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        TextView title_desc = findViewById(R.id.title_desc);
        TextView tv_date = findViewById(R.id.tv_date);
        TextView tv_genre = findViewById(R.id.tv_genre);
        RatingBar ratingBar2 = findViewById(R.id.ratingBar2);
        TextView moviedesc = findViewById(R.id.tv_moviedesc);
        TextView ratingdesc = findViewById(R.id.tv_rating2);
        ImageView posterdesc = (ImageView) findViewById(R.id.img_poster_desc);
        ImageView postertrailer = (ImageView) findViewById(R.id.img_poster_trailer);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


            Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
            String s_title = movie.getTitle_movie();
            String s_moviedesc = movie.getMovie_desc();
            String s_ratingdesc = movie.getRating();
            String s_moviedate = movie.getDate_movie();
            String s_moviegenre = movie.getMovie_genre();
            float ratingbar = Float.parseFloat(movie.getRatingbar())/2;
            int poster_movie = movie.getPhoto();

            title_desc.setText(s_title);
            tv_genre.setText(s_moviegenre);
            moviedesc.setText(s_moviedesc);
            ratingdesc.setText(s_ratingdesc);
            ratingBar2.setRating(ratingbar);
            tv_date.setText(s_moviedate);

            posterdesc.setImageResource(poster_movie);
            postertrailer.setImageResource(poster_movie);

        }
    }
}
