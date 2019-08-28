package com.rappi.apple.rappitest.domain;

import com.rappi.apple.rappitest.domain.model.PopularMoviesModel;
import com.rappi.apple.rappitest.domain.model.TopRateMoviesModel;
import com.rappi.apple.rappitest.domain.model.UpcomingMoviesModel;


import io.reactivex.Observable;

public interface MovieRepository {
    Observable<TopRateMoviesModel> getTopMovies();
    Observable<PopularMoviesModel> getPopularMovies();
    Observable<UpcomingMoviesModel> getUpcomingMovies();

}
