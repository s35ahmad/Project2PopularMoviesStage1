package com.example.android.project2popularmoviesstage1;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class tmdbJsonUtils {
/*    String releaseDate;
    String voteAverage;
    String posterPath;
    String overview;
    String movieTitle;*/

    public static MovieData[] getMovieDataOBJFromJson(Context context, String JsonStr)
            throws JSONException {

        JSONObject baseJson = new JSONObject(JsonStr);
        JSONArray resultsJson = baseJson.getJSONArray("results");
        MovieData[] movies = new MovieData[resultsJson.length()];

        for (int i = 0; i < resultsJson.length(); i++) {
            JSONObject movie = resultsJson.getJSONObject(i);
            String releaseDate = movie.getString("release_date");
            String voteAverage = movie.getString("vote_average");
            String posterPath = movie.getString("poster_path");
            String overview = movie.getString("overview");
            String movieTitle = movie.getString("title");
            movies[i] = new MovieData(releaseDate, voteAverage, posterPath, overview, movieTitle);

        }
        return movies;
    }
}

