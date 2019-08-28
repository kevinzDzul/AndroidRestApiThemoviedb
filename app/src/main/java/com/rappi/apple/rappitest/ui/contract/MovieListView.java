package com.rappi.apple.rappitest.ui.contract;

import java.util.List;

public interface MovieListView<T>  extends LoadDataView {
    void renderMoviesList(List<T> albums);
}

