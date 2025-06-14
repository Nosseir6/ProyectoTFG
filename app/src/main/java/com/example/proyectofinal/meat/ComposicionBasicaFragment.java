package com.example.proyectofinal.meat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.proyectofinal.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class ComposicionBasicaFragment extends Fragment {

    public ComposicionBasicaFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carne_composicion, container, false);

        configurarPieChart(view.findViewById(R.id.pieChartTernera),
                "Ternera", 75f, 21f, 3f);

        configurarPieChart(view.findViewById(R.id.pieChartCerdo),
                "Cerdo", 65f, 20f, 15f);

        configurarPieChart(view.findViewById(R.id.pieChartPollo),
                "Pollo", 72f, 22f, 5f);

        return view;
    }

    private void configurarPieChart(PieChart pieChart, String titulo,
                                    float agua, float proteina, float grasa) {

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(agua, "💧 Agua"));
        entries.add(new PieEntry(proteina, "🍗 Proteínas"));
        entries.add(new PieEntry(grasa, "🧈 Grasas"));

        PieDataSet dataSet = new PieDataSet(entries, "Composición");
        dataSet.setColors(
                Color.parseColor("#4FC3F7"),  // Azul para agua
                Color.parseColor("#81C784"),  // Verde para proteínas
                Color.parseColor("#FFD54F")   // Amarillo para grasas
        );
        dataSet.setValueTextSize(14f);
        dataSet.setValueTextColor(Color.DKGRAY);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);

        pieChart.setCenterText(titulo);
        pieChart.setCenterTextSize(16f);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setHoleRadius(40f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.animateY(1000);

        Legend legend = pieChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setTextSize(14f);
    }
}
