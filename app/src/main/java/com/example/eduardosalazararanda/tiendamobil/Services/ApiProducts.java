package com.example.eduardosalazararanda.tiendamobil.Services;

import com.example.eduardosalazararanda.tiendamobil.Models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProducts {
    public Retrofit retrofit;
    final ProductsServices service;

    public ApiProducts(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://tiendaweb.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ProductsServices.class);
    }
    public ArrayList<Product> getAll(){
        final ArrayList<Product> result = new ArrayList<Product>();
        Call<ArrayList<Product>> productsResponse = service.GetAll();
        productsResponse.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
        return null;
    }

}
