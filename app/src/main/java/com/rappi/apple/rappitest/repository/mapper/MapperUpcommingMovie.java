package com.rappi.apple.rappitest.repository.mapper;

import com.rappi.apple.rappitest.commons.BaseMapper;
import com.rappi.apple.rappitest.datasource.model.MovieResult;
import com.rappi.apple.rappitest.datasource.model.UpcomingMovieResponse;
import com.rappi.apple.rappitest.domain.model.MovieModel;
import com.rappi.apple.rappitest.domain.model.TopRateMoviesModel;
import com.rappi.apple.rappitest.domain.model.UpcomingMoviesModel;

import java.util.ArrayList;
import java.util.List;

public class MapperUpcommingMovie implements BaseMapper<UpcomingMovieResponse,UpcomingMoviesModel> {


    public MapperUpcommingMovie() {
    }

    @Override
    public UpcomingMoviesModel mapFrom(UpcomingMovieResponse response) {
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

        UpcomingMoviesModel newDataModel = new UpcomingMoviesModel(
                response.getDates().getMinimum(),
                response.getDates().getMaximum(),
                response.getPage(),
                response.getTotalResults(),
                response.getTotalPages(),
                movieModels

        );
        return newDataModel;
    }
}
