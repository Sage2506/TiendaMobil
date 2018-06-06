package com.example.eduardosalazararanda.tiendamobil.Categories;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesServices {
    @GET("categories")
    Call<ArrayList<Category>> GetAll();
}
