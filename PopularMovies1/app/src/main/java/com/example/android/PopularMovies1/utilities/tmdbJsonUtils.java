/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.PopularMovies1.utilities;

import android.content.Context;

import com.example.android.PopularMovies1.data.MovieData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Utility functions to handle OpenWeatherMap JSON data.
 */
public final class tmdbJsonUtils {

    public static MovieData[] getSimpleMovieStringsFromJson(Context context, String JsonStr)
            throws JSONException {

        JSONObject baseJson = new JSONObject(JsonStr);
        JSONArray resultsJson = baseJson.getJSONArray("results");
        MovieData[] movies = new MovieData[resultsJson.length()];

        for (int i = 0; i < resultsJson.length(); i++) {
            JSONObject movie = resultsJson.getJSONObject(i);
            String releaseDate = "";
        String voteAverage ="";
        String posterPath ="";
        String overview = "";
        String movieTitle = "";
        //apparently this one movie didn't have a 'release_date' entry and it would crash, so now I check if the entry exists first
            if (movie.has("release_date")) {releaseDate = movie.getString("release_date");}
            if (movie.has("vote_average")) {voteAverage = movie.getString("vote_average");}
            if (movie.has("poster_path")) {posterPath = movie.getString("poster_path");}
            if (movie.has("overview")) { overview = movie.getString("overview");}
            if (movie.has("title")) { movieTitle = movie.getString("title");}
            movies[i] = new MovieData(releaseDate, voteAverage, posterPath, overview, movieTitle);

        }
        return movies;
    }
}