package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.Credentials;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsurame, etPassword;
    private Button btnEnviar;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("com.example.app2.MyAPPY", MODE_PRIVATE);


        etUsurame = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btnEnviar = findViewById(R.id.btnEnviar);

        setUpLoginButton();


    }
    private void  setUpLoginButton(){
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String credentials = Credentials.basic(etUsurame.getText().toString(), etPassword.getText().toString());

                SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
                sharedEditor.putString("AUTHORIZATION", credentials);
                sharedEditor.apply();

                redirectToFormContactActivity();

            }
        });
    }

    private  void redirectToFormContactActivity(){
        Intent intent = new Intent(getApplicationContext(), FormContactActivity.class);
        startActivity(intent);
    }
}