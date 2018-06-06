package com.example.eduardosalazararanda.tiendamobil.ShoppingCart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.eduardosalazararanda.tiendamobil.ApplicationSession;
import com.example.eduardosalazararanda.tiendamobil.Orders.OrdersListActivity;
import com.example.eduardosalazararanda.tiendamobil.R;

public class ShoppingListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartRowListAdapter adapter;
    private ApiShoppingCart api;
    Button btnOrders;
    Button empty;
    Button orderAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        btnOrders = findViewById(R.id.btn_orders);
        empty = findViewById(R.id.btn_empty);
        orderAll = findViewById(R.id.btn_buy);
        recyclerView = findViewById(R.id.rv_items);

        api = new ApiShoppingCart();
        final String email = ((ApplicationSession)this.getApplication()).getEmail();

        adapter = new CartRowListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

       /* adapter.setListener(new CategoryListAdapter.Listener() {
            @Override
            public void Category(Category c) {
                Intent products = new Intent(getApplicationContext(),ProductListActivity.class);
                products.putExtra("category",c.getName());
                startActivity(products);
            }
        });*/

        api.getAll(adapter,email);

        adapter.setListener(new CartRowListAdapter.Listener() {
            @Override
            public void Remove(final CartRow cr) {
                api.remove(cr, new ApiShoppingCart.ServiceCallBack() {
                    @Override
                    public void response(Boolean bool) {
                        if(bool)
                        adapter.removeItem(cr);
                    }
                });
            }
        });

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOrders.setEnabled(false);
                Intent orders = new Intent(getApplicationContext(), OrdersListActivity.class);
                startActivity(orders);
                finish();
            }
        });

        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.setEnabled(false);
                api.deleteAll(email, new ApiShoppingCart.ServiceCallBack() {
                    @Override
                    public void response(Boolean bool) {
                        if(bool){
                            adapter.emptyCart();
                            empty.setEnabled(true);
                        }

                    }
                });
            }
        });

        orderAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderAll.setEnabled(false);
                api.ComprarTodo(email, "Deposito", new ApiShoppingCart.ServiceCallBack() {
                    @Override
                    public void response(Boolean bool) {
                        if(bool){
                            orderAll.setEnabled(true);
                            Intent order = new Intent(getApplicationContext(), OrdersListActivity.class);
                            startActivity(order);
                            finish();
                        }
                    }
                });
            }
        });
    }
}
