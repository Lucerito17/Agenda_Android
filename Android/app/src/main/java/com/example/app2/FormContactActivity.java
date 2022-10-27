package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app2.entities.Contact;
import com.example.app2.factories.RetrofitFactory;
import com.example.app2.services.ContactService;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.security.PublicKey;
import java.util.List;

import okhttp3.Interceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormContactActivity extends AppCompatActivity {

    TextView edName, edLastName;
    private SharedPreferences sharedPreferences;
    private Button btnSalir, btnLista, btnActu;
    EditText etEliminar, etNo, etAp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contact);

        edName = findViewById(R.id.etName);
        edLastName = findViewById(R.id.etLastName);
        btnSalir = findViewById(R.id.btnSalir);
        etEliminar = findViewById(R.id.etEliminar);
        btnLista = findViewById(R.id.btnLista);
        btnActu = findViewById(R.id.btnActu);
        etNo = findViewById(R.id.etNo);
        etAp = findViewById(R.id.etAp);

        lista();
        setUpSalir();


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

    public void delete(View v){
        String id = etEliminar.getText().toString();
        postdelete(Integer.parseInt(id));
    }

    public void postdelete(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63587803c26aac906f42ccd3.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ContactService service = retrofit.create(ContactService.class);
        service.delete(id).enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                Contact contact = response.body();
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

            }
        });
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

    private void  setUpSalir(){
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToLoginActivity();
            }
        });
    }

    private  void redirectToLoginActivity(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void lista(){
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToListContacts();
            }
        });
    }
    private  void redirectToListContacts(){
        Intent intent = new Intent(getApplicationContext(), VerListaContactos.class);
        startActivity(intent);
    }

    public void actualizar(View v){
        String id = etEliminar.getText().toString();
        Contact contact = new Contact();
        contact.nombre = etNo.getText().toString();
        contact.apellido = etAp.getText().toString();
        postActu(contact, Integer.parseInt(id));
    }

    private void postActu(Contact contact, int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63587803c26aac906f42ccd3.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ContactService service = retrofit.create(ContactService.class);
        service.update(contact, id).enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                Contact contact = response.body();
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

            }
        });
    }
}