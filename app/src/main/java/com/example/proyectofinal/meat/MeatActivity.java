package com.example.proyectofinal.meat;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import com.example.proyectofinal.R;
import com.google.android.material.navigation.NavigationView;

public class MeatActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat);

        drawerLayout = findViewById(R.id.drawer_layout_meat);
        navView = findViewById(R.id.nav_view_meat);
        toolbar = findViewById(R.id.toolbar_meat);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();

            if (id == R.id.nav_intro) {
                selectedFragment = new IntroductionFragment();
            } else if (id == R.id.nav_composicion) {
                selectedFragment = new ComposicionBasicaFragment();
            } else if (id == R.id.nav_ph_higiene) {
                selectedFragment = new HealthFragment();
            } else if (id == R.id.nav_conductividad) {
                selectedFragment = new ConductivityFragment();
            } else if (id == R.id.nav_clasificacion) {
                selectedFragment = new ClasificacionFragment();
            } else if (id == R.id.nav_contaminantes) {
                selectedFragment = new ContaminantesFragment();
            } else if (id == R.id.nav_consejos) {
                selectedFragment = new ConsejosConsumidorFragment();
            } else if (id == R.id.nav_out) {
                startActivity(new Intent(this, com.example.proyectofinal.MainActivity.class));
                finish(); // Opcional: cierra la MilkActivity para que no quede en el back stack
            }


            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame_meat, selectedFragment)
                        .commit();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame_meat, new IntroductionFragment())
                    .commit();
            navView.setCheckedItem(R.id.nav_intro);
        }
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
