package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;

import com.example.app2.adapters.ContactAdapter;
import com.example.app2.adapters.RazasAdapter;
import com.example.app2.entities.RazaPerro;
import com.example.app2.services.RazaDePerro;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RazaActivity extends AppCompatActivity {

    private RecyclerView rvRazas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thedogapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RazaDePerro service = retrofit.create(RazaDePerro.class);
        service.getAll(3,0).enqueue(new Callback<List<RazaPerro>>() {
            @Override
            public void onResponse(Call<List<RazaPerro>> call, Response<List<RazaPerro>> response) {
                List<RazaPerro> data = response.body();
                rvRazas = findViewById(R.id.rvRazas);
                rvRazas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvRazas.setAdapter(new RazasAdapter(data));
                Log.i("MAIN_APP", "Response: "+response.body().size());
                Log.i("MAIN_APP", new Gson().toJson(data));
            }

            @Override
            public void onFailure(Call<List<RazaPerro>> call, Throwable t) {

            }
        });
    }
}