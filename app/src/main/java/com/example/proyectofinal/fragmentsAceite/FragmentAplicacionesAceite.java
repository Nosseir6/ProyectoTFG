package com.example.proyectofinal.fragmentsAceite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;

public class FragmentAplicacionesAceite extends Fragment {

    public FragmentAplicacionesAceite() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_aplicaciones_aceite, container, false);

        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Aplicaciones Dietéticas");
        }

        // desplegables
        toggleSection(view.findViewById(R.id.title_acidez), view.findViewById(R.id.content_acidez));
        toggleSection(view.findViewById(R.id.title_peroxidos), view.findViewById(R.id.content_peroxidos));
        toggleSection(view.findViewById(R.id.title_que_aceite), view.findViewById(R.id.content_que_aceite));
        toggleSection(view.findViewById(R.id.title_como_usarlo), view.findViewById(R.id.content_como_usarlo));

        return view;
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
