package com.rappi.apple.rappitest.ui.contract;

import android.content.Context;

public interface LoadDataView {
    void showLoading();
    void hideLoading();
    void showError(String errorMessage);
    Context context();
}
