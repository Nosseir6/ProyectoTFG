package com.example.proyectofinal.fish;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.proyectofinal.fish.BiologicosActivity;
import com.example.proyectofinal.fish.FisicosActivity;
import com.example.proyectofinal.fish.PescadoActivity;
import com.example.proyectofinal.fish.QuimicosActivity;
import com.example.proyectofinal.R;
import com.google.android.material.navigation.NavigationView;

public abstract class BaseDrawerActivity extends AppCompatActivity
{
    protected DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_fisicos && !(this instanceof FisicosActivity)) {
                startActivity(new Intent(this, FisicosActivity.class));
            } else if (id == R.id.nav_quimicos && !(this instanceof QuimicosActivity)) {
                startActivity(new Intent(this, QuimicosActivity.class));
            } else if (id == R.id.nav_biologicos && !(this instanceof BiologicosActivity)) {
                startActivity(new Intent(this, BiologicosActivity.class));
            } else if (id == R.id.nav_inicio && !(this instanceof PescadoActivity)) {
                startActivity(new Intent(this, PescadoActivity.class));
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    protected abstract int getLayoutResourceId();
}
