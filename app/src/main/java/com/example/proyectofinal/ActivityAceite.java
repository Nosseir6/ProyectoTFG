package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.fragmentsAceite.FragmentAplicacionesAceite;
import com.example.proyectofinal.fragmentsAceite.FragmentBeneficiosAceite;
import com.example.proyectofinal.fragmentsAceite.FragmentComposicionAceite;
import com.example.proyectofinal.fragmentsAceite.FragmentInfoAceite;
import com.google.android.material.navigation.NavigationView;

public class ActivityAceite extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayoutAceite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aceite);

        Toolbar toolbar = findViewById(R.id.toolbarAceite);
        setSupportActionBar(toolbar);// Asigna el toolbar como barra de acción

        drawerLayoutAceite = findViewById(R.id.drawer_layout_aceite);
        NavigationView navigationView = findViewById(R.id.nav_view_aceite);
        navigationView.setNavigationItemSelectedListener(this);

// abrir y cerrar el menú lateral con animación
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayoutAceite, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayoutAceite.addDrawerListener(toggle);
        toggle.syncState();

        // por defecto
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_aceite, new FragmentInfoAceite()) // BIEN
                    .commit();
            navigationView.setCheckedItem(R.id.nav_que_es_aceite); // BIEN
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
        Fragment selectedFragment = null;

        int id = item.getItemId();
        if (id == R.id.nav_composicion_aceite) {
            selectedFragment = new FragmentComposicionAceite();
        } else if (id == R.id.nav_beneficios_aceite) {
            selectedFragment = new FragmentBeneficiosAceite();
        } else if (id == R.id.nav_aplicaciones_aceite) {
            selectedFragment = new FragmentAplicacionesAceite();
        }else if (id == R.id.nav_que_es_aceite) {
            selectedFragment = new FragmentInfoAceite();
        }else if (id == R.id.nav_out) {
            startActivity(new Intent(this, com.example.proyectofinal.MainActivity.class));
            finish();
        }


        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_aceite, selectedFragment)
                    .commit();
        }

        drawerLayoutAceite.closeDrawer(GravityCompat.START);
        return true;
    }

    //sirve para que no se salga de la app al intentar cerrar el menu lateral
    @Override
    public void onBackPressed() {
        if (drawerLayoutAceite.isDrawerOpen(GravityCompat.START)) {
            drawerLayoutAceite.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
