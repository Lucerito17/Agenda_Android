package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.app2.adapters.ContactAdapter;
import com.example.app2.adapters.RazasAdapter;
import com.example.app2.entities.Contact;
import com.example.app2.entities.RazaPerro;
import com.example.app2.services.ContactService;
import com.example.app2.services.RazaDePerro;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerListaContactos extends AppCompatActivity {

    private RecyclerView rvContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista_contactos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63587803c26aac906f42ccd3.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService service = retrofit.create(ContactService.class);
        service.all().enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                List<Contact> data = response.body();
                rvContactos = findViewById(R.id.rvLista);
                rvContactos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvContactos.setAdapter(new ContactAdapter(data));
                Log.i("MAIN_APP", "Response: "+response.body().size());
                Log.i("MAIN_APP", new Gson().toJson(data));
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
    }
}