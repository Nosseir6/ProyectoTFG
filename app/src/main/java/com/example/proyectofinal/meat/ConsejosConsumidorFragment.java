package com.example.proyectofinal.meat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.proyectofinal.R;

public class ConsejosConsumidorFragment extends Fragment {

    public ConsejosConsumidorFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Cambiar título del Toolbar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Consejos Consumidor");
        }
        return inflater.inflate(R.layout.fragment_carne_consejos, container, false);
    }
}
