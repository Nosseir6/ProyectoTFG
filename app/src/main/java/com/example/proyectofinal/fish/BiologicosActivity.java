package com.example.proyectofinal.fish;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyectofinal.R;

public class BiologicosActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_biologicos, findViewById(R.id.content_frame));
        setTitle("Parámetros Biológicos");

        setupExpandableCard(R.id.title_aerobios, R.id.content_aerobios);
        setupExpandableCard(R.id.title_coliformes, R.id.content_coliformes);
        setupExpandableCard(R.id.title_salmonella, R.id.content_salmonella);
        setupExpandableCard(R.id.title_listeria, R.id.content_listeria);
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
