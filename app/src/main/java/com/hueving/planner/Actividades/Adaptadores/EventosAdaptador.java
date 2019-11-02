package com.hueving.planner.Actividades.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.hueving.planner.Actividades.Item_evento;

import java.util.List;

public class EventosAdaptador extends RecyclerView.Adapter<EventosHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    List<Item_evento> data;
    Context context;
    int layout;
    private View.OnClickListener listener;

    public EventosAdaptador(Context context, int layout, List<Item_evento> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
        this.layout = layout;

    }

    @NonNull
    @Override
    public EventosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(layout, parent, false);
        v.setOnClickListener(this);
        return new EventosHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull EventosHolder holder, int position) {
        holder.txt_evento.setText(data.get(position).getTxt_evento());
        Glide.with(context).load(data.get(position).getImagen_evento()).into(holder.imagen_evento);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener =listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }
}