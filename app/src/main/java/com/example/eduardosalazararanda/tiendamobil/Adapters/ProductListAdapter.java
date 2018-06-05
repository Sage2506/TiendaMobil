package com.example.eduardosalazararanda.tiendamobil.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.eduardosalazararanda.tiendamobil.Models.Product;
import com.example.eduardosalazararanda.tiendamobil.Models.Product;
import com.example.eduardosalazararanda.tiendamobil.R;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder>{
    private ArrayList<Product> dataset;
    private Context context;
    private ProductListAdapter.Listener listener;
    public interface Listener{

    }
    public void setListener(ProductListAdapter.Listener listener){ this.listener = listener;}
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    /*ProdResponse d = dataset.get((int)view.getTag());
                    listener.openProd(d);*/
                }
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductListAdapter.ViewHolder holder, int position) {
        Product p = dataset.get(position);
        holder.TvProdName.setText(p.getName());
        holder.TvProdDesc.setText(p.getDescription());
        holder.TvProdPrice.setText(p.getPrice());
        holder.cardView.setTag(position);
        Glide.with(context)
                .load(p.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.IvProdPic);

    }

    public ProductListAdapter(Context context) {
        this.dataset = new ArrayList<Product>();
        this.context = context;
    }
    public void addItemsList(ArrayList<Product> items){
        dataset.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView IvProdPic;
        private TextView TvProdName;
        private TextView TvProdDesc;
        private TextView TvProdPrice;
        private CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);

            IvProdPic = itemView.findViewById(R.id.iv_prod_pic);
            TvProdName = itemView.findViewById(R.id.tv_prod_name);
            TvProdDesc = itemView.findViewById(R.id.tv_prod_desc);
            TvProdDesc = itemView.findViewById(R.id.tv_prod_desc);
            TvProdPrice = itemView.findViewById(R.id.tv_prod_price);
            cardView = (CardView) itemView;
        }
    }
}

