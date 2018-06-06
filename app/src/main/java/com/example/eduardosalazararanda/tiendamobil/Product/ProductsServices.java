package com.example.eduardosalazararanda.tiendamobil.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductsServices {
    @GET("products")
    Call<ArrayList<Product>> GetAll();

    @GET("products/category/{category}")
    Call<ArrayList<Product>> GetAll(@Path("category") String category);

}
