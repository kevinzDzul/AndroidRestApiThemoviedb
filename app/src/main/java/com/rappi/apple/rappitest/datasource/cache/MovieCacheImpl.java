package com.rappi.apple.rappitest.datasource.cache;

import com.rappi.apple.rappitest.datasource.model.PopularMovieResponse;
import com.rappi.apple.rappitest.datasource.model.TopRateMovieResponse;
import com.rappi.apple.rappitest.datasource.model.UpcomingMovieResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.Sort;

public class MovieCacheImpl implements  MovieCache {

    private static final long EXPIRATION_TIME = 60 * 10 * 1000;

    @Override
    public boolean isExpired() {
        Realm realm = Realm.getDefaultInstance();
        if (realm.where(UpcomingMovieResponse.class).count() != 0) {
            Date currentTime = new Date(System.currentTimeMillis());
            SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
            Date lastUpdated = null;
            try {
                lastUpdated = ISO8601DATEFORMAT.parse("2019-11-30T19:45:09+00:00");
                boolean isExpired = currentTime.getTime() - lastUpdated.getTime() > EXPIRATION_TIME;
                if(isExpired){
                    realm.beginTransaction();
                    realm.delete(UpcomingMovieResponse.class);
                    realm.commitTransaction();
                }
                return isExpired;
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                realm.close();
            }
        }
        return false;
    }

    @Override
    public boolean isCached() {
        UpcomingMovieResponse upcomingMovies = getUpcommingEntityList();
        PopularMovieResponse popularMovieResponse = getPopularEntityList();
        TopRateMovieResponse topRateMovieResponse = getRateEntityList();

        boolean status = (upcomingMovies != null && upcomingMovies.getResults().size() > 0) &&
                (popularMovieResponse != null && popularMovieResponse.getResults().size() > 0) &&
                (topRateMovieResponse != null && topRateMovieResponse.getResults().size() > 0);
        return status;
    }


    @Override
    public Observable<PopularMovieResponse> getPopularMovies() {
        PopularMovieResponse popularMovieResponses = getPopularEntityList();
        return Observable.just(popularMovieResponses);
    }

    @Override
    public void putPopularMovies(PopularMovieResponse movieEntities) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(movieEntities);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public Observable<TopRateMovieResponse> getTopRateMovies() {
        TopRateMovieResponse topRateMovieResponses = getRateEntityList();
        return Observable.just(topRateMovieResponses);
    }

    @Override
    public void putTopRateMovies(TopRateMovieResponse movieEntities) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(movieEntities);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public Observable<UpcomingMovieResponse> getUpcomingMovies() {
        UpcomingMovieResponse upcomingMovieResponses = getUpcommingEntityList();
        return Observable.just(upcomingMovieResponses);
    }

    @Override
    public void putUpcomingMovies(UpcomingMovieResponse movieEntities) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(movieEntities);
        realm.commitTransaction();
        realm.close();
    }



    private PopularMovieResponse getPopularEntityList() {
        Realm realm = Realm.getDefaultInstance();
        /*PopularMovieResponse popularMovieResponses = realm.where(PopularMovieResponse.class).findFirst();
        realm.close();*/
        List<PopularMovieResponse> popularMovieResponses = realm.copyFromRealm(
                realm.where(PopularMovieResponse.class).findAll());
        return popularMovieResponses.size() > 0  ? popularMovieResponses.get(0) : null;
    }

    private TopRateMovieResponse getRateEntityList() {
        Realm realm = Realm.getDefaultInstance();
        //TopRateMovieResponse topRateMovieResponse = realm.where(TopRateMovieResponse.class).findFirst();

        List<TopRateMovieResponse> topRateMovieResponse = realm.copyFromRealm(
                realm.where(TopRateMovieResponse.class).findAll());
        realm.close();
        return topRateMovieResponse.size() > 0 ?  topRateMovieResponse.get(0) : null;
    }

    private UpcomingMovieResponse getUpcommingEntityList() {
        Realm realm = Realm.getDefaultInstance();
        //UpcomingMovieResponse upcomingMovieResponses = realm.where(UpcomingMovieResponse.class).findFirst();

        List<UpcomingMovieResponse> albumEntities = realm.copyFromRealm(
                realm.where(UpcomingMovieResponse.class).findAll());
        realm.close();
        return albumEntities.size() > 0 ?  albumEntities.get(0) : null;
    }
}
