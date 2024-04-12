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

public class MainActivity3 extends AppCompatActivity {

    Button btnRegresar;
    Button btnPagar;
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

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnRegresar = findViewById(R.id.regresar);
        btnPagar = findViewById(R.id.pagar);
        pizza1 = findViewById(R.id.pizza1);
        pizza2 = findViewById(R.id.pizza2);
        pizza3 = findViewById(R.id.pizza3);

        sharedPreferences = getSharedPreferences("PizzeriaDeVitoLugini", Context.MODE_PRIVATE);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actualizarCantidades();
                calcularPrecioTotal();

                if (cantidad1 == 0 && cantidad2 == 0 && cantidad3 == 0) {
                    Toast.makeText(MainActivity3.this, "Debe seleccionar al menos un producto", Toast.LENGTH_SHORT).show();
                } else {

                    guardarEstado();

                    Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
                    intent.putExtra("precioTotal", precioTotal);
                    intent.putExtra("Cantidad1", cantidad1);
                    intent.putExtra("Cantidad2", cantidad2);
                    intent.putExtra("Cantidad3", cantidad3);
                    startActivity(intent);
                }
            }
        });

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarCantidades();
                calcularPrecioTotal();

                if (cantidad1 == 0 && cantidad2 == 0 && cantidad3 == 0) {
                    Toast.makeText(MainActivity3.this, "Debe seleccionar al menos un producto", Toast.LENGTH_SHORT).show();
                } else {
                    guardarEstado();
                    Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                    intent.putExtra("precioTotal", precioTotal);
                    intent.putExtra("Cantidad1", cantidad1);
                    intent.putExtra("Cantidad2", cantidad2);
                    intent.putExtra("Cantidad3", cantidad3);
                    startActivity(intent);
                }
            }
        });

        restaurarEstado();
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

    public void guardarEstado() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("cantidad1", cantidad1);
        editor.putInt("cantidad2", cantidad2);
        editor.putInt("cantidad3", cantidad3);
        editor.putFloat("precioTotal", (float) precioTotal);
        editor.apply();
    }

    public void restaurarEstado() {
        cantidad1 = sharedPreferences.getInt("cantidad1", 0);
        cantidad2 = sharedPreferences.getInt("cantidad2", 0);
        cantidad3 = sharedPreferences.getInt("cantidad3", 0);
        precioTotal = sharedPreferences.getFloat("precioTotal", 0.0f);
        pizza1.setText(String.valueOf(cantidad1));
        pizza2.setText(String.valueOf(cantidad2));
        pizza3.setText(String.valueOf(cantidad3));
    }
}
