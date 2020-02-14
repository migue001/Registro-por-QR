package com.blikoon.qrcodescannerlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jj on 16/10/19.
 */

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolderDatos> {
    ArrayList<String>list;
    public AdaptadorRecycler(ArrayList<String> list) {
        this.list = list;
    }



    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
holder.asignardatos(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView dato;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato=(TextView)itemView.findViewById(R.id.texto);
        }

        public void asignardatos(String s) {
            dato.setText(s);
        }
    }
}
