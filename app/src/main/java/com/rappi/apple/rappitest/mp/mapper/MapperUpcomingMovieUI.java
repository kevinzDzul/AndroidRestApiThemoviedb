package com.rappi.apple.rappitest.mp.mapper;

import com.rappi.apple.rappitest.commons.BaseMapper;
import com.rappi.apple.rappitest.domain.model.MovieModel;
import com.rappi.apple.rappitest.domain.model.UpcomingMoviesModel;
import com.rappi.apple.rappitest.mp.model.MovieUI;
import com.rappi.apple.rappitest.mp.model.UpcomingMovieUI;

import java.util.ArrayList;
import java.util.List;

public class MapperUpcomingMovieUI implements BaseMapper<UpcomingMoviesModel, UpcomingMovieUI> {

    public MapperUpcomingMovieUI() {
    }

    @Override
    public UpcomingMovieUI mapFrom(UpcomingMoviesModel response) {
        List<MovieUI> upcominMovieUIList = new ArrayList<>(0);

        for( MovieModel movieModel : response.movieModelList ){

            upcominMovieUIList.add(new MovieUI(
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

        return new UpcomingMovieUI(
                response.dateInit,
                response.dateFinish,
                upcominMovieUIList
                );
    }
    
}
