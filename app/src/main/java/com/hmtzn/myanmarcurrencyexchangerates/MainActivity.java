package com.hmtzn.myanmarcurrencyexchangerates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hmtzn.myanmarcurrencyexchangerates.adapter.ExchangeRateAdapter;
import com.hmtzn.myanmarcurrencyexchangerates.api.RetrofitOfExchangeRate;
import com.hmtzn.myanmarcurrencyexchangerates.helper.AppDatabase;
import com.hmtzn.myanmarcurrencyexchangerates.helper.EndlessRecyclerViewScrollListener;
import com.hmtzn.myanmarcurrencyexchangerates.model.Rates;
import com.hmtzn.myanmarcurrencyexchangerates.utility.AppDatabaseUtility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hmtzn.myanmarcurrencyexchangerates.api.RetrofitOfExchangeRate.*;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private final ExchangeRateAdapter exchangeRateAdapter = new ExchangeRateAdapter();
    private RecyclerView rv_rates;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Call<RetrofitOfExchangeRate> apiInterface;
    private ProgressDialog progressDialog;
    private LinearLayoutManager linearLayoutManager;
    private Context context;
    private List<String> rates;
    private Rates ratesModel;


    private AppDatabase appDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Myanmar Exchange Rates");
            //  getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        appDatabase = AppDatabaseUtility.getAppDatabase(MainActivity.this);
        init();
    }

    public void init() {

        rv_rates = findViewById(R.id.rv_rate);
        swipeRefreshLayout = findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(this);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv_rates.setLayoutManager(linearLayoutManager);
        rv_rates.setAdapter(exchangeRateAdapter);
        apiInterface = RetrofitOfExchangeRate.getRetrofitInstance(context);
        swipeRefreshLayout.setRefreshing(false);
        rv_rates.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager));

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
        exchangeRateAdapter.clear();
        getRates();
    }

    private void getRates() {

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        exchangeRateAdapter.clear();

        Call<RetrofitOfExchangeRate> exchangeRateCall =apiInterface.getLatest();
        exchangeRateCall.enqueue(new Callback<RetrofitOfExchangeRate>() {
            @Override
            public void onResponse(Call<RetrofitOfExchangeRate> call, Response<RetrofitOfExchangeRate> response) {

                progressDialog.dismiss();
                Log.d(TAG, "onResponse : " + response.body());

                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        final List<Rates> ratesList = (List<Rates>) response.body();
                        if (ratesList.isEmpty()) {
                            Toast.makeText(MainActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                        } else {
                            exchangeRateAdapter.getRatesList().addAll(ratesList);
                            exchangeRateAdapter.notifyDataSetChanged();
                        }

                    }else {
                        Log.d(TAG,"onResponse:Response is null : ");
                    }
                    Log.d(TAG,"Respone is  suucessful");
                }else {
                    handleError();
                    Log.d(TAG   ,"Respone is not  suucessful");
                }

            }

            @Override
            public void onFailure(Call<RetrofitOfExchangeRate> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                Log.d("TestActivity", "onFailure: " + t.getLocalizedMessage());
                Log.d(TAG, "onFailure: "+t.getMessage());
                handleError();

            }
        });
    }

    private void handleError() {

        progressDialog.dismiss();
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("No Connection...")
                .setMessage("Please Try Again...")
                .setPositiveButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> getRates())
                .show();
    }
}