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
package com.example.android.PopularMovies1;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.PopularMovies1.data.MovieData;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private MovieData[] mMovieDataList;

    /*
     * An on-click handler that we've defined to make it easy for an Activity to interface with
     * our RecyclerView
     */
    private final MovieAdapterOnClickHandler mClickHandler;

    public interface MovieAdapterOnClickHandler {
        void onClick(MovieData singleMovieData);
    }

    public MovieAdapter(MovieAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        public final ImageView mPosterImageViewForMainScreen;

        public MovieAdapterViewHolder(View view) {
            super(view);
            mPosterImageViewForMainScreen = (ImageView) view.findViewById(R.id.iv_main_screen_poster);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            MovieData singleMovieDataItem = mMovieDataList[adapterPosition];
            mClickHandler.onClick(singleMovieDataItem);
        }
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.main_screen_poster_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapterViewHolder movieAdapterViewHolder, int position) {
        MovieData singleMovieDataItem = mMovieDataList[position];
        Uri builder = Uri.parse("http://image.tmdb.org/t/p/w500/").buildUpon()
                .appendEncodedPath(singleMovieDataItem.getPosterPath())
                .build();
        Picasso.get().load(builder).into(movieAdapterViewHolder.mPosterImageViewForMainScreen);

    }

    @Override
    public int getItemCount() {
        if (null == mMovieDataList) return 0;
        return mMovieDataList.length;
    }

    public void setMovieData(MovieData[] movieData) {
        mMovieDataList = movieData;
        notifyDataSetChanged();
    }
}