package com.example.immadisairaj.codeforcessubmissions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionActivity extends AppCompatActivity {

    public String handle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        Bundle bundle = getIntent().getExtras();
        handle = bundle.getString("handle");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<Submission> call = api.getSubmission(handle,"1","50");

        call.enqueue(new Callback<Submission>() {
            @Override
            public void onResponse(Call<Submission> call, Response<Submission> response) {

                Log.v("url", call.request().url().toString());

                Submission submission = response.body();

                String status = submission.getStatus();
                if(status.equals("OK")) {
                    Toast.makeText(getApplicationContext(), handle, Toast.LENGTH_SHORT).show();
                } else {
                    SubmissionActivity.super.onBackPressed();
                }

            }

            @Override
            public void onFailure(Call<Submission> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
