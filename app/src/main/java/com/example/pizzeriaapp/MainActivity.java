package com.example.pizzeriaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText usuarioEditText;
    EditText passwordEditText;
    Button iniciarButton;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = findViewById(R.id.usuario);
        passwordEditText = findViewById(R.id.password);
        iniciarButton = findViewById(R.id.iniciar);

        sharedPreferences = getSharedPreferences("PizzasDeVitoLuginiPrefs", Context.MODE_PRIVATE);

        iniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuarioEditText.getText().toString();
                String pass = passwordEditText.getText().toString();

                if (user.equals("Adriana") && pass.equals("adriana")) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("usuario", user);
                    editor.apply();

                    String mensajePersonalizado = "Hola estimad@ " + user + ", ¿qué te podemos llevar hasta tu casa este día? Por favor selecciona:";
                    Toast.makeText(MainActivity.this, mensajePersonalizado, Toast.LENGTH_SHORT).show();

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
