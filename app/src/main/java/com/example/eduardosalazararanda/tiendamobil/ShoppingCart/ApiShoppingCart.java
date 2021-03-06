package com.example.eduardosalazararanda.tiendamobil.ShoppingCart;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiShoppingCart {

    public Retrofit retrofit;
    final CartRowsServices service;
    final String TAG = "ApiShoppingCart";

    public ApiShoppingCart(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://tiendaweb.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(CartRowsServices.class);
    }

    public void getAll(final CartRowListAdapter adapter, String client){
        Call<ArrayList<CartRow>> productsResponse = service.GetAllByClient(client);
        productsResponse.enqueue(new Callback<ArrayList<CartRow>>() {
            @Override
            public void onResponse(Call<ArrayList<CartRow>> call, Response<ArrayList<CartRow>> response) {
                if(response.isSuccessful()){
                    adapter.addItemsList(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CartRow>> call, Throwable t) {

            }
        });
    }
    public void deleteAll(String client, final ServiceCallBack serviceCallBack){
        Call<Object> productsResponse = service.Clear(client);
        productsResponse.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(response.isSuccessful()){
                    serviceCallBack.response(true);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                serviceCallBack.response(false);
            }
        });
    }

    public void add(String client, CartRow cartRow, final ServiceCallBack serviceCallBack){
        Call<CartRow> CartResponse = service.Create(client, cartRow);
        CartResponse.enqueue(new Callback<CartRow>() {
            @Override
            public void onResponse(Call<CartRow> call, Response<CartRow> response) {
                if(response.isSuccessful()){
                    serviceCallBack.response(true);
                }
            }

            @Override
            public void onFailure(Call<CartRow> call, Throwable t) {
                serviceCallBack.response(false);
            }
        });
    }

    public void remove(CartRow cartRow, final ServiceCallBack serviceCallBack){
        Call<Object> productsResponse = service.Remove(cartRow.getPartitionKey(), cartRow.getRowKey());
        productsResponse.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(response.isSuccessful()){
                    serviceCallBack.response(true);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                serviceCallBack.response(false);
            }
        });
    }
    public void ComprarTodo(String email, String payment,final ServiceCallBack serviceCallBack){
        Call<Object> callResponse = service.BuyAll(email, payment);
        callResponse.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(response.isSuccessful()){
                    serviceCallBack.response(true);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                serviceCallBack.response(false);
            }
        });
    }
    public interface ServiceCallBack{
        void response(Boolean bool);
    }

}
