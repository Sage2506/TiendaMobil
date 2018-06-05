package com.example.eduardosalazararanda.tiendamobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.eduardosalazararanda.tiendamobil.Adapters.CategoryListAdapter;
import com.example.eduardosalazararanda.tiendamobil.Models.Category;
import com.example.eduardosalazararanda.tiendamobil.Services.ApiCategories;

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
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(new CategoryListAdapter.Listener() {
            @Override
            public void Category(Category c) {
                // Abrir el sig intent
            }
        });

        api.getAll(adapter);
    }
}
