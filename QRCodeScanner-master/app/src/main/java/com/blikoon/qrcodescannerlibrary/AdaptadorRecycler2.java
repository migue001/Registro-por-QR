package com.blikoon.qrcodescannerlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jj on 28/10/19.
 */

public class AdaptadorRecycler2 extends RecyclerView.Adapter<AdaptadorRecycler2.ViewHolderDatos>implements View.OnClickListener {
   ArrayList<Recycler>list;
    private View.OnClickListener jj;
   public AdaptadorRecycler2(ArrayList<Recycler>list){
       this.list=list;
   }
    @Override
    public AdaptadorRecycler2.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,null,false);
       view.setOnClickListener(this);
       return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorRecycler2.ViewHolderDatos holder, int position) {
holder.textView.setText(list.get(position).getId());
holder.textView2.setText(list.get(position).getInformacion());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
public void setOnclickListener(View.OnClickListener vieww){
       this.jj=vieww;
}
    @Override
    public void onClick(View view) {
       if(jj!=null){
           jj.onClick(view);
       }
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
       TextView textView,textView2;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.ides);
            textView2=(TextView)itemView.findViewById(R.id.texto);

        }
    }
}
