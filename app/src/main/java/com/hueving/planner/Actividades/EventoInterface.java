package com.hueving.planner.Actividades;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventoInterface {
    @GET("Eventos/")
    Call<List<Item_evento>> ListarEventos();

}
