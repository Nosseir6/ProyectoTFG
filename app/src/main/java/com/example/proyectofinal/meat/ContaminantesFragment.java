package com.example.proyectofinal.meat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.example.proyectofinal.R;

public class ContaminantesFragment extends Fragment {

    public ContaminantesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_carne_contaminantes, container, false);
    }
}
