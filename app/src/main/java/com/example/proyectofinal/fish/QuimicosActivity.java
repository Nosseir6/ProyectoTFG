package com.example.proyectofinal.fish;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.proyectofinal.R;

public class QuimicosActivity extends BaseDrawerActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_quimicos, findViewById(R.id.content_frame));
        setTitle("Parámetros Quimicos");


        TextView titleBvt = findViewById(R.id.title_bvt);
        TextView contentBvt = findViewById(R.id.content_bvt);
        setupExpandableCard(R.id.title_bvt, R.id.content_bvt);
        setupExpandableCard(R.id.title_amoniaco, R.id.content_amoniaco);
        setupExpandableCard(R.id.title_tma, R.id.content_tma);
        setupExpandableCard(R.id.title_ph, R.id.content_ph);
        setupExpandableCard(R.id.title_agua, R.id.content_agua);
        setupExpandableCard(R.id.title_proteinas, R.id.content_proteinas);
        setupExpandableCard(R.id.title_lipidos, R.id.content_lipidos);
        setupExpandableCard(R.id.title_aminoacidos, R.id.content_aminoacidos);
        setupExpandableCard(R.id.title_minerales, R.id.content_minerales);
        setupExpandableCard(R.id.title_acidos_grasos, R.id.content_acidos_grasos);
        setupExpandableCard(R.id.title_color, R.id.content_color);
        setupExpandableCard(R.id.title_aw, R.id.content_aw);
        setupExpandableCard(R.id.title_tamano_forma, R.id.content_tamano_forma);
        setupExpandableCard(R.id.title_salinidad, R.id.content_salinidad);
        setupExpandableCard(R.id.title_textura, R.id.content_textura);
        setupExpandableCard(R.id.title_temperatura, R.id.content_temperatura);



        SeekBar seekBarDia = findViewById(R.id.daySeekBar);
        TextView labelDia = findViewById(R.id.dayLabel);
        TextView valorBvt = findViewById(R.id.valor_bvt);
        TextView estadoBvt = findViewById(R.id.estado_bvt);
        TextView valorAmoniaco = findViewById(R.id.valor_amoniaco);
        TextView estadoAmoniaco = findViewById(R.id.estado_amoniaco);
        TextView valorTma = findViewById(R.id.valor_tma);
        TextView estadoTma = findViewById(R.id.estado_tma);
        TextView valorPh = findViewById(R.id.valor_ph);
        TextView estadoPh = findViewById(R.id.estado_ph);

        seekBarDia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int day, boolean fromUser) {
                labelDia.setText("Día post-captura: " + day);
                updateTabla(day, valorBvt, estadoBvt, valorAmoniaco, estadoAmoniaco, valorTma, estadoTma, valorPh, estadoPh);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });





        titleBvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contentBvt.getVisibility() == View.GONE) {
                    contentBvt.setVisibility(View.VISIBLE);
                } else {
                    contentBvt.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.drawer_base;
    }

    private void setupExpandableCard(int titleId, int contentId) {
        TextView title = findViewById(titleId);
        View content = findViewById(contentId);

        title.setOnClickListener(v -> {
            if (content.getVisibility() == View.GONE) {
                content.setVisibility(View.VISIBLE);
            } else {
                content.setVisibility(View.GONE);
            }
        });
    }

    private void updateTabla(int dia,
                             TextView vBvt, TextView eBvt,
                             TextView vAmoniaco, TextView eAmoniaco,
                             TextView vTma, TextView eTma,
                             TextView vPh, TextView ePh) {

        double bvt = 5 + dia * 4.5;
        double amoniaco = 1 + dia * 0.9;
        double tma = 0.5 + dia * 0.95;
        double ph = 6.2 + dia * 0.13;

        vBvt.setText(String.format("%.1f mg N/100g", bvt));
        eBvt.setText(estado(bvt, 20, 35));

        vAmoniaco.setText(String.format("%.1f mg", amoniaco));
        eAmoniaco.setText(estado(amoniaco, 4, 7));

        vTma.setText(String.format("%.1f mg", tma));
        eTma.setText(estado(tma, 5, 8));

        vPh.setText(String.format("%.2f", ph));
        ePh.setText(estado(ph, 6.8, 7.2));
    }
    private String estado(double valor, double normal, double moderado) {
        if (valor < normal) return "Normal";
        else if (valor < moderado) return "Moderado";
        else return "Crítico";
    }

}
