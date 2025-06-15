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

public class FragmentQuimicos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_parametros_quimicos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // cenizas
        TextView titleCenizas = view.findViewById(R.id.title_cenizas);
        LinearLayout contentCenizas = view.findViewById(R.id.content_cenizas);

        // proteinas
        TextView titleProteinas = view.findViewById(R.id.title_proteinas);
        LinearLayout contentProteinas = view.findViewById(R.id.content_proteinas);

        // gluten
        TextView titleGluten = view.findViewById(R.id.title_gluten);
        LinearLayout contentGluten = view.findViewById(R.id.content_gluten);

        // almidon
        TextView titleAlmidon = view.findViewById(R.id.title_almidon);
        LinearLayout contentAlmidon = view.findViewById(R.id.content_almidon);

        toggleSection(titleCenizas, contentCenizas);
        toggleSection(titleProteinas, contentProteinas);
        toggleSection(titleGluten, contentGluten);
        toggleSection(titleAlmidon, contentAlmidon);
    }

    private void toggleSection(final TextView title, final LinearLayout content) {
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
    }
}
