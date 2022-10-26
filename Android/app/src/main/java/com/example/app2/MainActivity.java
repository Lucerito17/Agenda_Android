package com.example.app2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.adapters.StringAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> nombres = new ArrayList<>();
        nombres.add("Luka");
        nombres.add("Felix");
        nombres.add("Elsa");

        rvNombres = findViewById(R.id.rvNombres);
        rvNombres.setLayoutManager(new LinearLayoutManager(this));
        rvNombres.setAdapter(new StringAdapter(nombres));
    }
}