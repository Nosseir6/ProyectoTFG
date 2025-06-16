package com.example.proyectofinal.milk;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;
import com.google.android.material.navigation.NavigationView;

public class MilkActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk); // Usa el XML actualizado con DrawerLayout

        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();
            Fragment selectedFragment = null;

            if (id == R.id.nav_intro) {
                selectedFragment = new IntroduccionFragment();
            } else if (id == R.id.nav_parametros) {
                selectedFragment = new ParametrosFragment();
            } else if (id == R.id.nav_simulador) {
                selectedFragment = new SimuladorFragment();
            } else if (id == R.id.nav_comparador) {
                selectedFragment = new ComparadorFragment();
            } else if(id == R.id.nav_out){
                startActivity(new Intent(this, com.example.proyectofinal.MainActivity.class));
                finish(); // Opcional: cierra la MilkActivity para que no quede en el back stack
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, selectedFragment)
                        .commit();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, new IntroduccionFragment())
                    .commit();
            navView.setCheckedItem(R.id.nav_intro); // Marca el ítem como seleccionado
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