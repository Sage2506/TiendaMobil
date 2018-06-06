package com.example.eduardosalazararanda.tiendamobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.eduardosalazararanda.tiendamobil.Adapters.CategoryListAdapter;
import com.example.eduardosalazararanda.tiendamobil.Categories.Category;
import com.example.eduardosalazararanda.tiendamobil.Orders.OrdersListActivity;
import com.example.eduardosalazararanda.tiendamobil.Categories.ApiCategories;
import com.example.eduardosalazararanda.tiendamobil.Product.ProductListActivity;
import com.example.eduardosalazararanda.tiendamobil.ShoppingCart.ShoppingListActivity;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryListAdapter adapter;
    private ApiCategories api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = new ApiCategories();

        recyclerView = findViewById(R.id.rv_items);
        adapter = new CategoryListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(new CategoryListAdapter.Listener() {
            @Override
            public void Category(Category c) {
                Intent products = new Intent(getApplicationContext(),ProductListActivity.class);
                products.putExtra("category",c.getName());
                startActivity(products);
            }
        });

        api.getAll(adapter);

        Button btnShoppingCart = findViewById(R.id.btn_cart);
        Button btnOrders= findViewById(R.id.btn_orders);

        btnShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(getApplicationContext(), ShoppingListActivity.class);
                startActivity(shoppingCart);
            }
        });

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orders = new Intent(getApplicationContext(), OrdersListActivity.class);
                startActivity(orders);
            }
        });
    }
}
