package com.example.eduardosalazararanda.tiendamobil.Services.Product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.eduardosalazararanda.tiendamobil.Models.Product;
import com.example.eduardosalazararanda.tiendamobil.R;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Intent intent = getIntent();
        Product product = new Product();
        product.setCode(intent.getStringExtra("code"));
        product.setName(intent.getStringExtra("name"));
        product.setDescription(intent.getStringExtra("description"));
        product.setImage(intent.getStringExtra("image"));
        product.setPrice(intent.getIntExtra("price",0));

        ImageView image = findViewById(R.id.iv_prod_pic);
        TextView name = findViewById(R.id.tv_prod_name);
        TextView desc = findViewById(R.id.tv_prod_desc);
        TextView price = findViewById(R.id.tv_prod_price);

        name.setText(product.getName());
        desc.setText(product.getDescription());
        price.setText(product.getPrice()+"");

        Glide.with(this)
                .load(product.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image);

    }
}
