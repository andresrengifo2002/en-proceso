package com.example.bancoproyectos.api;

import com.example.bancoproyectos.perfil.Perfils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PerfilApiService {
    @GET("/perfil/{id}")
    Call<Perfils> getPerfil(@Path("id") int id);

}
