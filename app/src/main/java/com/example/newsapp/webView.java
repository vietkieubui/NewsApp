package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.newsapp.Activities.MainActivity;
import com.example.newsapp.Activities.SearchActivity;
import com.example.newsapp.Fragments.HomeFragment;
import com.example.newsapp.Models.mainNews;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class webView extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    TextView backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar  = findViewById(R.id.toolbar);
        webView = findViewById(R.id.webview);
        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.newsapp.webView.this,MainActivity.class));
            }
        });
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }
}