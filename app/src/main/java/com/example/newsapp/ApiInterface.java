package com.example.newsapp;

import com.example.newsapp.Models.PlusViewModel;
import com.example.newsapp.Models.mainNews;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL = "https://backend-news-tn.herokuapp.com/api/news/";

    @GET("getAll")
    Call<mainNews> getNews();

    @GET("search")
    Call<mainNews> getCategoryNews(
            @Query("searchTerm") String category
    );
    @GET("search")
    Call<mainNews> findNews(
            @Query("searchTerm") String category
    );

    @POST("plusView")
    Call<PlusViewModel> plusView(
            @Body PlusViewModel plusViewModel
    );


//    @GET("top-headlines")
//    Call<mainNews> getCategoryNews(
//            @Query("country") String country,
//            @Query("category") String category,
//            @Query("pageSize") int pageSize,
//            @Query("apiKey") String apiKey
//    );

//    @GET("top-headlines")
//    Call<mainNews> getNews(
//            @Query("country") String country,
//            @Query("pageSize") int pageSize,
//            @Query("apiKey") String apiKey
//    );

}
