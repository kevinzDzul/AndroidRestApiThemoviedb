package com.rappi.apple.rappitest.repository;

import com.rappi.apple.rappitest.datasource.MovieDataStoreFactory;
import com.rappi.apple.rappitest.datasource.model.PopularMovieResponse;
import com.rappi.apple.rappitest.datasource.model.TopRateMovieResponse;
import com.rappi.apple.rappitest.datasource.model.UpcomingMovieResponse;
import com.rappi.apple.rappitest.domain.MovieRepository;
import com.rappi.apple.rappitest.domain.model.PopularMoviesModel;
import com.rappi.apple.rappitest.domain.model.TopRateMoviesModel;
import com.rappi.apple.rappitest.domain.model.UpcomingMoviesModel;
import com.rappi.apple.rappitest.repository.mapper.MapperPopularMovie;
import com.rappi.apple.rappitest.repository.mapper.MapperTopMovie;
import com.rappi.apple.rappitest.repository.mapper.MapperUpcommingMovie;



import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MovieRepositoryImpl implements MovieRepository{

    private final MovieDataStoreFactory movieDataStoreFactory;
    private final MapperPopularMovie mapperPopularMovie;
    private final MapperTopMovie mapperTopMovie;
    private final MapperUpcommingMovie mapperUpcommingMovie;

    public MovieRepositoryImpl(MovieDataStoreFactory movieDataStoreFactory,
                               MapperPopularMovie mapperPopularMovie,
                               MapperTopMovie mapperTopMovie,
                               MapperUpcommingMovie mapperUpcommingMovie) {
        this.movieDataStoreFactory = movieDataStoreFactory;
        this.mapperPopularMovie = mapperPopularMovie;
        this.mapperTopMovie = mapperTopMovie;
        this.mapperUpcommingMovie = mapperUpcommingMovie;
    }

    @Override
    public Observable<TopRateMoviesModel> getTopMovies() {
        return movieDataStoreFactory.create().rateListMovies().map(new Function<TopRateMovieResponse, TopRateMoviesModel>() {
            @Override
            public TopRateMoviesModel apply(TopRateMovieResponse topRateMovieResponse) throws Exception {
                return mapperTopMovie.mapFrom(topRateMovieResponse);
            }
        });
    }

    @Override
    public Observable<PopularMoviesModel> getPopularMovies() {
        return movieDataStoreFactory.create().popularListMovies().map(new Function<PopularMovieResponse, PopularMoviesModel>() {
            @Override
            public PopularMoviesModel apply(PopularMovieResponse popularMovieResponse) throws Exception {
                return mapperPopularMovie.mapFrom(popularMovieResponse);
            }
        });
    }

    @Override
    public Observable<UpcomingMoviesModel> getUpcomingMovies() {
        return movieDataStoreFactory.create().upcomingListMovies().map(new Function<UpcomingMovieResponse, UpcomingMoviesModel>() {
            @Override
            public UpcomingMoviesModel apply(UpcomingMovieResponse upcomingMovieResponse) throws Exception {
                return mapperUpcommingMovie.mapFrom(upcomingMovieResponse);
            }
        });
    }
}
