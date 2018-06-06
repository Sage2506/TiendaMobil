package com.example.eduardosalazararanda.tiendamobil;

import android.app.Application;

import com.example.eduardosalazararanda.tiendamobil.Orders.Order;
import com.example.eduardosalazararanda.tiendamobil.Product.Product;

public class ApplicationSession extends Application{
    private String email = "germanAndroidTest" ;
    private Product product;

    public void asignUser(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
