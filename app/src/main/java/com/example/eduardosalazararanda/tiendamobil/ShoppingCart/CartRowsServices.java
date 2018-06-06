package com.example.eduardosalazararanda.tiendamobil.ShoppingCart;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CartRowsServices {
    // Obener los carritos de un usuario
    @GET("ShoppingCart/{email}")
    Call<ArrayList<CartRow>> GetAllByClient(@Path("email") String email);
    // Vaciar el carrito del usuario
    @DELETE("ShoppingCart/{email}")
    Call<Object> Clear(@Path("email") String email);
    // Agregar al carrito
    @POST("ShoppingCart/{email}")
    @Headers("Content-Type: application/json")
    Call<CartRow> Create(@Path("email") String email, @Body CartRow body);
    // Eliminar del carrito
    @DELETE("ShoppingCart/{partition}/{row}")
    Call<Object> Remove(@Path("partition") String partition, @Path("row") String row);
}
