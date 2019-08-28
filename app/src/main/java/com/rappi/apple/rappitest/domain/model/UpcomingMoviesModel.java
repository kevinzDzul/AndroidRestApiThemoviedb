package com.rappi.apple.rappitest.domain.model;

import java.util.List;

public class UpcomingMoviesModel {

   public String  dateInit;
   public String  dateFinish;
    public Integer page;
    public Integer totalResults;
   public  Integer totalPages;
   public List<MovieModel> movieModelList;

    public UpcomingMoviesModel(String dateInit, String dateFinish, Integer page, Integer totalResults, Integer totalPages, List<MovieModel> movieModelList) {
        this.dateInit = dateInit;
        this.dateFinish = dateFinish;
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.movieModelList = movieModelList;
    }
}
