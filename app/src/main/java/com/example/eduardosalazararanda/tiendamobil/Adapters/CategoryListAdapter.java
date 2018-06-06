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
import com.example.eduardosalazararanda.tiendamobil.Categories.Category;
import com.example.eduardosalazararanda.tiendamobil.R;

import java.util.ArrayList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder>{
    private ArrayList<Category> dataset;
    private Context context;
    private Listener listener;
    public interface Listener{
        void Category(Category c);
    }
    public void setListener(Listener listener){ this.listener = listener;}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    Category d = dataset.get((int)view.getTag());
                    listener.Category(d);
                }
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     Category c = dataset.get(position);
        holder.TvCatName.setText(c.getName());
        holder.cardView.setTag(position);
        Glide.with(context)
                .load(c.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.IvCatPic);

    }

    public CategoryListAdapter(Context context) {
        this.dataset = new ArrayList<Category>();
        this.context = context;
    }
    public void addItemsList(ArrayList<Category> items){
        dataset.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView IvCatPic;
        private TextView TvCatName;
        private CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);

            IvCatPic = itemView.findViewById(R.id.iv_cat_image);
            TvCatName = itemView.findViewById(R.id.tv_cat_name);
            cardView = (CardView) itemView;
        }
    }
}
