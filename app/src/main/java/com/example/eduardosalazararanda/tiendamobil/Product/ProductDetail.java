package com.example.eduardosalazararanda.tiendamobil.Product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.eduardosalazararanda.tiendamobil.ApplicationSession;
import com.example.eduardosalazararanda.tiendamobil.Orders.ApiOrders;
import com.example.eduardosalazararanda.tiendamobil.Orders.Order;
import com.example.eduardosalazararanda.tiendamobil.Orders.OrderToPost;
import com.example.eduardosalazararanda.tiendamobil.R;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Intent intent = getIntent();
        final Product product = new Product();
        final String email = ((ApplicationSession)this.getApplication()).getEmail();
        product.setCode(intent.getStringExtra("code"));
        product.setName(intent.getStringExtra("name"));
        product.setDescription(intent.getStringExtra("description"));
        product.setImage(intent.getStringExtra("image"));
        product.setPrice(intent.getStringExtra("price"));

        ImageView image = findViewById(R.id.iv_prod_pic);
        TextView name = findViewById(R.id.tv_prod_name);
        TextView desc = findViewById(R.id.tv_prod_desc);
        TextView price = findViewById(R.id.tv_prod_price);

        name.setText(product.getName());
        desc.setText(product.getDescription());
        price.setText(product.getPrice()+"");
        final ApiOrders orders = new ApiOrders();

        Glide.with(this)
                .load(product.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image);
        Button btnOrder = findViewById(R.id.btn_buy_product);
        Button btnAddCart = findViewById(R.id.btn_add_cart);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order(product, email);
                orders.create(order);

            }
        });
    }
}
