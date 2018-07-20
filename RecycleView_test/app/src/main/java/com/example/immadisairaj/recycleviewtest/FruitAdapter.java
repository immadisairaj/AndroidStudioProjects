package com.example.immadisairaj.recycleviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private ArrayList<Fruit> fruitList;

    public FruitAdapter(ArrayList<Fruit> fruitsList) {
        fruitList = fruitsList;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FruitViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder fruitViewHolder, int i) {
        fruitViewHolder.fruitImage.setImageResource(fruitList.get(i).getImageId());
        fruitViewHolder.fruitName.setText(fruitList.get(i).getFruitName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    class FruitViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_fruit_image)
        ImageView fruitImage;

        @BindView(R.id.tv_fruit_name)
        TextView fruitName;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
