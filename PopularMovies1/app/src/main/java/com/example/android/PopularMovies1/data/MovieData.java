package com.example.android.PopularMovies1.data;

public class MovieData {

    private String mReleaseDate;
    private String mVoteAverage;
    private String mPosterPath;
    private String mOverview;
    private String mMovieTitle;

    public MovieData(String releaseDate, String voteAverage, String posterPath, String overview, String movieTitle){
          mReleaseDate = releaseDate;
          mVoteAverage = voteAverage;
          mPosterPath = posterPath;
          mOverview = overview;
          mMovieTitle = movieTitle;
    }

    public String getReleaseDate(){ return mReleaseDate;}
    public String getVoteAverage(){ return mVoteAverage;}
    public String getPosterPath(){ return  mPosterPath;}
    public String getOverview(){ return mOverview;}
    public String getMovieTitle(){ return mMovieTitle;}
}