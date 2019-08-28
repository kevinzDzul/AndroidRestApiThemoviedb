package com.rappi.apple.rappitest.domain.model;


import java.util.List;

public class TopRateMoviesModel {
     public Integer page;
    public Integer totalResults;
    public Integer totalPages;
    public  List<MovieModel> movieModelList;

    public TopRateMoviesModel(Integer page, Integer totalResults, Integer totalPages, List<MovieModel> movieModelList) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.movieModelList = movieModelList;
    }
}
