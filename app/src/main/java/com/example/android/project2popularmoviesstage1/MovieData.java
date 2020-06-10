package com.example.android.project2popularmoviesstage1;

public class MovieData {

    private String mReleaseDate;
    private String mVoteAverage;
    private String mPosterPath;
    private String mOverview;
    private String mMovieTitle;

    public MovieData() {
    }
    public MovieData(String releaseDate, String voteAverage, String posterPath, String overview, String movieTitle){
          mReleaseDate = releaseDate;
          mVoteAverage = voteAverage;
          mPosterPath = posterPath;
          mOverview = overview;
          mMovieTitle = movieTitle;
    }

    public String getReleaseDate(){ return mReleaseDate;}
    public String getVoteAverage(){ return mVoteAverage;}
    public String getPosterPath(){ return "https://image.tmdb.org/t/p/w500" + mPosterPath;}
    public String getOverview(){ return mOverview;}
    public String getMovieTitle(){ return mMovieTitle;}
}
