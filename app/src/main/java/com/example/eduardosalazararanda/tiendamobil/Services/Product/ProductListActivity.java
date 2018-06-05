package com.example.eduardosalazararanda.tiendamobil.Services.Product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.eduardosalazararanda.tiendamobil.Adapters.ProductListAdapter;
import com.example.eduardosalazararanda.tiendamobil.Models.Product;
import com.example.eduardosalazararanda.tiendamobil.R;
import com.example.eduardosalazararanda.tiendamobil.Services.ApiProducts;

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
    }
}
