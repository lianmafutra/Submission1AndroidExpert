package com.sunflower.submission1androidexpert;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    String duration_movie,date_movie,title_movie,rating,ratingbar,movie_desc,movie_genre;

    public String getDuration_movie() {
        return duration_movie;
    }

    public void setDuration_movie(String duration_movie) {
        this.duration_movie = duration_movie;
    }

    public String getDate_movie() {
        return date_movie;
    }

    public void setDate_movie(String date_movie) {
        this.date_movie = date_movie;
    }

    public String getTitle_movie() {
        return title_movie;
    }

    public void setTitle_movie(String title_movie) {
        this.title_movie = title_movie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRatingbar() {
        return ratingbar;
    }

    public void setRatingbar(String ratingbar) {
        this.ratingbar = ratingbar;
    }

    public String getMovie_desc() {
        return movie_desc;
    }

    public void setMovie_desc(String movie_desc) {
        this.movie_desc = movie_desc;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    private int photo;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.duration_movie);
        dest.writeString(this.date_movie);
        dest.writeString(this.title_movie);
        dest.writeString(this.rating);
        dest.writeString(this.ratingbar);
        dest.writeString(this.movie_desc);
        dest.writeString(this.movie_genre);
        dest.writeInt(this.photo);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.duration_movie = in.readString();
        this.date_movie = in.readString();
        this.title_movie = in.readString();
        this.rating = in.readString();
        this.ratingbar = in.readString();
        this.movie_desc = in.readString();
        this.movie_genre = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
