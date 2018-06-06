package com.example.eduardosalazararanda.tiendamobil.Categories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.eduardosalazararanda.tiendamobil.Categories.CategoryListAdapter;
import com.example.eduardosalazararanda.tiendamobil.Categories.Category;
import com.example.eduardosalazararanda.tiendamobil.Orders.OrdersListActivity;
import com.example.eduardosalazararanda.tiendamobil.Categories.ApiCategories;
import com.example.eduardosalazararanda.tiendamobil.Product.ProductListActivity;
import com.example.eduardosalazararanda.tiendamobil.R;
import com.example.eduardosalazararanda.tiendamobil.ShoppingCart.ShoppingListActivity;

public class CategoriesListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryListAdapter adapter;
    private ApiCategories api;
    Button btnShoppingCart;
    Button btnOrders;

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

        btnShoppingCart = findViewById(R.id.btn_cart);
        btnOrders= findViewById(R.id.btn_orders);

        btnShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnShoppingCart.setEnabled(false);
                Intent shoppingCart = new Intent(getApplicationContext(), ShoppingListActivity.class);
                startActivity(shoppingCart);
            }
        });

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOrders.setEnabled(false);
                Intent orders = new Intent(getApplicationContext(), OrdersListActivity.class);
                startActivity(orders);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnOrders.setEnabled(true);
        btnShoppingCart.setEnabled(true);
    }
}
