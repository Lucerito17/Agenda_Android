package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app2.adapters.ContactAdapter;
import com.example.app2.adapters.RazasAdapter;
import com.example.app2.entities.RazaPerro;
import com.example.app2.services.RazaDePerro;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RazaDetalleActivity extends AppCompatActivity {

    ImageView ivImage2;
    TextView tvRaza2;
    TextView tvBredFor2;
    TextView tvTemperament2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raza_detalle);

        ivImage2 = findViewById(R.id.ivImage2);
        tvRaza2 = findViewById(R.id.tvRaza2);
        tvBredFor2 = findViewById(R.id.tvBredFor2);
        tvTemperament2 = findViewById(R.id.tvTemperament2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thedogapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RazaDePerro service = retrofit.create(RazaDePerro.class);
        service.findById(2).enqueue(new Callback<RazaPerro>() {
            @Override
            public void onResponse(Call<RazaPerro> call, Response<RazaPerro> response) {
                RazaPerro data = response.body();

                //Picasso.get().load(data.image.url).into(ivImage2);
                tvRaza2.setText(data.name);
                tvBredFor2.setText(data.bredFor);
                tvTemperament2.setText(data.temperament);
            }

            @Override
            public void onFailure(Call<RazaPerro> call, Throwable t) {

            }
        });
    }
}