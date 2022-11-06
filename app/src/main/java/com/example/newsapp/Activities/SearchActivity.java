package com.example.newsapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Observable;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.EventLog;
import android.util.Log;
import android.widget.EditText;

import com.example.newsapp.Adapter;
import com.example.newsapp.ApiUtilities;
import com.example.newsapp.Debouncer;
import com.example.newsapp.Models.ModelClass;
import com.example.newsapp.Models.mainNews;
import com.example.newsapp.PageAdapter;
import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    PageAdapter pageAdapter;
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    private RecyclerView recyclerViewofSearch;
    EditText searchText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchText = findViewById(R.id.search_text);
        recyclerViewofSearch = findViewById(R.id.recyclerviewofsearch);
        recyclerViewofSearch.setLayoutManager(new LinearLayoutManager(this));
        modelClassArrayList = new ArrayList<>();
        adapter = new Adapter(this, modelClassArrayList);
        recyclerViewofSearch.setAdapter(adapter);
        getNews();

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (new Debouncer()).debounce(Void.class, new Runnable() {
                    @Override
                    public void run() {
                        searchNews(searchText.getText().toString());                    }
                },500, TimeUnit.MILLISECONDS);

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    public void getNews() {
        ApiUtilities.getApiInterface().getNews().enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getData());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }

    public String searchNews(String text){
        ApiUtilities.getApiInterface().findNews(text).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.clear();
                    modelClassArrayList.addAll(response.body().getData());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
        return "done";
    }


}