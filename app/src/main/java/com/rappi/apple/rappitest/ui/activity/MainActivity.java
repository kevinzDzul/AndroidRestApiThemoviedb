package com.rappi.apple.rappitest.ui.activity;



import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.rappi.apple.rappitest.R;
import com.rappi.apple.rappitest.ui.adapter.CategoryAdapter;
import com.rappi.apple.rappitest.ui.contract.SelectItemList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements SelectItemList<Integer> {

    @BindView(R.id.listCategory)
    RecyclerView listCategory;
    private String[] categories = {"Popular Movies", "Top Rate Movies", "Upcoming Movies"};

    public MainActivity() {
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initComponents() {


        listCategory.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listCategory.setLayoutManager(layoutManager);
        CategoryAdapter mAdapter = new CategoryAdapter(categories,this);
        listCategory.setAdapter(mAdapter);

    }

    @Override
    public void onitemClick(Integer categoryId) {

        Intent intent = new Intent(this, MovieListActivity.class);
        intent.putExtra("CATEGORY", categoryId);
        startActivity(intent);
    }
}
