package com.example.proyectofinal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;

public class FragmentFisicos extends Fragment {

    private TextView resultadoSimulador;
    private int densidad, humedad, granulometria;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_parametros_fisicos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // desplegables
        TextView titleHumedad = view.findViewById(R.id.title_humedad);
        LinearLayout contentHumedad = view.findViewById(R.id.content_humedad);
        TextView titleGranulometria = view.findViewById(R.id.title_granulometria);
        LinearLayout contentGranulometria = view.findViewById(R.id.content_granulometria);
        resultadoSimulador = view.findViewById(R.id.resultados_simulador);

        toggleSection(titleHumedad, contentHumedad);
        toggleSection(titleGranulometria, contentGranulometria);

        //  barras
        setupDynamicSeekBar(view, R.id.seek_granulometria, R.id.value_granulometria, "micras", "granulometria", 0, 500);
        setupDynamicSeekBar(view, R.id.seek_humedad, R.id.value_humedad, "%", "humedad", 0, 25);
        setupDynamicSeekBar(view, R.id.seek_densidad, R.id.value_densidad, "g/mL", "densidad", 0, 60);
    }

    private void toggleSection(final TextView title, final LinearLayout content) {
        title.setOnClickListener(v -> {
            if (content.getVisibility() == View.GONE) {
                android.transition.Transition transition = new android.transition.AutoTransition();
                transition.setDuration(200);
                android.transition.TransitionManager.beginDelayedTransition((ViewGroup) content.getParent(), transition);
                content.setVisibility(View.VISIBLE);
                if (!title.getText().toString().endsWith("▲")) {
                    title.setText(title.getText().toString().replace("▼", "").trim() + " ▲");
                }
            } else {
                content.setVisibility(View.GONE);
                title.setText(title.getText().toString().replace("▲", "").trim() + " ▼");
            }
        });
    }

    private void setupDynamicSeekBar(View view, int seekId, int valueId, String suffix, String type, int min, int max) {
        SeekBar seekBar = view.findViewById(seekId);
        TextView valueText = view.findViewById(valueId);

        // rango de las barras
        seekBar.setMax(max - min);

        // mete en la variable el valor de la barra
        int progress = seekBar.getProgress();

        // calcula el valor real
        int value = progress + min;

        // muestra el valor en el TextView
        valueText.setText("Valor: " + value + " " + suffix);

        // llama al metodo que actualiza donde pone el numero de la barra
        updateValue(type, value);

        //  listener para actualizar el valor del SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // Se llama cada vez que cambia el progreso del SeekBar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = progress + min; // Recalcula el valor con el mínimo
                valueText.setText("Valor: " + value + " " + suffix); // Actualiza el texto
                updateValue(type, value); // Actualiza la lógica del valor
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void updateValue(String type, int value) {
        switch (type) {
            case "granulometria":
                granulometria = value;
                break;
            case "humedad":
                humedad = value;
                break;
            case "densidad":
                densidad = value;
                break;
        }
        actualizarResultados();
    }

    private void actualizarResultados() {
        String recomendacion, estado, uso;

        if (densidad <= 20) {
            recomendacion = "Recomendación: Textura muy ligera, ideal para mezclas rápidas.";
        } else if (densidad <= 35) {
            recomendacion = "Recomendación: Equilibrada para diversos tipos de preparación.";
        } else {
            recomendacion = "Recomendación: Alta compactación, almacenar bien cerrado y seco.";
        }

        if (humedad <= 12) {
            estado = "Estado de conservación: Harina muy seca, puede absorber más líquido de lo habitual.";
        } else if (humedad <= 15) {
            estado = "Estado de conservación: Nivel óptimo para mantener la calidad del producto.";
        } else {
            estado = "Estado de conservación: Humedad elevada, riesgo de moho y deterioro ⚠️.";
        }

        if (granulometria <= 150) {
            uso = "Uso recomendado: Preparaciones finas como bizcochos o cremas.";
        } else if (granulometria <= 300) {
            uso = "Uso recomendado: Elaboración estándar como panes o galletas.";
        } else {
            uso = "Uso recomendado: Masas rústicas, rebozados o productos de mayor cuerpo.";
        }

        resultadoSimulador.setText(recomendacion + "\n" + estado + "\n" + uso);
    }

}
