package com.example.eduardosalazararanda.tiendamobil.Orders;

import android.util.Log;

import com.example.eduardosalazararanda.tiendamobil.Adapters.OrderListAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiOrders {
    private String TAG = "ApiOrders";
    public Retrofit retrofit;
    final OrdersServices service;

    public ApiOrders(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://tiendaweb.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OrdersServices.class);
    }

    public ArrayList<Order> getAll(final OrderListAdapter adapter, String client){
        Call<ArrayList<Order>> productsResponse = service.GetAll(client);
        productsResponse.enqueue(new Callback<ArrayList<Order>>() {
            @Override
            public void onResponse(Call<ArrayList<Order>> call, Response<ArrayList<Order>> response) {
                if(response.isSuccessful()){
                    adapter.addItemsList(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Order>> call, Throwable t) {

            }
        });
        return null;
    }

    public void create(Order order){
        Call<Order> orderResponse = service.Create(order);
        orderResponse.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if(response.isSuccessful()){
                    Log.i(TAG, response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void complete(String IdOrder){
        Call<Order> orderResponse = service.Complete(IdOrder);
        orderResponse.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if(response.isSuccessful()){
                    Log.i(TAG, response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Order> call, Throwable t) {

            }
        });
    }




    public void Update(Order order){
        Call<Order> orderResponse = service.Update(order.getOrderId(),order);
        orderResponse.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if(response.isSuccessful()){
                    Log.i(TAG, response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Order> call, Throwable t) {

            }
        });
    }

    public void Delete(Order order){
        Call<Boolean> orderResponse = service.Delete(order.getOrderId());
        orderResponse.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.isSuccessful()){
                    Log.i(TAG, response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }
}
