package com.example.newsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Adapter;
import com.example.newsapp.ApiUtilities;
import com.example.newsapp.Models.ModelClass;
import com.example.newsapp.Models.mainNews;
import com.example.newsapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    private RecyclerView recyclerViewofSports;
    private String category = "the-thao";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportsfragment, null);
        recyclerViewofSports = v.findViewById(R.id.recyclerviewofsports);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofSports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewofSports.setAdapter(adapter);
        findNews();


        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(category).enqueue(new Callback<mainNews>() {
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
}
