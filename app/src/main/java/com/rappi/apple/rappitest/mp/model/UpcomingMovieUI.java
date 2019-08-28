package com.rappi.apple.rappitest.mp.model;

import java.util.List;

public class UpcomingMovieUI {

    public String  dateInit;
    public String  dateFinish;
    public List<MovieUI> movieUIList;

    public UpcomingMovieUI(String dateInit, String dateFinish, List<MovieUI> movieUIList) {
        this.dateInit = dateInit;
        this.dateFinish = dateFinish;
        this.movieUIList = movieUIList;
    }
}
