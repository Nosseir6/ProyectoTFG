package com.example.proyectofinal.fragmentsAceite;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;

public class FragmentBeneficiosAceite extends Fragment {

    public FragmentBeneficiosAceite() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Beneficios");
        }

        return inflater.inflate(R.layout.fragment_beneficios_aceite, container, false);
    }

    //card que saltan los pop ups
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView cardSalud = view.findViewById(R.id.card_salud);
        CardView cardAntiinflamatorio = view.findViewById(R.id.card_antiinflamatorio);
        CardView cardCerebro = view.findViewById(R.id.card_cerebro);
        CardView cardMetabolismo = view.findViewById(R.id.card_metabolismo);

        // Listener para cardSalud
        cardSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo("Salud cardiovascular",
                        "Su alto contenido en ácido oleico y polifenoles ayuda a reducir el colesterol LDL (“malo”) y aumentar el HDL (“bueno”), protegiendo contra enfermedades cardíacas.");
            }
        });

        // Listener para cardAntiinflamatorio
        cardAntiinflamatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo("Propiedades antiinflamatorias",
                        "Gracias a los polifenoles, como el oleocantal, que tienen un efecto similar al de los antiinflamatorios naturales.");
            }
        });

        // Listener para cardCerebro
        cardCerebro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo("Protección cerebral",
                        "Puede reducir el riesgo de enfermedades neurodegenerativas como el Alzheimer.");
            }
        });

        // Listener para cardMetabolismo
        cardMetabolismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo("Regulación del metabolismo",
                        "Mejora la sensibilidad a la insulina y puede ayudar en el control del peso cuando se consume con moderación.");
            }
        });
    }


    private void mostrarDialogo(String titulo, String mensaje) {
        new AlertDialog.Builder(requireContext())
                .setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("Cerrar", null)
                .show();
    }
}
