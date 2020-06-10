package com.example.android.project2popularmoviesstage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FetchMovieTask().execute("popular");
    }

    public class FetchMovieTask extends AsyncTask<String, Void, MovieData[]> {

       /* @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }*/

        @Override
        protected MovieData[] doInBackground(String... params) {

            if (params.length == 0) {
                return null;
            }

            URL movieRequestUrl = NetworkUtils.buildUrl("popular");//change this to variable that selects between sort by popular or sort by rating

            try {
                String jsonResponse = NetworkUtils
                        .getResponseFromHttpUrl(movieRequestUrl);

                MovieData[] simpleJsonMovieData = tmdbJsonUtils
                        .getMovieDataOBJFromJson(MainActivity.this, jsonResponse);

                return simpleJsonMovieData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

/*        @Override
        protected void onPostExecute(String[] weatherData) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if (weatherData != null) {
                showWeatherDataView();
                mForecastAdapter.setWeatherData(weatherData);
            } else {
                showErrorMessage();
            }
        }*/
    }
}
