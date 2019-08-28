package com.rappi.apple.rappitest.datasource.cache;

import com.rappi.apple.rappitest.datasource.model.PopularMovieResponse;
import com.rappi.apple.rappitest.datasource.model.TopRateMovieResponse;
import com.rappi.apple.rappitest.datasource.model.UpcomingMovieResponse;

import java.util.List;

import io.reactivex.Observable;

public interface MovieCache {
    boolean isExpired();
    boolean isCached();

    Observable<PopularMovieResponse> getPopularMovies();
    void putPopularMovies(PopularMovieResponse movieEntities);

    Observable<TopRateMovieResponse> getTopRateMovies();
    void putTopRateMovies(TopRateMovieResponse movieEntities);

    Observable<UpcomingMovieResponse> getUpcomingMovies();
    void putUpcomingMovies(UpcomingMovieResponse movieEntities);

}
