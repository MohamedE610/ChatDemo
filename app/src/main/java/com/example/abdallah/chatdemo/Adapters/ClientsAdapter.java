package com.example.abdallah.chatdemo.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.abdallah.chatdemo.Models.Clients.Clients;
import com.example.abdallah.chatdemo.R;
import com.squareup.picasso.Picasso;


import de.hdodenhof.circleimageview.CircleImageView;


public class ClientsAdapter extends RecyclerView.Adapter<ClientsAdapter.MyViewHolder>  {
   Clients clients;
    Context context;
    int  LastPosition=-1;
    RecyclerViewClickListener ClickListener ;
    public ClientsAdapter(){}
    public ClientsAdapter( Clients clients, Context context){
        this.clients =new Clients();
        this.clients = clients;
        this.context=context;
    }


    public void setClickListener(RecyclerViewClickListener clickListener){
        this.ClickListener= clickListener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_client_recycler,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String ss=clients.getClientsData().get(position).getArName();
        holder.textView.setText(ss);
        String url="http://gms-sms.com:89"+clients.getClientsData().get(position).getLogo();
        Picasso.with(context).load(url).placeholder(R.drawable.facebook_circle)
                .error(R.drawable.facebook_circle).into(holder.imageView);
        setAnimation(holder.cardView,position);

    }

    @Override
    public int getItemCount() {
        if(clients==null||clients.getClientsData()==null)
            return 0;
        return clients.getClientsData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView=(TextView)itemView.findViewById(R.id.client_text);
            imageView=(ImageView) itemView.findViewById(R.id.client_img);
            cardView=(CardView) itemView.findViewById(R.id.card);
        }

        @Override
        public void onClick(View view) {
            if(ClickListener!=null)
                ClickListener.ItemClicked(view ,getAdapterPosition());
        }

        public void clearAnimation()
        {
            cardView.clearAnimation();
        }
    }

    public interface RecyclerViewClickListener
    {

        public void ItemClicked(View v, int position);
    }

    private void setAnimation(View viewToAnimate, int position)
    {

        if (position > LastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            LastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.clearAnimation();
    }



}

