package com.example.immadisairaj.shopcart;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycle_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final PhoneViewHolder holder, int position) {
        Glide.with(holder.imageView.getContext()).load(phoneList.get(position).getImage()).into(holder.imageView);
        final String modelName = phoneList.get(position).getModel();
        holder.model.setText(modelName);
        holder.manufacturer.setText(phoneList.get(position).getManufacturer());
        holder.price.setText("₹" + phoneList.get(position).getPrice().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());

                LayoutInflater layoutInflater = LayoutInflater.from(holder.itemView.getContext());
                View dialogue = layoutInflater.inflate(R.layout.layout_dialogue, null);
                builder.setView(dialogue);

                final EditText username = dialogue.findViewById(R.id.et_username);
                final EditText quantity = dialogue.findViewById(R.id.et_quantity);

                builder.setTitle("Buy");
                builder.setMessage("Enter both the values to Buy");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String usernameText = username.getText().toString();
                        String quantityText = quantity.getText().toString();

                        if (!usernameText.equals("") && !quantityText.equals("")) {
                            ApiClient apiClient = new ApiClient();
                            Retrofit retrofit = apiClient.fetchApi();
                            ApiInterface api = retrofit.create(ApiInterface.class);
                            Call<Buy> call;
                            Integer quantityNumber = Integer.parseInt(quantityText);
                            call = api.getBuy(modelName, usernameText, quantityNumber);

                            call.enqueue(new Callback<Buy>() {
                                @Override
                                public void onResponse(Call<Buy> call, Response<Buy> response) {
                                    Log.v("url", call.request().url().toString());
                                    Toast.makeText(holder.itemView.getContext(), "Bought", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<Buy> call, Throwable t) {
                                    Toast.makeText(holder.itemView.getContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            dialog.dismiss();
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }
}
