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

public class MainActivity4 extends AppCompatActivity {
    Button btnRegresar;
    Button btnPagar;
    EditText refrescos1;
    EditText refrescos2;
    EditText refrescos3;
    double precioTotal1;
    double precio1 = 17.00;
    double precio2 = 17.00;
    double precio3 = 17.00;
    int cantidad01 = 0;
    int cantidad02 = 0;
    int cantidad03 = 0;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnRegresar = findViewById(R.id.regresar);
        btnPagar = findViewById(R.id.pagar);
        refrescos1 = findViewById(R.id.refresco1);
        refrescos2 = findViewById(R.id.refresco2);
        refrescos3 = findViewById(R.id.refresco3);
        sharedPreferences = getSharedPreferences("PizzeriaDeVitoLugini", Context.MODE_PRIVATE);


        btnRegresar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
            startActivity(intent);
            finish();
        });


        btnPagar.setOnClickListener(v -> {
            actualizarCantidades();
            calcularPrecioTotal();

            if (cantidad01 == 0 && cantidad02 == 0 && cantidad03 == 0) {
                Toast.makeText(MainActivity4.this, "Debe seleccionar al menos un producto", Toast.LENGTH_SHORT).show();
            } else {
                // Guarda los datos en SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("cantidad01", cantidad01);
                editor.putInt("cantidad02", cantidad02);
                editor.putInt("cantidad03", cantidad03);
                editor.putFloat("precioTotal1", (float) precioTotal1);
                editor.apply();

                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });

        restaurarEstado();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    public void actualizarCantidades() {
        cantidad01 = obtenerCantidad(refrescos1);
        cantidad02 = obtenerCantidad(refrescos2);
        cantidad03 = obtenerCantidad(refrescos3);
    }

    public void calcularPrecioTotal() {
        precioTotal1 = (cantidad01 * precio1) + (cantidad02 * precio2) + (cantidad03 * precio3);
        int totalBebidas = cantidad01 + cantidad02 + cantidad03; // Corregir el cálculo
        Toast.makeText(MainActivity4.this, "Has elegido " + totalBebidas + " bebidas.", Toast.LENGTH_SHORT).show();
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
        editor.putInt("cantidad01", cantidad01);
        editor.putInt("cantidad02", cantidad02);
        editor.putInt("cantidad03", cantidad03);
        editor.putFloat("precioTotal1", (float) precioTotal1);
        editor.apply();
    }

    public void restaurarEstado() {
        cantidad01 = sharedPreferences.getInt("cantidad01", 0);
        cantidad02 = sharedPreferences.getInt("cantidad02", 0);
        cantidad03 = sharedPreferences.getInt("cantidad03", 0);
        precioTotal1 = sharedPreferences.getFloat("precioTotal1", 0.0f);

        refrescos1.setText(String.valueOf(cantidad01));
        refrescos2.setText(String.valueOf(cantidad02));
        refrescos3.setText(String.valueOf(cantidad03));
    }
}

