package com.example.eduardosalazararanda.tiendamobil.Orders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.eduardosalazararanda.tiendamobil.ApplicationSession;
import com.example.eduardosalazararanda.tiendamobil.R;
import com.example.eduardosalazararanda.tiendamobil.ShoppingCart.ShoppingListActivity;

public class OrdersListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private OrderListAdapter adapter;
    private ApiOrders api;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);
        final Button btnCart = findViewById(R.id.btn_cart);
        api = new ApiOrders();
        email = ((ApplicationSession)this.getApplication()).getEmail();
        recyclerView = findViewById(R.id.rv_items);
        adapter = new OrderListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        api.getAll(adapter,email);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCart.setEnabled(false);
                Intent cart = new Intent(getApplicationContext(), ShoppingListActivity.class);
                startActivity(cart);
                finish();
            }
        });

        adapter.setListener(new OrderListAdapter.Listener() {
            @Override
            public void openOrder(Order o) {
                Intent order = new Intent(getApplicationContext(), OrderDetailsActivity.class);
                order.putExtra("product",o.getProduct());
                order.putExtra("orderId",o.getOrderId());
                order.putExtra("pay",o.getPay());
                order.putExtra("payment",o.getPayment());
                order.putExtra("state",o.getState());
                order.putExtra("client",o.getClient());
                order.putExtra("descriptionproduct",o.getDescriptionProduct());
                order.putExtra("orderdate",o.getOrderDate());
                order.putExtra("productprice",o.getProductPrice());
                startActivity(order);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        api.getAll(adapter,email);
    }
}
