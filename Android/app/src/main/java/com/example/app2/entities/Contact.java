package com.example.app2.entities;

import com.google.gson.annotations.SerializedName;

public class Contact {
    public int id;
    @SerializedName("name")
    public String nombre;
    @SerializedName("lastname")
    public String apellido;
    public int numero;
    public String imgUrl;
}
