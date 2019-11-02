package com.hueving.planner.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.hueving.planner.Actividades.Adaptadores.EventosAdaptador;
import com.hueving.planner.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Evento extends AppCompatActivity {
    TextView textView;
    RecyclerView recycler_evento;
    List<Item_evento> eventos_data;
    SearchView search;
    EventosAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        textView = findViewById(R.id.textView);
        search = findViewById(R.id.search);
        recycler_evento = findViewById(R.id.recycler_eventos);


        eventos_data = new ArrayList<>();
        eventos_data.add(new Item_evento("1", "", "Bodas"));
        eventos_data.add(new Item_evento("2", "", "Cumpleaños"));
        eventos_data.add(new Item_evento("3", "", "Dspedida Solteros"));
        eventos_data.add(new Item_evento("4", "", "Baby Shower"));
        ConstruirRecycler();
        adaptador.notifyDataSetChanged();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                List<Item_evento> a = new ArrayList<>();
                for (Item_evento eventos : eventos_data) {
                    if (eventos.txt_evento.toLowerCase().contains(newText)) {
                        a.add(eventos);
                    }
                }
                EventosAdaptador adaptador = new EventosAdaptador(Evento.this, R.layout.item_evento, a);
                recycler_evento.setAdapter(adaptador);
                recycler_evento.setLayoutManager(new LinearLayoutManager(Evento.this));
                return false;
            }
        });
    }
    void ConstruirRecycler() {
        adaptador = new EventosAdaptador(this, R.layout.item_evento, eventos_data);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(Evento.this, ServicioEvento.class);
                //intent.putExtra("id_song", eventos_data.get(recycler_evento.getChildAdapterPosition(view)).getId());
                //startActivityForResult(intent, 1);
            }
        });
        recycler_evento.setAdapter(adaptador);
        recycler_evento.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.8.251:8000/polls/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EventoInterface servicios = retrofit.create(EventoInterface.class);
        Call<List<Item_evento>> call = servicios.ListarEventos();
        call.enqueue(new Callback<List<Item_evento>>() {
            @Override
            public void onResponse(Call<List<Item_evento>> call, Response<List<Item_evento>> response) {
                Log.e("Eventos",response.body()+"");
            }

            @Override
            public void onFailure(Call<List<Item_evento>> call, Throwable t) {
                Log.e("Error",t.toString());

            }
        });


    }
}
