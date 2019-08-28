package com.rappi.apple.rappitest.mp.mapper;

import android.util.Log;

import com.rappi.apple.rappitest.commons.BaseMapper;
import com.rappi.apple.rappitest.domain.model.MovieModel;
import com.rappi.apple.rappitest.domain.model.TopRateMoviesModel;
import com.rappi.apple.rappitest.mp.model.MovieUI;
import com.rappi.apple.rappitest.mp.model.TopMovieUI;

import java.util.ArrayList;
import java.util.List;

public class MapperTopMovieUI implements BaseMapper<TopRateMoviesModel,TopMovieUI> {

    public MapperTopMovieUI() {
    }

    @Override
    public TopMovieUI mapFrom(TopRateMoviesModel response) {

        List<MovieUI> topMovieUIList = new ArrayList<>(0);

        for( MovieModel movieModel : response.movieModelList ){

            topMovieUIList.add(new MovieUI(
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

        Log.e("e",topMovieUIList.size()+"");
        return new TopMovieUI(topMovieUIList);
    }
}
