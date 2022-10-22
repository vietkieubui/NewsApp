package com.example.newsapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.newsapp.Models.SearchModel;
import com.example.newsapp.PageAdapter;
import com.example.newsapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome, mHealth, mTech, mEntertainment, mSports, mScience;
    PageAdapter pageAdapter;
    Toolbar mToolbar;
    EditText searchText;
    SearchModel searchModel;
    ImageButton searchBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mHome = findViewById(R.id.home);
        mHealth = findViewById(R.id.health);
        mTech = findViewById(R.id.technology);
        mEntertainment = findViewById(R.id.entertainment);
        mSports = findViewById(R.id.sports);
        mScience = findViewById(R.id.science);


        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.include);
        searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });


        pageAdapter = new PageAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5) {
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


}