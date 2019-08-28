package com.rappi.apple.rappitest.mp.mapper;

import com.rappi.apple.rappitest.commons.BaseMapper;
import com.rappi.apple.rappitest.domain.model.MovieModel;
import com.rappi.apple.rappitest.domain.model.PopularMoviesModel;
import com.rappi.apple.rappitest.mp.model.MovieUI;
import com.rappi.apple.rappitest.mp.model.PopularMovieUI;
import com.rappi.apple.rappitest.mp.model.TopMovieUI;

import java.util.ArrayList;
import java.util.List;

public class MapperPopularMovieUI implements BaseMapper<PopularMoviesModel,PopularMovieUI> {
    public MapperPopularMovieUI() {
    }

    @Override
    public PopularMovieUI mapFrom(PopularMoviesModel response) {
        List<MovieUI> popularlistmovies = new ArrayList<>(0);

        for( MovieModel movieModel : response.movieModelList ){

            popularlistmovies.add(new MovieUI(
                    movieModel.popularity,
                    movieModel.voteCount,
                    movieModel.posterPath,
                    movieModel.id,
                    movieModel.backdropPath,
                    movieModel.originalLanguage,
                    movieModel.originalTitle,
                    movieModel.title,
                    movieModel.voteAverage,
                    movieModel.overview,
                    movieModel.releaseDate,
                    movieModel.video
            ));
        }

        return new PopularMovieUI(popularlistmovies);
    }
}
