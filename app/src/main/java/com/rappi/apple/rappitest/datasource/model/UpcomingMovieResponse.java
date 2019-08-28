package com.rappi.apple.rappitest.datasource.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UpcomingMovieResponse extends RealmObject {
    @SerializedName("results")
    @Expose
    private RealmList<MovieResult> results = null;
    @PrimaryKey
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("dates")
    @Expose
    private DateExpirationMovies dates;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public RealmList<MovieResult> getResults() {
        return results;
    }

    public void setResults(RealmList<MovieResult> results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public DateExpirationMovies getDates() {
        return dates;
    }

    public void setDates(DateExpirationMovies dates) {
        this.dates = dates;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}
