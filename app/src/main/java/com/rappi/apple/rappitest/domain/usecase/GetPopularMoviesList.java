package com.rappi.apple.rappitest.domain.usecase;

import com.rappi.apple.rappitest.domain.MovieRepository;
import com.rappi.apple.rappitest.domain.model.PopularMoviesModel;

import java.util.List;

import io.reactivex.Observable;

public class GetPopularMoviesList extends MovieUseCase<PopularMoviesModel,Void>{

    private final MovieRepository movieRepository;

    public GetPopularMoviesList(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    Observable<PopularMoviesModel> buildUseCaseObservable(Void aVoid) {
        return movieRepository.getPopularMovies();
    }
}
