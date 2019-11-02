package com.hueving.planner.Actividades.Adaptadores;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hueving.planner.R;

public class EventosHolder extends RecyclerView.ViewHolder {
    ImageView imagen_evento;
    TextView txt_evento;
    CardView cv;
    Context context;
    String id;


    public EventosHolder(@NonNull View itemView, final Context c) {
        super(itemView);
        imagen_evento = itemView.findViewById(R.id.imagen_evento);
        txt_evento = itemView.findViewById(R.id.txt_evento);
        this.context = c;
        cv=itemView.findViewById(R.id.card_view_eventos);



    }
}
