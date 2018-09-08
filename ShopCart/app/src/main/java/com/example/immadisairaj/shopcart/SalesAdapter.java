package com.example.immadisairaj.shopcart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.SalesViewHolder> {
    private List<Sales> salesList;

    public SalesAdapter(List<Sales> salesList) {
        this.salesList = salesList;
    }

    public class SalesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvs_invoice)
        TextView invoice;
        @BindView(R.id.tvs_model)
        TextView model;
        @BindView(R.id.tvs_quantity)
        TextView quantity;
        @BindView(R.id.tvs_username)
        TextView username;

        public SalesViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public SalesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SalesAdapter.SalesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycle_sales, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SalesViewHolder holder, int position) {
        holder.invoice.setText("Invoice Number: " + salesList.get(position).getInvoiceNumber());
        holder.model.setText("Model: " + salesList.get(position).getModel());
        holder.quantity.setText("Quantity: " + salesList.get(position).getQuantity());
        holder.username.setText("Username: " + salesList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return salesList.size();
    }
}
