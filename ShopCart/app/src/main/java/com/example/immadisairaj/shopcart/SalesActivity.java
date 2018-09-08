package com.example.immadisairaj.shopcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SalesActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    View loadingIndicator;

    TextView mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        recyclerView = findViewById(R.id.rv_sales);

        loadingIndicator = findViewById(R.id.loading_indicator_sales);
        loadingIndicator.setVisibility(View.VISIBLE);

        mEmptyView = findViewById(R.id.empty_view_sales);

        ApiClient apiClient = new ApiClient();
        Retrofit retrofit = apiClient.fetchApi();
        ApiInterface api = retrofit.create(ApiInterface.class);
        Call<List<Sales>> call;

        call = api.getSales();

        call.enqueue(new Callback<List<Sales>>() {
            @Override
            public void onResponse(Call<List<Sales>> call, Response<List<Sales>> response) {
                Log.v("url", call.request().url().toString());

                List<Sales> sales = response.body();

                loadingIndicator.setVisibility(View.INVISIBLE);

                if (sales.isEmpty()) {
                    mEmptyView.setText("No Sales Available");
                    mEmptyView.setVisibility(View.VISIBLE);
                } else {
                    mEmptyView.setVisibility(View.INVISIBLE);
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                SalesAdapter salesAdapter = new SalesAdapter(sales);
                AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(salesAdapter);
                alphaAdapter.setDuration(1500);
                recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
            }

            @Override
            public void onFailure(Call<List<Sales>> call, Throwable t) {
                Log.v("url", "No Internet Connection");
                loadingIndicator.setVisibility(View.INVISIBLE);
                mEmptyView.setText("No Internet Connection");
                mEmptyView.setVisibility(View.VISIBLE);
            }
        });
    }
}
