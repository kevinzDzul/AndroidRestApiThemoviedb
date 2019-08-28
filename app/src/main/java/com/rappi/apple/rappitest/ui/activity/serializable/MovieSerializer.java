package com.rappi.apple.rappitest.ui.activity.serializable;

import java.io.Serializable;

public class MovieSerializer implements Serializable {

    public Double popularity;
    public Integer voteCount;
    public String posterPath;
    public Integer id;
    public String backdropPath;
    public String originalLanguage;
    public String originalTitle;
    public String title;
    public Double voteAverage;
    public String overview;
    public String releaseDate;
    public Boolean video;

    public MovieSerializer(Double popularity, Integer voteCount, String posterPath, Integer id, String backdropPath, String originalLanguage, String originalTitle, String title, Double voteAverage, String overview, String releaseDate, Boolean video) {
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.posterPath = posterPath;
        this.id = id;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.video = video;
    }
}
