package com.example.proyectofinal.meat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;

public class ConductivityFragment extends Fragment {

    private SeekBar ceSeekBar;
    private TextView ceText, ceEstado;
    private ImageView carneImage;

    public ConductivityFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carne_conductivity, container, false);

        ceSeekBar = view.findViewById(R.id.seekBarCE);
        ceText = view.findViewById(R.id.ceValueText);
        ceEstado = view.findViewById(R.id.ceEstadoText);
        carneImage = view.findViewById(R.id.ceImage);

        ceSeekBar.setMax(20); // simulamos 0.5 a 2.5 mS/cm
        ceSeekBar.setProgress(10); // valor inicial ~1.5 mS/cm

        actualizarVista(1.5f);

        ceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float ce = 0.5f + (progress / 10f); // 0.5 a 2.5 mS/cm
                ceText.setText(String.format("Conductividad: %.1f mS/cm", ce));
                actualizarVista(ce);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        return view;
    }

    private void actualizarVista(float ce) {
        if (ce < 1.0f) {
            carneImage.setImageResource(R.drawable.ce_baja);
            ceEstado.setText("⚠️ Baja CE: carne probablemente seca o vieja.");
            ceEstado.setTextColor(Color.parseColor("#C62828"));
        } else if (ce <= 2.0f) {
            carneImage.setImageResource(R.drawable.ce_normal);
            ceEstado.setText("✅ Conductividad normal. Buena frescura.");
            ceEstado.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            carneImage.setImageResource(R.drawable.ce_alta);
            ceEstado.setText("⚠️ Alta CE: posible contaminación o mala conservación.");
            ceEstado.setTextColor(Color.parseColor("#F9A825"));
        }
    }
}
