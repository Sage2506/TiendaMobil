package com.example.eduardosalazararanda.tiendamobil.Orders;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OrdersServices {

    // Ordenes del cliente
    @GET("pedidos/Client/{cliente}")
    Call<ArrayList<Order>> GetAll(@Path("cliente") String cliente);

    //Pedido en especifico
    @GET("pedidos/{id}")
    Call<Order> GetOrder(@Path("id") String IdOrder);
    // Crear pedido
    @POST("pedidos")
    @Headers("Content-Type: application/json")
    Call<Order> Create(@Body Order order);

    // Avanzar en los estados del pedido
    @PUT("pedidos/{id}/Complete")
    Call<Order> Complete(@Path("id") String IdOrder);

    // Actualizar datos del pedido
    @PUT("pedidos/{id}")
    Call<Order> Update(@Path("id") String IdOrder,@Body Order order);

    // Cancelar pedido
    @DELETE("pedidos/{id}")
    Call<Object> Delete(@Path("id") String IdOrder);
}
