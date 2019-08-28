package com.rappi.apple.rappitest.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {
    public BaseActivity(){
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        initComponents();
    }

    public abstract int getContentLayout();

    public abstract void initComponents();
}