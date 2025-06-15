package com.example.proyectofinal.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;

public class FragmentAplicacion extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_aplicacion, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Aplicaciones Dietéticas");
        }

        // enseñar los pop ups
        setupCardClick(view, R.id.card_humedad, "Humedad",
                "La humedad influye directamente en la solubilidad y disponibilidad de los nutrientes " +
                        "presentes en la harina, afectando su valor nutricional y su comportamiento en procesos " +
                        "como la cocción o fermentación.\n\n" +
                        "Además, un mayor contenido de agua activa enzimas naturales que modifican la masa y aceleran " +
                        "reacciones importantes en la panificación."
        );

        setupCardClick(view, R.id.card_cenizas, "Cenizas",
                "Las cenizas indican el contenido total de minerales en la harina, como calcio, hierro, " +
                        "magnesio y zinc.\n\n" +
                        "Harinas integrales suelen tener más minerales, y su análisis ayuda a clasificar y asegurar la calidad nutricional."
        );

        setupCardClick(view, R.id.card_proteinas, "Proteínas",
                "El contenido proteico ayuda a reducir el índice glucémico y aporta proteínas de calidad, " +
                        "importantes en dietas vegetarianas o veganas.\n\n" +
                        "Favorece un mejor control de la glucemia y complementa las necesidades proteicas."
        );

        setupCardClick(view, R.id.card_gluten, "Gluten",
                "El gluten aporta aminoácidos esenciales para dietas hiperproteicas y es fundamental en panificación, " +
                        "proporcionando estructura, elasticidad y volumen.\n\n" +
                        "En dietas sin gluten, es necesario eliminarlo cuidadosamente para evitar déficits nutricionales."
        );

        setupCardClick(view, R.id.card_almidon, "Almidón",
                "El almidón es la principal fuente de energía, proporcionando glucosa necesaria para el cerebro y músculos.\n\n" +
                        "El tipo y procesamiento del almidón afecta el índice glucémico, siendo importante en dietas para diabetes y síndrome metabólico.\n\n" +
                        "Además, el almidón resistente tiene efecto prebiótico, mejorando la salud intestinal."
        );
    }

    private void setupCardClick(View root, int cardId, String title, String message) {
        CardView card = root.findViewById(cardId);
        card.setOnClickListener(v -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton("Cerrar", null)
                    .show();
        });
    }
}
