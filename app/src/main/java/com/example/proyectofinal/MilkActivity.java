package com.example.proyectofinal;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MilkActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ScrollView scrollView;

    private View sectionParametros;
    private View sectionSimulador;
    private View sectionComparativa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk); // Cambia "tu_layout" por el nombre correcto de tu XML

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        scrollView = findViewById(R.id.mainScroll);

        sectionParametros = findViewById(R.id.sectionParametros);
        sectionSimulador = findViewById(R.id.sectionSimulador);
        sectionComparativa = findViewById(R.id.sectionComparativa);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Activar ícono del menú hamburguesa
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.iconoHuevo); // Asegúrate de tener este icono

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                View targetView = null;

                int itemId = item.getItemId();

                if (itemId == R.id.nav_parametros) {
                    targetView = sectionParametros;
                } else if (itemId == R.id.nav_simulador) {
                    targetView = sectionSimulador;
                } else if (itemId == R.id.nav_comparativa) {
                    targetView = sectionComparativa;
                }


                if (targetView != null) {
                    final View finalTargetView = targetView;
                    scrollView.post(() -> scrollView.smoothScrollTo(0, finalTargetView.getTop()));
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    // Para abrir el drawer al pulsar el icono de menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}