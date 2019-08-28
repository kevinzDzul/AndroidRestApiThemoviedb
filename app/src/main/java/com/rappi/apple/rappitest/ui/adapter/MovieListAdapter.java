package com.rappi.apple.rappitest.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rappi.apple.rappitest.R;
import com.rappi.apple.rappitest.mp.model.MovieUI;
import com.rappi.apple.rappitest.ui.contract.SelectItemList;
import com.rappi.apple.rappitest.ui.viewHolder.MoviesViewHolder;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MoviesViewHolder> {
        List<MovieUI> movieUIList;


        private final SelectItemList selectItemList;


        public MovieListAdapter(SelectItemList selectItemList) {
            this.selectItemList = selectItemList;
        }

        @Override
        public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
            return new MoviesViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MoviesViewHolder holder, int position) {
            holder.bind(movieUIList.get(position),selectItemList);
        }
        @Override
        public int getItemCount() {
            return movieUIList!=null?movieUIList.size():0;
        }

        public void setmovieUIList(List<MovieUI> movieUIList){
            if(movieUIList == null){
                throw  new IllegalArgumentException("List can't be null");
            }
            this.movieUIList = movieUIList;
            notifyDataSetChanged();
        }


    }

