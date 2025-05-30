package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private CardView cardViewMilk;
    private Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos vistas
        cardViewMilk = findViewById(R.id.cardViewMilk);
        buttonExit = findViewById(R.id.button_Exit);

        // Listener para la tarjeta de Leche
        cardViewMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Has pulsado en Leche", Toast.LENGTH_SHORT).show();
                // Puedes abrir otra actividad si quieres:
                Intent intent = new Intent(MainActivity.this, MilkActivity.class);
                 startActivity(intent);
            }
        });

        // Botón de salida
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad
            }
        });
    }
}
