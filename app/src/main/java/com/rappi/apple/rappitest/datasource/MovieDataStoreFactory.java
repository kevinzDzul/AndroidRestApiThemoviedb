package com.rappi.apple.rappitest.datasource;

import com.rappi.apple.rappitest.datasource.cache.MovieCache;

public class MovieDataStoreFactory {
    private final MovieCache movieCache;

    public MovieDataStoreFactory(MovieCache movieCache){
        this.movieCache = movieCache;
    }

    public MoviesDataStore create(){
        if(!movieCache.isExpired() && movieCache.isCached()){
            return new MovieLocalStorage(movieCache);
        }else{
            return new MoviesCloundDataStorage(movieCache);
        }
    }


}
