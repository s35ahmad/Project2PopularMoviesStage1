package com.example.android.PopularMovies1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView tv_releaseDate;
    private TextView tv_voteAverage;
    private ImageView iv_poster;
    private TextView tv_overview;
    private TextView tv_movieTitle;
    private String mReleaseDate;
    private String mVoteAverage;
    private String mPosterPath;
    private String mOverview;
    private String mMovieTitle;

    private String release_date = "RELEASE_DATE";
    private String vote_average = "VOTE_AVERAGE";
    private String poster_path = "POSTER_PATH";
    private String overview = "OVERVIEW";
    private String movie_title = "MOVIE_TITLE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv_releaseDate = (TextView) findViewById(R.id.tv_release_date);
        tv_voteAverage = (TextView) findViewById(R.id.tv_vote_average);
        iv_poster = (ImageView) findViewById(R.id.iv_detail_activity_poster);
        tv_overview = (TextView) findViewById(R.id.tv_overview);
        tv_movieTitle = (TextView) findViewById(R.id.tv_movie_title);

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(movie_title)) {
                mReleaseDate = intentThatStartedThisActivity.getStringExtra(release_date);
                mVoteAverage = intentThatStartedThisActivity.getStringExtra(vote_average);
                mPosterPath = intentThatStartedThisActivity.getStringExtra(poster_path);
                mOverview = intentThatStartedThisActivity.getStringExtra(overview);
                mMovieTitle = intentThatStartedThisActivity.getStringExtra(movie_title);

                tv_releaseDate.setText(mReleaseDate);
                tv_voteAverage.setText(mVoteAverage);

                Uri builder = Uri.parse("http://image.tmdb.org/t/p/w500/").buildUpon()
                        .appendEncodedPath(mPosterPath)
                        .build();
                Picasso.get().load(builder).into(iv_poster);

                tv_overview.setText(mOverview);
                tv_movieTitle.setText(mMovieTitle);
            }
        }
    }
}