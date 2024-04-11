package com.example.pizzeriaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    Button Enviar;
    EditText Pizzas, Bebidas, Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        Enviar = findViewById(R.id.enviar);
        Pizzas = findViewById(R.id.pizzas);
        Bebidas = findViewById(R.id.bebidas);

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity5.this, "Gracias por utilizar la App de VitoLuigini", Toast.LENGTH_SHORT).show();
            }
        });

        });
    }
}