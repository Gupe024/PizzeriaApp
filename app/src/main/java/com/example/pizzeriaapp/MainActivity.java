package com.example.pizzeriaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText usuarioEditext;
    EditText passwordEditText;
    Button iniciarButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditext = findViewById(R.id.usuario);
        passwordEditText = findViewById(R.id.password);
        iniciarButton = findViewById(R.id.iniciar);

        iniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuarioEditext.getText().toString();
                String pass = passwordEditText.getText().toString();

                if (user.equals("Adriana") & pass.equals("adriana")) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("usuario", user);
                    startActivity(intent);
                } else {

                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}