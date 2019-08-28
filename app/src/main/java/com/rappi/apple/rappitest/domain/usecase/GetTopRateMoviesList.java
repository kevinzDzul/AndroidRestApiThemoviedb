package com.rappi.apple.rappitest.domain.usecase;

import com.rappi.apple.rappitest.domain.MovieRepository;
import com.rappi.apple.rappitest.domain.model.TopRateMoviesModel;

import java.util.List;

import io.reactivex.Observable;

public class GetTopRateMoviesList extends MovieUseCase<TopRateMoviesModel,Void> {

    private final MovieRepository movieRepository;

    public GetTopRateMoviesList(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    Observable<TopRateMoviesModel> buildUseCaseObservable(Void aVoid) {
        return movieRepository.getTopMovies();
    }
}
