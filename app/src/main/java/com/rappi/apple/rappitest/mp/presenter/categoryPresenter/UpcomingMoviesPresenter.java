package com.rappi.apple.rappitest.mp.presenter.categoryPresenter;

import android.content.Context;
import android.util.Log;

import com.rappi.apple.rappitest.domain.DefaultObserver;
import com.rappi.apple.rappitest.domain.model.PopularMoviesModel;
import com.rappi.apple.rappitest.domain.model.TopRateMoviesModel;
import com.rappi.apple.rappitest.domain.model.UpcomingMoviesModel;
import com.rappi.apple.rappitest.domain.usecase.GetPopularMoviesList;
import com.rappi.apple.rappitest.domain.usecase.GetTopRateMoviesList;
import com.rappi.apple.rappitest.domain.usecase.GetUpcomingMovieList;
import com.rappi.apple.rappitest.mp.mapper.MapperPopularMovieUI;
import com.rappi.apple.rappitest.mp.mapper.MapperTopMovieUI;
import com.rappi.apple.rappitest.mp.mapper.MapperUpcomingMovieUI;
import com.rappi.apple.rappitest.mp.model.PopularMovieUI;
import com.rappi.apple.rappitest.mp.model.TopMovieUI;
import com.rappi.apple.rappitest.mp.model.UpcomingMovieUI;
import com.rappi.apple.rappitest.mp.presenter.Presenter;
import com.rappi.apple.rappitest.ui.contract.MovieListView;

public class UpcomingMoviesPresenter  implements Presenter{


    private MovieListView movieListView;

    private final GetUpcomingMovieList getUpcomingMovieList;
    private final MapperUpcomingMovieUI mapperUpcomingMovieUI;

    private final GetPopularMoviesList getPopularMoviesList;
    private final MapperPopularMovieUI mapperPopularMovieUI;

    private final GetTopRateMoviesList getTopRateMoviesList;
    private final MapperTopMovieUI mapperTopMovieUI;

    private final Context context;

    public UpcomingMoviesPresenter(
            GetUpcomingMovieList getUpcomingMovieList,
            MapperUpcomingMovieUI mapperUpcommingMovieUI,

            GetPopularMoviesList getPopularMoviesList,
            MapperPopularMovieUI mapperPopularMovieUI,


            GetTopRateMoviesList getTopRateMoviesList,
            MapperTopMovieUI mapperTopMovieUI,

            Context context

    ) {
        this.getUpcomingMovieList = getUpcomingMovieList;
        this.mapperUpcomingMovieUI = mapperUpcommingMovieUI;

        this.getPopularMoviesList = getPopularMoviesList;
        this.mapperPopularMovieUI = mapperPopularMovieUI;

        this.getTopRateMoviesList  = getTopRateMoviesList;
        this.mapperTopMovieUI = mapperTopMovieUI;

        this.context = context;
    }

    public void init(int TypeCategoty){

        switch (TypeCategoty){

            case 0:
                loadPopularMovieList();
                break;

            case 1:
                loadTopMovieList();
                break;

            case 2:
                loadUpcomingMovieList();
                break;


                default:
            break;
        }
    }


    public void setUpcominListView(MovieListView movieListView){
        this.movieListView = movieListView;
    }

    private void loadUpcomingMovieList(){
        this.showViewLoading();
        this.getUpcomingMovieList();
    }
    private void loadTopMovieList(){
        this.showViewLoading();
        this.getTopRateMovieList();
    }
    private void loadPopularMovieList(){
        this.showViewLoading();
        this.getPopularListMovies();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
    @Override
    public void destroy() {
        this.getUpcomingMovieList.dispose();
        this.movieListView = null;
    }

    private void showViewLoading(){
        this.movieListView.showLoading();
    }

    private void hideViewLoading(){
        this.movieListView.hideLoading();
    }

    private void showErrorMessage(String errorMessage){
        this.movieListView.showError(errorMessage);
    }

    private void showUpcomingLostInView(UpcomingMoviesModel upcomingMoviesModels){
        final UpcomingMovieUI upcomingMovieUIS =
                this.mapperUpcomingMovieUI.mapFrom(upcomingMoviesModels);
        this.movieListView.renderMoviesList(upcomingMovieUIS.movieUIList);
    }

    private void showTopMoviesInView(TopRateMoviesModel topRateMoviesModel){
        final TopMovieUI topRateMoviesModel1 =
                this.mapperTopMovieUI.mapFrom(topRateMoviesModel);
        this.movieListView.renderMoviesList(topRateMoviesModel1.movieUIList);
    }
    private void showUPopularInView(PopularMoviesModel popularMoviesModel){
        final PopularMovieUI popularMovieUI =
                this.mapperPopularMovieUI.mapFrom(popularMoviesModel);
        this.movieListView.renderMoviesList(popularMovieUI.movieUIList);
    }


    private void getUpcomingMovieList(){
        this.getUpcomingMovieList.execute(new MoviesUpcomingListObserver(),null);
    }

    private void getTopRateMovieList(){
        this.getTopRateMoviesList.execute(new MoviesTopListObserver(),null);
    }


    private void getPopularListMovies(){
        this.getPopularMoviesList.execute(new MoviesPopularListObserver(),null);
    }



    ////Class observer to result **refactor

    private final class MoviesUpcomingListObserver extends DefaultObserver<UpcomingMoviesModel> {

        @Override public void onComplete() {
            hideViewLoading();
        }

        @Override public void onError(Throwable e) {
            e.printStackTrace();
            hideViewLoading();
            showErrorMessage(e.getLocalizedMessage());
        }

        @Override public void onNext(UpcomingMoviesModel upcomingMoviesModel) {
            showUpcomingLostInView(upcomingMoviesModel);
        }
    }
    private final class MoviesTopListObserver extends DefaultObserver<TopRateMoviesModel> {

        @Override public void onComplete() {
            hideViewLoading();
        }

        @Override public void onError(Throwable e) {
            e.printStackTrace();
            hideViewLoading();
            showErrorMessage(e.getLocalizedMessage());
        }

        @Override public void onNext(TopRateMoviesModel topRateMoviesModel) {
            showTopMoviesInView(topRateMoviesModel);
        }
    }
    private final class MoviesPopularListObserver extends DefaultObserver<PopularMoviesModel> {

        @Override public void onComplete() {
            hideViewLoading();
        }

        @Override public void onError(Throwable e) {
            e.printStackTrace();
            hideViewLoading();
            showErrorMessage(e.getLocalizedMessage());
        }

        @Override public void onNext(PopularMoviesModel popularMoviesModel) {
            showUPopularInView(popularMoviesModel);
        }
    }
}
