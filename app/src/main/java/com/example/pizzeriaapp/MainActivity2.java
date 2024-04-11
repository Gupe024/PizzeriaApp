package com.example.pizzeriaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button btnPizzas;
    Button btnBebidas;

    Button btnregresar;
    Button btnpagar;

    TextView bienvenidos;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnPizzas = findViewById(R.id.pizzas);
        btnBebidas = findViewById(R.id.bebidas);
        btnregresar = findViewById(R.id.regresar);
        btnpagar = findViewById(R.id.pagar);
        bienvenidos = findViewById(R.id.Bienvenidos);

        btnPizzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }

        });

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("usuario")) {
            String usuario = intent.getStringExtra("usuario");
            bienvenidos.setText("Bienvenida " + usuario);
        }

    }
}