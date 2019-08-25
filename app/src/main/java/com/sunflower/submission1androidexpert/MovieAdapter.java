package com.sunflower.submission1androidexpert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> heroes;

    public void setHeroes(ArrayList<Movie> heroes) {
        this.heroes = heroes;
    }
    public MovieAdapter(Context context) {
        this.context = context;
        heroes = new ArrayList<>();
    }

    private class ViewHolder {
        private TextView title_movie,rating;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            title_movie = view.findViewById(R.id.tv_title_movie);
            rating = view.findViewById(R.id.tv_rating);
            imgPhoto = view.findViewById(R.id.img_photo);


        }
        void bind(Movie hero) {
            title_movie.setText(hero.getTitle_movie());
            rating.setText(hero.getRating());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
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
        Movie hero = (Movie) getItem(i);
        viewHolder.bind(hero);
        return view;
    }
}