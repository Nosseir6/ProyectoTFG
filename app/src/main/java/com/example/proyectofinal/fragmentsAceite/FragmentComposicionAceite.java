package com.example.proyectofinal.fragmentsAceite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;

public class FragmentComposicionAceite extends Fragment {

    private TextView infoBox;

    public FragmentComposicionAceite() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Composición Química");
        }

        View view = inflater.inflate(R.layout.fragment_composicion_quimica_aceite, container, false);

        TextView nodoAcidos = view.findViewById(R.id.nodo_acidos_grasos);
        TextView nodoPolifenoles = view.findViewById(R.id.nodo_polifenoles);
        TextView nodoTocoferoles = view.findViewById(R.id.nodo_tocoferoles);
        TextView nodoCompuestos = view.findViewById(R.id.nodo_compuestos);

        // bloque de texto
        infoBox = view.findViewById(R.id.info_box);

        // listeners de los botones
        nodoAcidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarInformacion("Ácidos Grasos:\n\nPrincipalmente ácido oleico (monoinsaturado), seguido de ácido linoleico (poliinsaturado) y ácido palmítico (saturado).");
            }
        });

        nodoPolifenoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarInformacion("Polifenoles:\n\nAntioxidantes naturales que protegen contra la oxidación.");
            }
        });

        nodoTocoferoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarInformacion("Tocoferoles (Vitamina E):\n\nContribuyen a la estabilidad del aceite y aportan beneficios antioxidantes.");
            }
        });

        nodoCompuestos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarInformacion("Compuestos volátiles y aromáticos:\n\nResponsables del sabor y aroma característicos, especialmente en el aceite de oliva virgen extra.");
            }
        });


        return view;
    }

    private void mostrarInformacion(String texto) {
        infoBox.setText(texto);
        infoBox.setVisibility(View.VISIBLE);
    }
}
