package com.example.app2.services;

import com.example.app2.entities.Contact;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ContactService {
    //https://63587803c26aac906f42ccd3.mockapi.io/contacts
    @POST("contacts")
    Call<Void> create(@Body Contact contact);//guarda datos

    @PUT("contacts/{id}")
    Call<Void> update(@Body Contact contact, @Path("id") int id);//actualiza datos
}
