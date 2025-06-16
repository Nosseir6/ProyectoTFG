package com.example.proyectofinal.fish;

import android.os.Bundle;

import com.example.proyectofinal.R;

public class PescadoActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_pescado, findViewById(R.id.content_frame));
        setTitle("Inicio");
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.drawer_base;
    }
}