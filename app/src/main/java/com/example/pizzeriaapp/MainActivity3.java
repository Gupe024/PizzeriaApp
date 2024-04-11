package com.example.pizzeriaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;

public class MainActivity3 extends AppCompatActivity {
    Button btnregresar;
    Button btnpagar;
    EditText pizza1;
    EditText pizza2;
    EditText pizza3;
    double precioTotal;
    double precio1 = 120.00;
    double precio2 = 135.00;
    double precio3 = 140.00;
    int cantidad1 = 0;
    int cantidad2 = 0;
    int cantidad3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnregresar = findViewById(R.id.regresar);
        btnpagar = findViewById(R.id.pagar);
        pizza1 = findViewById(R.id.pizza1);
        pizza2 = findViewById(R.id.pizza2);
        pizza3 = findViewById(R.id.pizza3);

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPrecioTotal();
                actualizarCantidades();
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("precioTotal", precioTotal);
                intent.putExtra("cantidad1", cantidad1);
                intent.putExtra("cantidad2", cantidad2);
                intent.putExtra("cantidad3", cantidad3);
                startActivity(intent);
            }
        });

        if (savedInstanceState != null) {
            restaurarEstado(savedInstanceState);
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        guardarEstado(outState);
    }

    public void actualizarCantidades() {
        cantidad1 = obtenerCantidad(pizza1);
        cantidad2 = obtenerCantidad(pizza2);
        cantidad3 = obtenerCantidad(pizza3);
    }

    public void calcularPrecioTotal() {
        precioTotal = (cantidad1 * precio1) + (cantidad2 * precio2) + (cantidad3 * precio3);

        int totalPizzas = cantidad1 + cantidad2 + cantidad3;

        Toast.makeText(MainActivity3.this, "Has elegido " + totalPizzas + " pizzas.", Toast.LENGTH_SHORT).show();
    }

    public int obtenerCantidad(EditText editText) {
        try {
            return Integer.parseInt(editText.getText().toString().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void guardarEstado(Bundle outState) {
        outState.putInt("cantidad 1", cantidad1);
        outState.putInt("Cantidad 2", cantidad2);
        outState.putInt("cantidad 3", cantidad3);
    }

    public void  restaurarEstado(Bundle savedInstanceState) {
        cantidad1 = savedInstanceState.getInt("cantidad 1");
        cantidad2 = savedInstanceState.getInt("cantidad 2");
        cantidad3 = savedInstanceState.getInt("cantidad 3");
        precioTotal = savedInstanceState.getDouble("precioTotal");
        pizza1.setText(String.valueOf(cantidad1));
        pizza2.setText(String.valueOf(cantidad2));
        pizza3.setText(String.valueOf(cantidad3));
    }
}