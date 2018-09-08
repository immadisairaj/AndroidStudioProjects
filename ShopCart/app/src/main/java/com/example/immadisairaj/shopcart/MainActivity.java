package com.example.immadisairaj.shopcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    View loadingIndicator;

    TextView mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_phone);

        loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.VISIBLE);

        mEmptyView = findViewById(R.id.empty_view);

        Bundle bundle = getIntent().getExtras();

        ApiClient apiClient = new ApiClient();
        Retrofit retrofit = apiClient.fetchApi();
        ApiInterface api = retrofit.create(ApiInterface.class);
        Call<List<Phone>> call;

        if (bundle != null) {
            String manufacturer = bundle.getString("manufacturer");
            String model = bundle.getString("model");
            Integer min_price = null;
            String price = bundle.getString("min_price");
            if (price != null)
                min_price = Integer.parseInt(price);
            Integer max_price = null;
            price = bundle.getString("max_price");
            if (price != null)
                max_price = Integer.parseInt(price);
            if (manufacturer != null || model != null || min_price != null || max_price != null) {
                call = api.getPhone(manufacturer, model, min_price, max_price);
            } else {
                call = api.getPhone();
            }
        } else {
            call = api.getPhone();
        }

        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                Log.v("url", call.request().url().toString());

                List<Phone> phone = response.body();

                loadingIndicator.setVisibility(View.INVISIBLE);

                if (phone.size() == 0) {
                    mEmptyView.setText("No Phones Available");
                    mEmptyView.setVisibility(View.VISIBLE);
                } else {
                    mEmptyView.setVisibility(View.INVISIBLE);
                }

                renderPhones(phone);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Log.v("url", "No Internet Connection");
                loadingIndicator.setVisibility(View.INVISIBLE);
                mEmptyView.setText("No Internet Connection");
                mEmptyView.setVisibility(View.VISIBLE);
            }
        });
    }

    public void renderPhones(List<Phone> phone) {

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        PhoneAdapter phoneAdapter = new PhoneAdapter(phone);
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(phoneAdapter);
        alphaAdapter.setDuration(1500);
        recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phone, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        } else if (id == R.id.sales) {
            Intent intent = new Intent(this, SalesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}




