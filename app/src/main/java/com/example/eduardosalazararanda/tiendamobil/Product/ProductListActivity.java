package com.example.eduardosalazararanda.tiendamobil.Product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.eduardosalazararanda.tiendamobil.Adapters.ProductListAdapter;
import com.example.eduardosalazararanda.tiendamobil.ApplicationSession;
import com.example.eduardosalazararanda.tiendamobil.R;
import com.example.eduardosalazararanda.tiendamobil.ShoppingCart.ShoppingListActivity;

public class ProductListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductListAdapter adapter;
    private ApiProducts api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        api = new ApiProducts();
        String category = getIntent().getStringExtra("category");
        recyclerView = findViewById(R.id.rv_items);
        adapter = new ProductListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(new ProductListAdapter.Listener() {
            @Override
            public void Product(Product c) {
                Intent product = new Intent(getApplicationContext(),ProductDetail.class);
                product.putExtra("name",c.getName());
                product.putExtra("description",c.getDescription());
                product.putExtra("image",c.getImage());
                product.putExtra("code",c.getCode());
                product.putExtra("price",c.getPrice());
                startActivity(product);
            }
        });

        api.getAll(adapter,category);

        Button btnShoppingCart = findViewById(R.id.btn_cart);
        Button btnOrders= findViewById(R.id.btn_orders);

        btnShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoppingCart = new Intent(getApplicationContext(), ShoppingListActivity.class);
                startActivity(shoppingCart);
            }
        });
    }
}
