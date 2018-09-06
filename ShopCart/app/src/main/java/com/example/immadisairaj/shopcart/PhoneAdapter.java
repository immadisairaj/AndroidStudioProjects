package com.example.immadisairaj.shopcart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder> {

    private List<Phone> phoneList;

    public PhoneAdapter(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public class PhoneViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_phone)
        ImageView imageView;
        @BindView(R.id.tv_model)
        TextView model;
        @BindView(R.id.tv_manufacturer)
        TextView manufacturer;
        @BindView(R.id.tv_price)
        TextView price;

        public PhoneViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycle_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Glide.with(holder.imageView.getContext()).load(phoneList.get(position).getImage()).into(holder.imageView);
        holder.model.setText(phoneList.get(position).getModel());
        holder.manufacturer.setText(phoneList.get(position).getManufacturer());
        holder.price.setText("₹" + phoneList.get(position).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }
}
