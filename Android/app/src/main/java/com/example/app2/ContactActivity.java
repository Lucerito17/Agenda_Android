package com.example.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app2.adapters.ContactAdapter;
import com.example.app2.adapters.StringAdapter;
import com.example.app2.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private RecyclerView rvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        List<Contact> contactos = new ArrayList<>();

        Contact contact = new Contact();
        Contact contact2 = new Contact();
        Contact contact3 = new Contact();

        contact.id = 1;
        contact.apellido= "Cadelaro";
        contact.nombre = "Luka";
        contact.numero = 943625120;
        contact.imgUrl = "https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-PNG-Photos.png";
        contactos.add(contact);

        contact2.id = 2;
        contact2.apellido= "Diamante";
        contact2.nombre = "Lila";
        contact2.numero = 924625540;
        contact2.imgUrl = "https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-Vector-PNG-Photos.png";
        contactos.add(contact2);

        contact3.id = 3;
        contact3.apellido= "Miraflores";
        contact3.nombre = "Pepi";
        contact3.numero = 926525540;
        contact3.imgUrl = "https://propami.com/assets/corals/images/avatars/avatar_9.png";
        contactos.add(contact3);

        rvContact = findViewById(R.id.rvContactos);
        rvContact.setLayoutManager(new LinearLayoutManager(this));
        rvContact.setAdapter(new ContactAdapter(contactos));
    }
}