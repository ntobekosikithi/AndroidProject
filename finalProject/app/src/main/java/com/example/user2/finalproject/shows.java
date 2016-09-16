package com.example.user2.finalproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class shows extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "c94431cab6597dab45a1c126e000512f";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Invalid API KEY", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient2().create(ApiInterface.class);

        Call<ShowsSetAndGet> call = apiService.getTopRatedShows(API_KEY);
        call.enqueue(new Callback<ShowsSetAndGet>() {
            @Override
            public void onResponse(Call<ShowsSetAndGet> call, Response<ShowsSetAndGet> response) {
                int statusCode = response.code();
                List<Result> Result = response.body().getResults();
                recyclerView.setAdapter(new showsAdapter(Result, R.layout.popularshows, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ShowsSetAndGet> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

}
