package com.rappi.apple.rappitest.ui.activity;


import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rappi.apple.rappitest.R;
import com.rappi.apple.rappitest.ui.activity.serializable.MovieSerializer;

import butterknife.BindView;

public class DetailActivity extends BaseActivity {



    @BindView(R.id.thumbnail)
    ImageView thumbnail;
    @BindView(R.id.title)
    TextView titleMovie;
    @BindView(R.id.detail_movie)
    TextView detalleMovie;


    @Override
    public int getContentLayout() {
        return R.layout.activity_detalle;
    }

    @Override
    public void initComponents() {



        MovieSerializer movieSerializer = (MovieSerializer) getIntent().getSerializableExtra("serialzable");

        Glide.with(this)
                .load(movieImagePathBuilder(movieSerializer.posterPath))
                .into(thumbnail);

        titleMovie.setText(movieSerializer.title);
        detalleMovie.setText(movieSerializer.overview);


    }


    /**refactor*/
    public static String movieImagePathBuilder(String imagePath) {
        return "https://image.tmdb.org/t/p/" +
                "w500" +
                imagePath;
    }


}
