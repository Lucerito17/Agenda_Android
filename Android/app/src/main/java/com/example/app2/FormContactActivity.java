package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.app2.entities.Contact;
import com.example.app2.services.ContactService;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormContactActivity extends AppCompatActivity {

    TextView edName, edLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contact);

        edName = findViewById(R.id.etName);
        edLastName = findViewById(R.id.etLastName);

        /*Contact contact = new Contact();
        contact.nombre = "Lucerito";
        contact.apellido = "Carrasco";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63587803c26aac906f42ccd3.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService services = retrofit.create(ContactService.class);
        services.create(contact).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.i("MAIN_APP", "Response: "+response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });*/
    }
    public void enviar (View v){
        String name = edName.getText().toString();
        String lastname = edLastName.getText().toString();
        Contact contact = new Contact();
        contact.nombre = name;
        contact.apellido = lastname;

        postRetrofit(contact);
    }

    public void postRetrofit(Contact contact){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63587803c26aac906f42ccd3.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService services = retrofit.create(ContactService.class);
        services.create(contact).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.i("MAIN_APP", "Response: "+response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}