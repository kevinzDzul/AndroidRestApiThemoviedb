package com.rappi.apple.rappitest.ui.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rappi.apple.rappitest.R;
import com.rappi.apple.rappitest.mp.model.MovieUI;
import com.rappi.apple.rappitest.ui.contract.SelectItemList;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    ImageView albumImage;
    TextView title;
    TextView detail;

        public MoviesViewHolder(View itemView) {
            super(itemView);

             albumImage = (ImageView)itemView.findViewById(R.id.item_prev_movies);
             title = (TextView) itemView.findViewById(R.id.item_title_movie);
             detail = (TextView)itemView.findViewById(R.id.item_detail);


        }

        public void bind(MovieUI movieUI, final SelectItemList selectItemList ){
            title.setText(movieUI.title);
            detail.setText(movieUI.originalLanguage);
            Glide.with(itemView)
                    .load(movieImagePathBuilder(movieUI.posterPath))
                    .into(albumImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("e",movieUI.posterPath);
                    selectItemList.onitemClick(movieUI);
                }
            });
        }


    public static String movieImagePathBuilder(String imagePath) {
        return "https://image.tmdb.org/t/p/" +
                "w500" +
                imagePath;
    }




}

