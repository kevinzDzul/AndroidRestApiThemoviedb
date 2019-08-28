package com.rappi.apple.rappitest.datasource;

import com.rappi.apple.rappitest.datasource.cache.MovieCache;
import com.rappi.apple.rappitest.datasource.model.PopularMovieResponse;
import com.rappi.apple.rappitest.datasource.model.TopRateMovieResponse;
import com.rappi.apple.rappitest.datasource.model.UpcomingMovieResponse;

import java.util.List;

import io.reactivex.Observable;

public class MovieLocalStorage implements MoviesDataStore {

    private final MovieCache movieCache;

    public MovieLocalStorage(MovieCache movieCache) {
        this.movieCache = movieCache;
    }

    @Override
    public Observable<PopularMovieResponse> popularListMovies() {
        return movieCache.getPopularMovies();
    }

    @Override
    public Observable<TopRateMovieResponse> rateListMovies() {
        return movieCache.getTopRateMovies();
    }

    @Override
    public Observable<UpcomingMovieResponse> upcomingListMovies() {
        return movieCache.getUpcomingMovies();
    }
}
