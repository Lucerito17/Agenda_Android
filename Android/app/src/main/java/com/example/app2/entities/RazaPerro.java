package com.example.app2.entities;

import com.google.gson.annotations.SerializedName;

public class RazaPerro {
    public int id;
    public String name;
    @SerializedName("bred_for")
    public String bredFor;
    public String temperament;
    public ImagenRazaPerro image;
}
