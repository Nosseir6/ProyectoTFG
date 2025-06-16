package com.example.proyectofinal.fish;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyectofinal.R;

public class FisicosActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_fisicos, findViewById(R.id.content_frame));
        setTitle("Parámetros Físico-Sensoriales");

        setupExpandableCard(R.id.title_aspecto_externo, R.id.content_aspecto_externo);
        setupExpandableCard(R.id.title_branquias, R.id.content_branquias);
        setupExpandableCard(R.id.title_olor, R.id.content_olor);
        setupExpandableCard(R.id.title_textura, R.id.content_textura);
        setupExpandableCard(R.id.title_color_carne, R.id.content_color_carne);
    }

    private void setupExpandableCard(int titleId, int contentId) {
        TextView title = findViewById(titleId);
        final TextView content = findViewById(contentId);

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (content.getVisibility() == View.GONE) {
                    content.setVisibility(View.VISIBLE);
                } else {
                    content.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.drawer_base;
    }
}
