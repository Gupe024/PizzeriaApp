package com.example.pizzeriaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    Button btnEnviar;
    TextView pizzasEditText;
    TextView bebidasEditText;
    TextView totalEditText;
    TextView usuarioTextView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btnEnviar = findViewById(R.id.enviar);
        pizzasEditText = findViewById(R.id.textViewPizzas);
        bebidasEditText = findViewById(R.id.textViewBebidas);
        totalEditText = findViewById(R.id.textViewTotal);
        usuarioTextView = findViewById(R.id.bienvenidos);

        sharedPreferences = getSharedPreferences("PizzeriaDeVitoLugini", Context.MODE_PRIVATE);

        String usuario = sharedPreferences.getString("usuario", "Usuario");
        int cantidad1 = sharedPreferences.getInt("cantidad1", 0);
        int cantidad2 = sharedPreferences.getInt("cantidad2", 0);
        int cantidad3 = sharedPreferences.getInt("cantidad3", 0);
        int cantidad01 = sharedPreferences.getInt("cantidad01", 0);
        int cantidad02 = sharedPreferences.getInt("cantidad02", 0);
        int cantidad03 = sharedPreferences.getInt("cantidad03", 0);
        float totalPagar = sharedPreferences.getFloat("precioTotal", 0.0f) + sharedPreferences.getFloat("precioTotal1", 0.0f);

        usuarioTextView.setText("Estimado " + usuario);
        pizzasEditText.setText("Has seleccionado " + cantidad1 + " pizza de jamón y queso, " + cantidad2 + " pizza de peperoni, " + cantidad3 + " pizza hawaiana.");
        bebidasEditText.setText("Has seleccionado " + cantidad01 + " Coca-Cola, " + cantidad02 + " Pepsi, " + cantidad03 + " Fanta.");
        totalEditText.setText("Total a pagar: $" + totalPagar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity5.this, "Gracias por utilizar la App de VitoLugini... su pedido fue recibido y en breve se enviará.", Toast.LENGTH_SHORT).show();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                usuarioTextView.setText("");
                pizzasEditText.setText("");
                bebidasEditText.setText("");
                totalEditText.setText("");

                Intent intent = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
