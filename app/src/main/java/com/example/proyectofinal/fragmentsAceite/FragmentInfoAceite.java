package com.example.proyectofinal.fragmentsAceite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;

public class FragmentInfoAceite extends Fragment {

    public FragmentInfoAceite() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Información");
        }

        return inflater.inflate(R.layout.fragment_info_aceite, container, false);
    }
}
