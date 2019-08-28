package com.rappi.apple.rappitest.domain.usecase;

import com.rappi.apple.rappitest.domain.MovieRepository;
import com.rappi.apple.rappitest.domain.model.UpcomingMoviesModel;

import java.util.List;

import io.reactivex.Observable;

public class GetUpcomingMovieList extends MovieUseCase<UpcomingMoviesModel,Void> {

    private final MovieRepository movieRepository;

    public GetUpcomingMovieList(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    Observable<UpcomingMoviesModel> buildUseCaseObservable(Void aVoid) {
        return movieRepository.getUpcomingMovies();
    }
}
