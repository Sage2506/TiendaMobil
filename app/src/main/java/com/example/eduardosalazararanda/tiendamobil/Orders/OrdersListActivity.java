package com.example.eduardosalazararanda.tiendamobil.Orders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.eduardosalazararanda.tiendamobil.Adapters.OrderListAdapter;
import com.example.eduardosalazararanda.tiendamobil.ApplicationSession;
import com.example.eduardosalazararanda.tiendamobil.R;

public class OrdersListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private OrderListAdapter adapter;
    private ApiOrders api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);
        api = new ApiOrders();
        String email = ((ApplicationSession)this.getApplication()).getEmail();
        recyclerView = findViewById(R.id.rv_items);
        adapter = new OrderListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        api.getAll(adapter,email);
    }
}
