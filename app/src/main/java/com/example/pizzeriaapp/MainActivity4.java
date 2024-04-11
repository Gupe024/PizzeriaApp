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
    double precioTotal1;
    double precio1 = 17.00;
    double precio2 = 17.00;
    double precio3 = 17.00;
    int cantidad01 = 0;
    int cantidad02 = 0;
    int cantidad03 = 0;

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
                intent.putExtra("precioTotal", precioTotal1);
                intent.putExtra("Cantidad 1", cantidad01);
                intent.putExtra("Cantidad 2", cantidad02);
                intent.putExtra("Cantidad 3", cantidad03);
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
        cantidad01 = obtenerCantidad(refrescos1);
        cantidad02 = obtenerCantidad(refrescos2);
        cantidad03 = obtenerCantidad(refrescos3);
    }

    public void calcularPrecioTotal() {
        precioTotal1 = (cantidad01 * precio1) + (cantidad01 * precio2) + (cantidad03 * precio3);

        int totalbebidas = cantidad01 + cantidad02 + cantidad01;

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
        outState.putInt("Cantidad 1", cantidad01);
        outState.putInt("Cantidad 2", cantidad02);
        outState.putInt("Cantidad 3", cantidad03);
        outState.putDouble("precioTotal", precioTotal1);
    }

    public void restaurarEstado(Bundle savedInstanceState) {
        cantidad01 = savedInstanceState.getInt("Cantidad 1");
        cantidad02 = savedInstanceState.getInt("Cantidad 2");
        cantidad03 = savedInstanceState.getInt("Cantidad 3");
        precioTotal1 = savedInstanceState.getDouble("precioTotal");
        refrescos1.setText(String.valueOf(cantidad01));
        refrescos2.setText(String.valueOf(cantidad02));
        refrescos3.setText(String.valueOf(cantidad03));
    }
}