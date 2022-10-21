package com.example.newsapp.Model;

import java.util.ArrayList;

public class mainNews {
    private String success;
    private ArrayList<ModelClass> data;

    public mainNews(String success, ArrayList<ModelClass> data) {
        this.success = success;
        this.data = data;
    }

    public void setData(ArrayList<ModelClass> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String status) {
        this.success = success;
    }

    public ArrayList<ModelClass> getData() {
        return data;
    }

}
