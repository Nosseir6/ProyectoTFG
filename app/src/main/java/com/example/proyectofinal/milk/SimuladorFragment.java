package com.example.proyectofinal.milk;

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

public class SimuladorFragment extends Fragment {

    private SeekBar phSeekBar;
    private TextView phText, mensajeEstado;
    private ImageView milkImageView;

    public SimuladorFragment() {
        // Constructor público vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_simulador, container, false);

        // Referencias a vistas desde el layout
        phSeekBar = view.findViewById(R.id.phSeekBar);
        phText = view.findViewById(R.id.phText);

        phSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                phText.setText("pH: " + value);
                actualizarVisualSegunPH(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No necesario
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // No necesario
            }
        });

        return view;
    }

    private void actualizarVisualSegunPH(int ph) {
        if (ph < 5) {
            milkImageView.setImageResource(R.drawable.leche_acida);
            mensajeEstado.setText("⚠️ Acidez muy alta. La leche podría estar fermentada.");
            mensajeEstado.setTextColor(Color.parseColor("#C62828"));
        } else if (ph >= 5 && ph <= 8) {
            milkImageView.setImageResource(R.drawable.leche_normal);
            mensajeEstado.setText("✅ ¡Perfecto! Esta leche es fresca y saludable.");
            mensajeEstado.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            milkImageView.setImageResource(R.drawable.leche_basica);
            mensajeEstado.setText("⚠️ pH alto. La leche podría haber sido tratada químicamente.");
            mensajeEstado.setTextColor(Color.parseColor("#EF6C00"));
        }
    }

    private void actualizarVisualSegunAcidez(int acidez) {
        if (acidez < 3) {
            milkImageView.setImageResource(R.drawable.leche_acida);
            mensajeEstado.setText("⚠️ Acidez extrema. No es apta para consumo.");
            mensajeEstado.setTextColor(Color.parseColor("#B71C1C"));
        } else if (acidez <= 6) {
            milkImageView.setImageResource(R.drawable.leche_basica);
            mensajeEstado.setText("✅ Nivel de acidez óptimo.");
            mensajeEstado.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            milkImageView.setImageResource(R.drawable.leche_agria);
            mensajeEstado.setText("⚠️ Acidez algo elevada. Consumir con precaución.");
            mensajeEstado.setTextColor(Color.parseColor("#F9A825"));
        }
    }

    private void actualizarVisualSegunDensidad(int densidad) {
        if (densidad < 4) {
            milkImageView.setImageResource(R.drawable.leche_aguada);
            mensajeEstado.setText("⚠️ Leche diluida. Baja calidad nutricional.");
            mensajeEstado.setTextColor(Color.parseColor("#6A1B9A"));
        } else if (densidad <= 10) {
            milkImageView.setImageResource(R.drawable.leche_densidad_normal);
            mensajeEstado.setText("✅ Densidad normal. Buena calidad.");
            mensajeEstado.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            milkImageView.setImageResource(R.drawable.leche_espesa);
            mensajeEstado.setText("⚠️ Densidad alta. Posible presencia de sólidos.");
            mensajeEstado.setTextColor(Color.parseColor("#EF6C00"));
        }
    }
}
