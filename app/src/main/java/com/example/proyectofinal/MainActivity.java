package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.proyectofinal.egg.HuevoActivity;
import com.example.proyectofinal.fish.PescadoActivity;
import com.example.proyectofinal.meat.MeatActivity;
import com.example.proyectofinal.milk.MilkActivity;

public class MainActivity extends AppCompatActivity {

    private CardView cardViewMilk;
    private CardView cardViewMeat;
    private CardView cardViewAceite;
    private CardView cardViewHarina;
    private CardView cardViewPescado;
    private CardView cardViewHuevo;

    private Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos vistas
        cardViewMilk = findViewById(R.id.cardViewMilk);
        cardViewMeat = findViewById(R.id.cardViewCarne);
        cardViewAceite = findViewById(R.id.cardViewAceite);
        cardViewHarina = findViewById(R.id.cardViewHarina);
        cardViewPescado = findViewById(R.id.cardViewPescado);
        cardViewHuevo = findViewById(R.id.cardViewHuevo);
        buttonExit = findViewById(R.id.button_Exit);

        // Listener para la tarjeta de Leche
        cardViewMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Puedes abrir otra actividad si quieres:
                Intent intent = new Intent(MainActivity.this, MilkActivity.class);
                 startActivity(intent);
            }
        });

        cardViewMeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MeatActivity.class);
                startActivity(intent);
            }
        });


        cardViewAceite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityAceite.class);
                startActivity(intent);
            }
        });

        cardViewHarina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityHarina.class);
                startActivity(intent);
            }
        });

        cardViewHuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HuevoActivity.class);
                startActivity(intent);
            }
        });

        cardViewPescado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PescadoActivity.class);
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
