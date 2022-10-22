package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.Fragments.EntertainmentFragment;
import com.example.newsapp.Fragments.HealthFragment;
import com.example.newsapp.Fragments.HomeFragment;
import com.example.newsapp.Fragments.ScienceFragment;
import com.example.newsapp.Fragments.SportsFragment;
import com.example.newsapp.Fragments.TechFragment;
import com.example.newsapp.Models.SearchModel;

public class PageAdapter extends FragmentPagerAdapter {

    int tabCount;
    SearchModel searchModel;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechFragment();
            default:
                return null;
        }
    }



    @Override
    public int getCount() {
        return tabCount;
    }
}
