package com.example.eduardosalazararanda.tiendamobil.ShoppingCart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.eduardosalazararanda.tiendamobil.Adapters.CartRowListAdapter;
import com.example.eduardosalazararanda.tiendamobil.ApplicationSession;
import com.example.eduardosalazararanda.tiendamobil.R;

public class ShoppingListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartRowListAdapter adapter;
    private ApiShoppingCart api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        api = new ApiShoppingCart();
        String email = ((ApplicationSession)this.getApplication()).getEmail();
        recyclerView = findViewById(R.id.rv_items);
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
    }
}
