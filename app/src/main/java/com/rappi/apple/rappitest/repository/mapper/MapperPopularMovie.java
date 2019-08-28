package com.rappi.apple.rappitest.repository.mapper;

import com.rappi.apple.rappitest.commons.BaseMapper;
import com.rappi.apple.rappitest.datasource.model.MovieResult;
import com.rappi.apple.rappitest.datasource.model.PopularMovieResponse;
import com.rappi.apple.rappitest.domain.model.MovieModel;
import com.rappi.apple.rappitest.domain.model.PopularMoviesModel;

import java.util.ArrayList;
import java.util.List;

public class MapperPopularMovie implements BaseMapper<PopularMovieResponse,PopularMoviesModel> {

    public MapperPopularMovie() {
    }

    @Override
    public PopularMoviesModel mapFrom(PopularMovieResponse response) {
        List<MovieModel> movieModels = new ArrayList<>(0);

        for(MovieResult movieResult : response.getResults()){
            movieModels.add(
                    new MovieModel(
                            movieResult.getPopularity(),
                            movieResult.getVoteCount(),
                            movieResult.getPosterPath(),
                            movieResult.getId(),
                            movieResult.getAdult(),
                            movieResult.getBackdropPath(),
                            movieResult.getOriginalLanguage(),
                            movieResult.getOriginalTitle(),
                            movieResult.getTitle(),
                            movieResult.getVoteAverage(),
                            movieResult.getOverview(),
                            movieResult.getReleaseDate(),
                            movieResult.getVideo()
                    )
            );
        }

        PopularMoviesModel newDataModel = new PopularMoviesModel(
                response.getPage(),
                response.getTotalResults(),
                response.getTotalPages(),
                movieModels
        );
        return newDataModel;
    }
}
