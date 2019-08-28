package com.rappi.apple.rappitest.datasource;

import com.rappi.apple.rappitest.datasource.model.PopularMovieResponse;
import com.rappi.apple.rappitest.datasource.model.TopRateMovieResponse;
import com.rappi.apple.rappitest.datasource.model.UpcomingMovieResponse;



import io.reactivex.Observable;

public interface MoviesDataStore {
     Observable<PopularMovieResponse> popularListMovies();
    Observable<TopRateMovieResponse> rateListMovies();
    Observable<UpcomingMovieResponse> upcomingListMovies();
}
