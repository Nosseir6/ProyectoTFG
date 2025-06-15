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

    // pH
    private SeekBar phSeekBar;
    private TextView phText, phMensaje;
    private ImageView phImageView;

    // Acidez
    private SeekBar acidezSeekBar;
    private TextView acidezText, acidezMensaje;
    private ImageView acidezImageView;

    // Temperatura
    private SeekBar tempSeekBar;
    private TextView tempText, tempMensaje;
    private ImageView tempImageView;

    // Densidad
    private SeekBar densidadSeekBar;
    private TextView densidadText, densidadMensaje;
    private ImageView densidadImageView;

    public SimuladorFragment() {
        // Constructor vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simulador, container, false);

        // pH
        phSeekBar = view.findViewById(R.id.phSeekBar);
        phText = view.findViewById(R.id.phText);
        phMensaje = view.findViewById(R.id.phMensaje);
        phImageView = view.findViewById(R.id.phImageView);

        // Acidez
        acidezSeekBar = view.findViewById(R.id.acidezSeekBar);
        acidezText = view.findViewById(R.id.acidezText);
        acidezMensaje = view.findViewById(R.id.acidezMensaje);
        acidezImageView = view.findViewById(R.id.acidezImageView);

        // Temperatura
        tempSeekBar = view.findViewById(R.id.tempSeekBar);
        tempText = view.findViewById(R.id.tempText);
        tempMensaje = view.findViewById(R.id.tempMensaje);
        tempImageView = view.findViewById(R.id.tempImageView);

        // Densidad
        densidadSeekBar = view.findViewById(R.id.densidadSeekBar);
        densidadText = view.findViewById(R.id.densidadText);
        densidadMensaje = view.findViewById(R.id.densidadMensaje);
        densidadImageView = view.findViewById(R.id.densidadImageView);

        // Listeners
        configurarSeekBars();

        return view;
    }

    private void configurarSeekBars() {
        phSeekBar.setOnSeekBarChangeListener(new SimpleSeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                phText.setText("pH: " + value);
                actualizarVisualSegunPH(value);
            }
        });

        acidezSeekBar.setOnSeekBarChangeListener(new SimpleSeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                acidezText.setText("Acidez: " + value + "ºD");
                actualizarVisualSegunAcidez(value);
            }
        });

        tempSeekBar.setOnSeekBarChangeListener(new SimpleSeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                tempText.setText("Temperatura: " + value + "°C");
                actualizarVisualSegunTemperatura(value);
            }
        });

        densidadSeekBar.setOnSeekBarChangeListener(new SimpleSeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                float densidadReal = 1.00f + (value / 100f); // ejemplo
                densidadText.setText(String.format("Densidad: %.2f g/cm³", densidadReal));
                actualizarVisualSegunDensidad(value);
            }
        });
    }

    // Lógica individual para cada parámetro
    private void actualizarVisualSegunPH(int ph) {
        if (ph < 5) {
            phImageView.setImageResource(R.drawable.leche_acida);
            phMensaje.setText("⚠️ Acidez muy alta. La leche podría estar fermentada.");
            phMensaje.setTextColor(Color.parseColor("#C62828"));
        } else if (ph <= 8) {
            phImageView.setImageResource(R.drawable.leche_normal);
            phMensaje.setText("✅ ¡Perfecto! Esta leche es fresca y saludable.");
            phMensaje.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            phImageView.setImageResource(R.drawable.leche_basica);
            phMensaje.setText("⚠️ pH alto. La leche podría haber sido tratada químicamente.");
            phMensaje.setTextColor(Color.parseColor("#EF6C00"));
        }
    }

    private void actualizarVisualSegunAcidez(int acidez) {
        if (acidez < 3) {
            acidezImageView.setImageResource(R.drawable.leche_acida);
            acidezMensaje.setText("⚠️ Acidez extrema. No es apta para consumo.");
            acidezMensaje.setTextColor(Color.parseColor("#B71C1C"));
        } else if (acidez <= 6) {
            acidezImageView.setImageResource(R.drawable.leche_basica);
            acidezMensaje.setText("✅ Nivel de acidez óptimo.");
            acidezMensaje.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            acidezImageView.setImageResource(R.drawable.leche_agria);
            acidezMensaje.setText("⚠️ Acidez algo elevada. Consumir con precaución.");
            acidezMensaje.setTextColor(Color.parseColor("#F9A825"));
        }
    }

    private void actualizarVisualSegunTemperatura(int temp) {
        if (temp < 5) {
            tempImageView.setImageResource(R.drawable.leche_normal);
            tempMensaje.setText("⚠️ Leche muy fría. Posible refrigeración excesiva.");
            tempMensaje.setTextColor(Color.parseColor("#1565C0"));
        } else if (temp <= 25) {
            tempImageView.setImageResource(R.drawable.leche_normal);
            tempMensaje.setText("✅ Temperatura adecuada.");
            tempMensaje.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            tempImageView.setImageResource(R.drawable.leche_normal);
            tempMensaje.setText("⚠️ Leche caliente. Riesgo de deterioro.");
            tempMensaje.setTextColor(Color.parseColor("#EF6C00"));
        }
    }

    private void actualizarVisualSegunDensidad(int densidad) {
        if (densidad < 4) {
            densidadImageView.setImageResource(R.drawable.leche_aguada);
            densidadMensaje.setText("⚠️ Leche diluida. Baja calidad nutricional.");
            densidadMensaje.setTextColor(Color.parseColor("#6A1B9A"));
        } else if (densidad <= 10) {
            densidadImageView.setImageResource(R.drawable.leche_densidad_normal);
            densidadMensaje.setText("✅ Densidad normal. Buena calidad.");
            densidadMensaje.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            densidadImageView.setImageResource(R.drawable.leche_espesa);
            densidadMensaje.setText("⚠️ Densidad alta. Posible presencia de sólidos.");
            densidadMensaje.setTextColor(Color.parseColor("#EF6C00"));
        }
    }

    // Clase auxiliar para simplificar el listener
    private abstract static class SimpleSeekBarListener implements SeekBar.OnSeekBarChangeListener {
        public abstract void onProgressChanged(SeekBar seekBar, int value, boolean fromUser);

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    }
}
