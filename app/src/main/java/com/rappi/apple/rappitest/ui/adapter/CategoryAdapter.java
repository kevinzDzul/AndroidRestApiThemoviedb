package com.rappi.apple.rappitest.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rappi.apple.rappitest.R;
import com.rappi.apple.rappitest.ui.contract.SelectItemList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
        private String[] mDataset;
        private SelectItemList selectItemList;

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.item_title_category)
            TextView titleCategory;

            public MyViewHolder(View v) {
                super(v);
                ButterKnife.bind(this, v);
            }


            public void bind(int position,String category ,final SelectItemList selectItemList ){

                titleCategory.setText(category);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        selectItemList.onitemClick(position);
                    }
                });
            }



}

        public CategoryAdapter(String[] myDataset, SelectItemList selectItemList) {
            mDataset = myDataset;
            this.selectItemList = selectItemList;
        }

        @Override
        public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {

            View v = (View) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_category, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bind(position,mDataset[position],selectItemList);



        }

        @Override
        public int getItemCount() {
            return mDataset.length;
        }

}
