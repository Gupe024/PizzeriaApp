package com.example.pizzeriaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    Button  btnregresar;

    Button btnpagar;

    EditText refrescos1;
    EditText refrescos2;
    EditText refrescos3;
    double precioTotal;
    double precio1 = 17.00;
    double precio2 = 17.00;
    double precio3 = 17.00;
    int cantidad1 = 0;
    int cantidad2 = 0;
    int cantidad3 = 0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnregresar = findViewById(R.id.regresar);
        btnpagar = findViewById(R.id.pagar);
        refrescos1 = findViewById(R.id.refresco1);
        refrescos2 = findViewById(R.id.refresco2);
        refrescos3 = findViewById(R.id.refresco3);

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarCantidades();
                calcularPrecioTotal();
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                intent.putExtra("precioTotal", precioTotal);
                intent.putExtra("Cantidad 1", cantidad1);
                intent.putExtra("Cantidad 2", cantidad2);
                intent.putExtra("Cantidad 3", cantidad3);
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
        cantidad1 = obtenerCantidad(refrescos1);
        cantidad2 = obtenerCantidad(refrescos2);
        cantidad3 = obtenerCantidad(refrescos3);
    }

    public void calcularPrecioTotal() {
        precioTotal = (cantidad1 * precio1) + (cantidad2 * precio2) + (cantidad3 * precio3);

        int totalbebidas = cantidad1 + cantidad2 + cantidad3;

        Toast.makeText(MainActivity4.this, "Has elegido " + totalbebidas + " bebidas.", Toast.LENGTH_SHORT).show();
    }

    public int obtenerCantidad(EditText editText) {
        try {
            return Integer.parseInt(editText.getText().toString().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void  guardarEstado(Bundle outState) {
        outState.putInt("Cantidad 1", cantidad1);
        outState.putInt("Cantidad 2", cantidad2);
        outState.putInt("Cantidad 3", cantidad3);
        outState.putDouble("precioTotal", precioTotal);
    }

    public void restaurarEstado(Bundle savedInstanceState) {
        cantidad1 = savedInstanceState.getInt("Cantidad 1");
        cantidad2 = savedInstanceState.getInt("Cantidad 2");
        cantidad3 = savedInstanceState.getInt("Cantidad 3");
        precioTotal = savedInstanceState.getDouble("precioTotal");
        refrescos1.setText(String.valueOf(cantidad1));
        refrescos2.setText(String.valueOf(cantidad2));
        refrescos3.setText(String.valueOf(cantidad3));
    }
}