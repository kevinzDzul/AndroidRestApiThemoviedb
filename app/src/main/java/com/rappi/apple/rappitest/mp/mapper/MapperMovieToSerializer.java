package com.rappi.apple.rappitest.mp.mapper;

import com.rappi.apple.rappitest.mp.model.MovieUI;
import com.rappi.apple.rappitest.ui.activity.serializable.MovieSerializer;

public class MapperMovieToSerializer {

    private  final MovieUI movieUI;

    public MapperMovieToSerializer(MovieUI movieUI) {
        this.movieUI = movieUI;
    }



    public MovieSerializer getMovieSerialiler(){

        MovieSerializer movieSerializer = new MovieSerializer(
                movieUI.popularity,
                movieUI.voteCount,
                movieUI.posterPath,
                movieUI.id,
                movieUI.backdropPath,
                movieUI.originalLanguage,
                movieUI.originalTitle,
                movieUI.title,
                movieUI.voteAverage,
                movieUI.overview,
                movieUI.releaseDate,
                movieUI.video
        );

        return movieSerializer;
    }
}
