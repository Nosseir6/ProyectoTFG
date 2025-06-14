package com.example.proyectofinal.meat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import com.example.proyectofinal.R;
import com.google.android.material.navigation.NavigationView;

public class MeatActivity extends AppCompatActivity{

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

            switch (item.getItemId()) {
                case R.id.nav_intro:
                    selectedFragment = new IntroductionFragment();
                    break;
                case R.id.nav_composicion:
                    selectedFragment = new CompositionFragment();
                    break;
                case R.id.nav_ph_higiene:
                    selectedFragment = new HealthFragment();
                    break;
                case R.id.nav_calidad:
                    selectedFragment = new ConductivityActivity();
                    break;
                case R.id.nav_cra:
                    selectedFragment = new ClasificacionFragment();
                    break;
                case R.id.nav_conductividad:
                    selectedFragment = new ConductividadFragment();
                    break;
                case R.id.nav_contaminantes:
                    selectedFragment = new ContaminantesFragment();
                    break;
                case R.id.nav_microorganismos:
                    selectedFragment = new MicroorganismosFragment();
                    break;
                case R.id.nav_dietetica:
                    selectedFragment = new AplicacionesDieteticasFragment();
                    break;
                case R.id.nav_checklist:
                    selectedFragment = new ChecklistFragment();
                    break;
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
                    .replace(R.id.content_frame_meat, new CarneIntroduccionFragment())
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
