package com.rappi.apple.rappitest.datasource.retrofit;

import com.rappi.apple.rappitest.datasource.model.PopularMovieResponse;
import com.rappi.apple.rappitest.datasource.model.TopRateMovieResponse;
import com.rappi.apple.rappitest.datasource.model.UpcomingMovieResponse;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Observable<PopularMovieResponse> getAllPopularMovies(@Query("page") int page, @Query("api_key") String userkey);
    @GET("movie/top_rated")
    Observable<TopRateMovieResponse> getAllTopMovies(@Query("page") int page, @Query("api_key") String userkey);
    @GET("movie/upcoming")
    Observable<UpcomingMovieResponse> getAllUpcomingMovies(@Query("page") int page, @Query("api_key") String userkey);
}
