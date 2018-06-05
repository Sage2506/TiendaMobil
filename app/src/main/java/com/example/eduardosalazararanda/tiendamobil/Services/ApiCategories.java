package com.example.eduardosalazararanda.tiendamobil.Services;

import com.example.eduardosalazararanda.tiendamobil.Adapters.CategoryListAdapter;
import com.example.eduardosalazararanda.tiendamobil.Models.Category;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCategories {
    public Retrofit retrofit;
    final CategoriesServices service;

    public ApiCategories(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://tiendaweb.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(CategoriesServices.class);
    }
    public ArrayList<Category> getAll(final CategoryListAdapter adapter){

        Call<ArrayList<Category>> CategorysResponse = service.GetAll();
        CategorysResponse.enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                if(response.isSuccessful()){
                    ArrayList<Category> list = response.body();
                    adapter.addItemsList(list);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {

            }
        });
        return null;
    }
}
