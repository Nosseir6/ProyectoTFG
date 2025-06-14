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

public class HealthFragment extends Fragment {

    private SeekBar phSeekBar;
    private TextView phText, estadoText;
    private ImageView carneImage;

    public HealthFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__carne_health, container, false);

        phSeekBar = view.findViewById(R.id.seekBarPh);
        phText = view.findViewById(R.id.phValueText);
        estadoText = view.findViewById(R.id.estadoText);
        carneImage = view.findViewById(R.id.carneImage);

        phSeekBar.setMax(20);  // De 5.0 a 7.0 en pasos de 0.1
        phSeekBar.setProgress(12); // Valor inicial ~6.2
        actualizarVista(6.2f);

        phSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float ph = 5.0f + (progress / 10f);
                phText.setText(String.format("pH: %.1f", ph));
                actualizarVista(ph);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        return view;
    }

    private void actualizarVista(float ph) {
        if (ph < 5.4f) {
            carneImage.setImageResource(R.drawable.carne_pse);
            estadoText.setText("⚠️ Carne PSE: textura blanda, color pálido, pH muy bajo.");
            estadoText.setTextColor(Color.parseColor("#C62828"));
        } else if (ph <= 6.0f) {
            carneImage.setImageResource(R.drawable.carne_normal);
            estadoText.setText("✅ Carne fresca: color y textura adecuados, pH normal.");
            estadoText.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            carneImage.setImageResource(R.drawable.carne_dfd);
            estadoText.setText("⚠️ Carne DFD: textura firme, color oscuro, pH elevado.");
            estadoText.setTextColor(Color.parseColor("#EF6C00"));
        }
    }
}
