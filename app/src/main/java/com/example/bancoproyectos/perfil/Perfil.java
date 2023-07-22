package com.example.bancoproyectos.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bancoproyectos.MainActivitylistado;
import com.example.bancoproyectos.R;
import com.example.bancoproyectos.api.PerfilApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Perfil extends AppCompatActivity {

    private static final String TAG = "perfil";
    private Retrofit retrofit;
    private TextView T1;
    private ImageView img;
    PerfilAdapter perfilAdapter;

    private static final String BASE_URL = "https://lexa2334.pythonanywhere.com/api/"; // Cambia esta URL por la URL de tu API


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        T1 = findViewById(R.id.text1);
        img = findViewById(R.id.imageView12);


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();



        }
        PerfilApiService apiService = retrofit.create(PerfilApiService.class);
        int idToFind = 2; // Reemplaza 123 por el ID específico que deseas buscar
        Call<Perfils> call = apiService.getPerfil(idToFind);
        call.enqueue(new Callback<Perfils>()


        {

            @Override
            public void onResponse(Call<Perfils> call, Response<Perfils> response) {
                if (response.isSuccessful()) {
                    Perfils perfilEncontrado = response.body();

                    if (perfilEncontrado != null) {

                        int id = perfilEncontrado.getId();
                        String foto = perfilEncontrado.getFoto();
                        String nombre = perfilEncontrado.getUsername();
                    }
                }

            }

            @Override
            public void onFailure(Call<Perfils> call, Throwable t) {

            }

        });


    }


    public void onClick(View view) {


        Intent intent = new Intent(Perfil.this, MainActivitylistado.class);
        startActivity(intent);
    }




}



