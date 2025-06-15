package com.example.proyectofinal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;

public class FragmentComposicion extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_composicion, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Cambiar el título del Toolbar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Composición Química");
        }

        // Linkar desplegables con la informacion
        TextView titleCarbohidratos = view.findViewById(R.id.title_carbohidratos);
        LinearLayout contentCarbohidratos = view.findViewById(R.id.content_carbohidratos);

        TextView titleProteinas = view.findViewById(R.id.title_proteinas);
        LinearLayout contentProteinas = view.findViewById(R.id.content_proteinas);

        TextView titleLipidos = view.findViewById(R.id.title_lipidos);
        LinearLayout contentLipidos = view.findViewById(R.id.content_lipidos);

        TextView titleFibra = view.findViewById(R.id.title_fibra);
        LinearLayout contentFibra = view.findViewById(R.id.content_fibra);

        TextView titleMinerales = view.findViewById(R.id.title_minerales);
        LinearLayout contentMinerales = view.findViewById(R.id.content_minerales);

        TextView titleVitaminas = view.findViewById(R.id.title_vitaminas);
        LinearLayout contentVitaminas = view.findViewById(R.id.content_vitaminas);

        TextView titleEnzimas = view.findViewById(R.id.title_enzimas);
        LinearLayout contentEnzimas = view.findViewById(R.id.content_enzimas);

        TextView titleCompuestosFenolicos = view.findViewById(R.id.title_compuestos_fenolicos);
        LinearLayout contentCompuestosFenolicos = view.findViewById(R.id.content_compuestos_fenolicos);

        TextView titlePigmentosNaturales = view.findViewById(R.id.title_pigmentos_naturales);
        LinearLayout contentPigmentosNaturales = view.findViewById(R.id.content_pigmentos_naturales);

        TextView titleAntinutrientes = view.findViewById(R.id.title_antinutrientes);
        LinearLayout contentAntinutrientes = view.findViewById(R.id.content_antinutrientes);


        // llaamr al metod
        toggleSection(titleCarbohidratos, contentCarbohidratos);
        toggleSection(titleProteinas, contentProteinas);
        toggleSection(titleLipidos, contentLipidos);
        toggleSection(titleFibra, contentFibra);
        toggleSection(titleMinerales, contentMinerales);
        toggleSection(titleVitaminas, contentVitaminas);
        toggleSection(titleEnzimas, contentEnzimas);
        toggleSection(titleCompuestosFenolicos, contentCompuestosFenolicos);
        toggleSection(titlePigmentosNaturales, contentPigmentosNaturales);
        toggleSection(titleAntinutrientes, contentAntinutrientes);
    }


    // metodo para cambiar mostrar y ocultar
    private void toggleSection(final TextView title, final LinearLayout content) {
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (content.getVisibility() == View.GONE) {
                    // Solo se anima al salir la info
                    android.transition.Transition transition = new android.transition.AutoTransition();
                    transition.setDuration(200);
                    android.transition.TransitionManager.beginDelayedTransition((ViewGroup) content.getParent(), transition);

                    content.setVisibility(View.VISIBLE);

                    if (!title.getText().toString().endsWith("▲")) {
                        title.setText(title.getText().toString().replace("▼", "").trim() + " ▲");
                    }
                } else {
                    // Sin animación al ocultar
                    content.setVisibility(View.GONE);
                    title.setText(title.getText().toString().replace("▲", "").trim() + " ▼");
                }
            }
        });
    }








}
