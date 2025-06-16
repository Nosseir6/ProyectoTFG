package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.proyectofinal.fragments.FragmentAplicacion;
import com.example.proyectofinal.fragments.FragmentComposicion;
import com.example.proyectofinal.fragments.FragmentInfo;
import com.example.proyectofinal.fragments.FragmentParametros;
import com.google.android.material.navigation.NavigationView;

public class ActivityHarina extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_harina);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // TextView title = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar); // Asigna el toolbar como barra de acción
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);

        // abrir y cerrar el menú lateral con animación
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Cuando se selecciona un elemento del menú lateral
        navView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        //fragmento inicial
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FragmentInfo())
                    .commit();
            navView.setCheckedItem(R.id.nav_que_es);
        }
    }


    //navegar por la barra lateral
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
        else if (id == R.id.nav_out) {
            startActivity(new Intent(this, com.example.proyectofinal.MainActivity.class));
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //sirve para que no se salga de la app al intentar cerrar el menu lateral
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
