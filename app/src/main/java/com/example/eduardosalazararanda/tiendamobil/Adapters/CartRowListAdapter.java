package com.example.eduardosalazararanda.tiendamobil.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eduardosalazararanda.tiendamobil.ShoppingCart.CartRow;
import com.example.eduardosalazararanda.tiendamobil.R;

import java.util.ArrayList;

public class CartRowListAdapter extends RecyclerView.Adapter<CartRowListAdapter.ViewHolder>{
    private ArrayList<CartRow> dataset;
    private Context context;
    private CartRowListAdapter.Listener listener;
    public interface Listener{

    }
    public void setListener(CartRowListAdapter.Listener listener){ this.listener = listener;}
    @Override
    public CartRowListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cartrow,parent,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    /*DishResponse d = dataset.get((int)view.getTag());
                    listener.openDish(d);*/
                }
            }
        });
        return new CartRowListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartRowListAdapter.ViewHolder holder, int position) {
     CartRow c = dataset.get(position);
        holder.TvCartName.setText(c.getDescription());
        holder.TvCartDesc.setText(c.getDescription());
        holder.TvCartPrice.setText(c.getPrice());
        holder.cardView.setTag(position);
        /*Glide.with(context)
                .load(d.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.IvDishPic);
    * */
    }

    public CartRowListAdapter(Context context) {
        this.dataset = new ArrayList<>();
        this.context = context;
    }
    public void addItemsList(ArrayList<CartRow> items){
        dataset.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //private ImageView IvCarthPic;
        private TextView TvCartName;
        private TextView TvCartDesc;
        private TextView TvCartPrice;
        private CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);

            //IvCartPic = itemView.findViewById(R.id.iv_dish_pic);
            TvCartName = itemView.findViewById(R.id.tv_prod_name);
            TvCartDesc = itemView.findViewById(R.id.tv_prod_desc);
            TvCartPrice = itemView.findViewById(R.id.tv_prod_price);
            cardView = (CardView) itemView;
        }
    }
}

