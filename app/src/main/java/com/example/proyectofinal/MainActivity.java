package com.example.proyectofinal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.proyectofinal.fragments.*;
import com.google.android.material.navigation.NavigationView;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        // Cargar fragmento inicial
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FragmentInfo())
                    .commit();
            navView.setCheckedItem(R.id.nav_que_es);
        }
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_composicion) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FragmentComposicion())
                    .commit();
        } else if (id == R.id.nav_que_es) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FragmentInfo())
                    .commit();
        } else if (id == R.id.nav_parametros) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FragmentParametros())
                    .commit();
        } else if (id == R.id.nav_aplicacion) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FragmentAplicacion())
                    .commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
