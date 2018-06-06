package com.example.eduardosalazararanda.tiendamobil.Orders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eduardosalazararanda.tiendamobil.R;

public class OrderDetailsActivity extends AppCompatActivity {
    ApiOrders orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Intent order = getIntent();
        TextView name = findViewById(R.id.tv_prod_desc);
        TextView client = findViewById(R.id.tv_client);
        TextView prod = findViewById(R.id.tv_prod);
        TextView pric = findViewById(R.id.tv_prod_price);
        TextView date = findViewById(R.id.tv_ord_date);
        TextView state = findViewById(R.id.tv_state);
        Button btnBuy = findViewById(R.id.btn_buy);
        Button cancel = findViewById(R.id.btn_cancel);

        orders = new ApiOrders();


        prod.setText(order.getStringExtra("product"));
        //order.getStringExtra("orderId");
        //order.getStringExtra("pay");
        //order.getStringExtra("payment");
        final String stateS = order.getStringExtra("state");
        final String orderId = order.getStringExtra("orderId");
        state.setText(order.getStringExtra("state"));
        client.setText(order.getStringExtra("client"));
        name.setText(order.getStringExtra("descriptionproduct"));
        date.setText(order.getStringExtra("orderdate"));
        pric.setText(order.getStringExtra("productprice"));

        if(!stateS.equals("No Pagado")){
            btnBuy.setVisibility(View.GONE);
            cancel.setVisibility(View.GONE);
        }

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buy = new Intent(getApplicationContext(), CompleteOrder.class);
                buy.putExtra("state", stateS);
                buy.putExtra("orderId", orderId);
                startActivity(buy);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orders.Delete(new Order(orderId, stateS), new ApiOrders.ServiceCallCack() {
                    @Override
                    public void response(Boolean bool) {
                        if(bool)
                        finish();
                    }
                });
            }
        });
    }
}
