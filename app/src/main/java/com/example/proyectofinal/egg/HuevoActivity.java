package com.example.proyectofinal.egg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectofinal.MainActivity;
import com.example.proyectofinal.egg.CascaraActivity;
import com.example.proyectofinal.egg.ClaraActivity;
import com.example.proyectofinal.R;
import com.example.proyectofinal.egg.SaberMasActivity;
import com.example.proyectofinal.egg.YemaActivity;
import com.example.proyectofinal.fish.PescadoActivity;

public class HuevoActivity extends AppCompatActivity {

    ImageButton botonCascara;
    ImageButton botonClara;
    ImageButton botonYema;
    Button btnInfografia;
    Button btnSaberMas;
    Button btnSimulador;
    Button btnMenuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_huevo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botonCascara = findViewById(R.id.BtnCascara);
        botonClara = findViewById(R.id.BtnClara);
        botonYema = findViewById(R.id.BtnYema);
        btnInfografia = findViewById(R.id.btnInfografia);
        btnSimulador = findViewById(R.id.btnSimulador);
        btnSaberMas = findViewById(R.id.btnSaberMas);
        btnMenuPrincipal = findViewById(R.id.btn_menu_principal_huevo);


        botonCascara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HuevoActivity.this, CascaraActivity.class);
                startActivity(intent);
            }
        });


        botonClara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HuevoActivity.this, ClaraActivity.class);
                startActivity(intent);
            }
        });

        botonYema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HuevoActivity.this, YemaActivity.class);
                startActivity(intent);
            }
        });

        btnInfografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HuevoActivity.this, HuevoActivity.class);
                startActivity(intent);
            }
        });

        btnSimulador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HuevoActivity.this, SimuladorActivity.class);
                startActivity(intent);
            }
        });

        btnSaberMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HuevoActivity.this, SaberMasActivity.class);
                startActivity(intent);
            }
        });

        btnMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HuevoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
