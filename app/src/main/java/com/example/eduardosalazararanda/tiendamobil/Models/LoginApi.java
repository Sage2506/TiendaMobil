package com.example.eduardosalazararanda.tiendamobil.Models;

import android.util.Log;

import com.example.eduardosalazararanda.tiendamobil.Orders.ApiOrders;
import com.example.eduardosalazararanda.tiendamobil.Orders.Order;
import com.example.eduardosalazararanda.tiendamobil.Orders.OrdersServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class LoginApi {

    private String TAG = "ApiOrders";
    public Retrofit retrofit;
    final LoginService service;
    public LoginApi(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://tiendaweb.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(LoginService.class);
    }
    public void login(Login login, final ServiceCallBack callCack){
        Call<Object> orderResponse = service.userLogin(login);
        orderResponse.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(response.isSuccessful()){
                    callCack.response(true);
                }
            }
            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e(TAG, t.getMessage());
                callCack.response(false);
            }
        });
    }
    public interface ServiceCallBack{
        void response(Boolean bool);
    }
}
