package com.example.eduardosalazararanda.tiendamobil.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eduardosalazararanda.tiendamobil.Orders.Order;
import com.example.eduardosalazararanda.tiendamobil.R;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder>{
    private ArrayList<Order> dataset;
    private Context context;
    private OrderListAdapter.Listener listener;
    public interface Listener{

    }
    public void setListener(OrderListAdapter.Listener listener){ this.listener = listener;}
    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order,parent,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    /*OrderResponse d = dataset.get((int)view.getTag());
                    listener.openOrder(d);*/
                }
            }
        });
        return new OrderListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderListAdapter.ViewHolder holder, int position) {

        Order d = dataset.get(position);
        holder.TvOrderName.setText(d.getDescriptionProduct());
        holder.TvOrderDesc.setText(d.getDescriptionProduct());
        holder.TvOrderPrice.setText(d.getProductPrice()+"");
        holder.cardView.setTag(position);
        /*Glide.with(context)
                .load(d.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.IvOrderPic);*/

    }

    public OrderListAdapter(Context context) {
        this.dataset = new ArrayList<>();
        this.context = context;
    }
    public void addItemsList(ArrayList<Order> items){
        dataset.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //private ImageView IvOrderPic;
        private TextView TvOrderName;
        private TextView TvOrderDesc;
        private TextView TvOrderPrice;
        private CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);

            //IvOrderPic = itemView.findViewById(R.id.iv_Order_pic);
            TvOrderName = itemView.findViewById(R.id.tv_ord_name);
            TvOrderDesc = itemView.findViewById(R.id.tv_ord_desc);
            TvOrderPrice = itemView.findViewById(R.id.tv_ord_price);
            cardView = (CardView) itemView;
        }
    }
}

