package com.example.eduardosalazararanda.tiendamobil.Models;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {

    @POST("login")
    @Headers("Content-Type: application/json")
    Call<Object> userLogin(@Body Login body);

}
