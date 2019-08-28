package com.rappi.apple.rappitest.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.rappi.apple.rappitest.R;
import com.rappi.apple.rappitest.datasource.MovieDataStoreFactory;
import com.rappi.apple.rappitest.datasource.cache.MovieCache;
import com.rappi.apple.rappitest.datasource.cache.MovieCacheImpl;
import com.rappi.apple.rappitest.domain.usecase.GetPopularMoviesList;
import com.rappi.apple.rappitest.domain.usecase.GetTopRateMoviesList;
import com.rappi.apple.rappitest.domain.usecase.GetUpcomingMovieList;
import com.rappi.apple.rappitest.mp.mapper.MapperMovieToSerializer;
import com.rappi.apple.rappitest.mp.mapper.MapperPopularMovieUI;
import com.rappi.apple.rappitest.mp.mapper.MapperTopMovieUI;
import com.rappi.apple.rappitest.mp.mapper.MapperUpcomingMovieUI;
import com.rappi.apple.rappitest.mp.model.MovieUI;
import com.rappi.apple.rappitest.mp.presenter.categoryPresenter.MoviesPresenter;
import com.rappi.apple.rappitest.repository.MovieRepositoryImpl;
import com.rappi.apple.rappitest.repository.mapper.MapperPopularMovie;
import com.rappi.apple.rappitest.repository.mapper.MapperTopMovie;
import com.rappi.apple.rappitest.repository.mapper.MapperUpcommingMovie;
import com.rappi.apple.rappitest.ui.adapter.MovieListAdapter;
import com.rappi.apple.rappitest.ui.contract.MovieListView;
import com.rappi.apple.rappitest.ui.contract.SelectItemList;

import java.util.List;

import butterknife.BindView;

public class MovieListActivity extends BaseActivity implements
        MovieListView,
        SelectItemList<MovieUI>{


    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.listMovies)
    RecyclerView recyclerView;
    @BindView(R.id.error)
    TextView error;

    public MovieListActivity() {
    }


    private MoviesPresenter moviesPresenter;//refactror


    private GetUpcomingMovieList getUpcomingMovieList;
    private GetTopRateMoviesList getTopRateMoviesList;
    private GetPopularMoviesList getPopularMoviesList;

    private MapperUpcomingMovieUI mapperUpcomingMovieUI;
    private MapperTopMovieUI mapperTopMovieUI;
    private MapperPopularMovieUI mapperPopularMovieUI;

    private MovieRepositoryImpl movieRepository;

    private MapperUpcommingMovie mapperUpcommingMovie;
    private MapperTopMovie mapperTopMovie;
    private MapperPopularMovie mapperPopularMovie;

    private MovieDataStoreFactory movieDataStoreFactory;
    private MovieCache movieCache;



    MovieListAdapter movieListAdapter;

    @Override
    public int getContentLayout() {
        return R.layout.activity_movie_list;
    }

    @Override
    public void initComponents() {

        movieListAdapter = new MovieListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        recyclerView.setAdapter(movieListAdapter);

        /*mappers**/
        mapperUpcomingMovieUI = new MapperUpcomingMovieUI();
        mapperUpcommingMovie = new MapperUpcommingMovie();

        mapperPopularMovieUI = new MapperPopularMovieUI();
        mapperPopularMovie = new MapperPopularMovie();

        mapperTopMovieUI = new MapperTopMovieUI();
        mapperTopMovie = new MapperTopMovie();
        /* * */

        movieCache = new MovieCacheImpl();
        movieDataStoreFactory = new MovieDataStoreFactory(movieCache);
        movieRepository = new MovieRepositoryImpl(
                movieDataStoreFactory,
                mapperPopularMovie,
                mapperTopMovie,
                mapperUpcommingMovie
                );

        getUpcomingMovieList = new GetUpcomingMovieList(movieRepository);
        getTopRateMoviesList = new GetTopRateMoviesList(movieRepository);
        getPopularMoviesList = new GetPopularMoviesList(movieRepository);

        moviesPresenter = new MoviesPresenter(
                getUpcomingMovieList,
                mapperUpcomingMovieUI,
                getPopularMoviesList,
                mapperPopularMovieUI,
                getTopRateMoviesList,
                mapperTopMovieUI,
                this);
        moviesPresenter.setUpcominListView(this);



        Intent intent = getIntent();
        int idCategory = intent.getIntExtra("CATEGORY",0);
        moviesPresenter.init(idCategory);

    }

    @Override
    public void renderMoviesList(List movies) {
        movieListAdapter.setmovieUIList(movies);
    }



    @Override
    public void showLoading() {
        recyclerView.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        recyclerView.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        recyclerView.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        error.setVisibility(View.VISIBLE);
        error.setText(errorMessage);
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onitemClick(MovieUI object) {

        Intent send = new Intent(this,DetailActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("serialzable",new MapperMovieToSerializer(object).getMovieSerialiler());
        send.putExtras(b);
        startActivity(send);

    }

    @Override
    protected void onResume() {
        super.onResume();
        moviesPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        moviesPresenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moviesPresenter.destroy();
    }
}
