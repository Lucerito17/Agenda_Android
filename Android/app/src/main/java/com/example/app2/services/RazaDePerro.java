package com.example.app2.services;

import com.example.app2.entities.RazaPerro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RazaDePerro {
    //https://api.thedogapi.com/v1/breeds?limit=20&page=0
    @GET("v1/breeds")
    //?limit=10&page=1
    Call<List<RazaPerro>> getAll(@Query("limit")int limit,@Query("page") int page);

    @GET("v1/breeds/{razaId}")
    Call<RazaPerro> findById(@Path("razaId") int id);
}
