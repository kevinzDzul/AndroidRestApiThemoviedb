package com.rappi.apple.rappitest.datasource;

import com.rappi.apple.rappitest.datasource.cache.MovieCache;
import com.rappi.apple.rappitest.datasource.model.PopularMovieResponse;
import com.rappi.apple.rappitest.datasource.model.TopRateMovieResponse;
import com.rappi.apple.rappitest.datasource.model.UpcomingMovieResponse;
import com.rappi.apple.rappitest.datasource.retrofit.MovieApiService;
import com.rappi.apple.rappitest.datasource.retrofit.RetrofitInstance;


import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MoviesCloundDataStorage  implements MoviesDataStore{


    private final MovieCache movieCache;

    public MoviesCloundDataStorage(MovieCache movieCache) {
        this.movieCache = movieCache;
    }

    @Override
    public Observable<PopularMovieResponse> popularListMovies() {
        MovieApiService popularMovieService = RetrofitInstance.getRetrofitInstance().create(MovieApiService.class);
        return popularMovieService.getAllPopularMovies(1,"60a8a6574135b8eaee8c85e8e72500e2").doOnNext(new Consumer<PopularMovieResponse>() {
            @Override
            public void accept(PopularMovieResponse popularMovieResponses) throws Exception {
                movieCache.putPopularMovies(popularMovieResponses);
            }
        });
    }

    @Override
    public Observable<TopRateMovieResponse> rateListMovies() {
        MovieApiService topMovieService = RetrofitInstance.getRetrofitInstance().create(MovieApiService.class);
        return topMovieService.getAllTopMovies(1,"60a8a6574135b8eaee8c85e8e72500e2").doOnNext(new Consumer<TopRateMovieResponse>() {
            @Override
            public void accept(TopRateMovieResponse topRateMovieResponses) throws Exception {
                movieCache.putTopRateMovies(topRateMovieResponses);
            }
        });
    }

    @Override
    public Observable<UpcomingMovieResponse> upcomingListMovies() {
        MovieApiService upcomingMovieService = RetrofitInstance.getRetrofitInstance().create(MovieApiService.class);

        return upcomingMovieService.getAllUpcomingMovies(1,"60a8a6574135b8eaee8c85e8e72500e2").doOnNext(new Consumer<UpcomingMovieResponse>() {
            @Override
            public void accept(UpcomingMovieResponse upcomingMovieResponses) throws Exception {
                movieCache.putUpcomingMovies(upcomingMovieResponses);
            }
        });
    }
}
