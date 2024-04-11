package com.example.pizzeriaapp;

import android.content.Intent;
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

public class MainActivity5 extends AppCompatActivity {

    Button btnenviar;
    EditText Pizzas, Bebidas;
    EditText Total;
    TextView Usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        btnenviar = findViewById(R.id.enviar);
        Pizzas = findViewById(R.id.pizzas);
        Bebidas = findViewById(R.id.bebidas);
        Usuario = findViewById(R.id.bienvenidos);
        Total = findViewById(R.id.Total);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                if (intent != null) {
                    int cantidad1 = intent.getIntExtra("cantidad 1", 0);
                    int cantidad2 = intent.getIntExtra("cantidad 2", 0);
                    int cantidad3 = intent.getIntExtra("cantidad 3", 0);
                    double precioTotal = intent.getDoubleExtra("precioTotal", 0.0);


                    Pizzas.setText("Pizzas:\n" +
                            "Pizza 1: " + cantidad1 + "\n" +
                            "Pizza 2: " + cantidad2 + "\n" +
                            "Pizza 3: " + cantidad3 + "\n" +
                            "Precio Total de Pizzas: $" + precioTotal);
                }


                if (intent != null) {
                    int cantidad01 = intent.getIntExtra("cantidad 1", 0);
                    int cantidad02 = intent.getIntExtra("cantidad 2", 0);
                    int cantidad03 = intent.getIntExtra("cantidad 3", 0);
                    double precioTotal1 = intent.getDoubleExtra("precioTotal1", 0.0);


                    Bebidas.setText("Bebidas:\n" +
                            "Bebida 1: " + cantidad01 + "\n" +
                            "Bebida 2: " + cantidad02 + "\n" +
                            "Bebida 3: " + cantidad03 + "\n" +
                            "Precio Total de Bebidas: $" + precioTotal1);
                }

                Toast.makeText(MainActivity5.this, "Gracias por utilizar la App de VitoLuigini", Toast.LENGTH_SHORT).show();
            }
        });

    };
}