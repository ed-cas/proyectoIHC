package com.example.eduardo.proyectoihc.adapters;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eduardo.proyectoihc.MainActivity;
import com.example.eduardo.proyectoihc.R;
import com.example.eduardo.proyectoihc.details_fundation;
import com.example.eduardo.proyectoihc.objects.fundation;

import java.util.List;

public class RecyclerView_adapterdirectory extends RecyclerView.Adapter<RecyclerView_adapterdirectory.ViewHolder>{

    public List<fundation> fundations_listas;

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, descipcion;
        private ImageView imagen_proyecto;
        private CardView cardView;

        public ViewHolder(View view){
            super(view);
            titulo =(TextView)view.findViewById(R.id.title_fundation);
            descipcion=(TextView)view.findViewById(R.id.text_description);
            imagen_proyecto=(ImageView)view.findViewById(R.id.img_fundation);
            cardView=(CardView)view.findViewById(R.id.card_view_fundation_id);
        }
    }


    public RecyclerView_adapterdirectory(List<fundation> fundations_listas){
        this.fundations_listas=fundations_listas;
    }


    public RecyclerView_adapterdirectory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_directory,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }


    public void onBindViewHolder(@NonNull RecyclerView_adapterdirectory.ViewHolder holder, final int position) {
        holder.titulo.setText(fundations_listas.get(position).getTitle());
        holder.descipcion.setText(fundations_listas.get(position).getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),fundations_listas.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                Bundle b=new Bundle();
                b.putSerializable("object",fundations_listas.get(position));
                Intent intent = new Intent(view.getContext(),details_fundation.class);
                intent.putExtras(b);
                view.getContext().startActivity(intent);
            }
        });
    }


    public int getItemCount() {
        return fundations_listas.size();
    }
}
