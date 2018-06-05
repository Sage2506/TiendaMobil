package com.example.eduardosalazararanda.tiendamobil.Services;

import com.example.eduardosalazararanda.tiendamobil.Models.Category;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesServices {
    @GET("categories")
    Call<ArrayList<Category>> GetAll();
}
