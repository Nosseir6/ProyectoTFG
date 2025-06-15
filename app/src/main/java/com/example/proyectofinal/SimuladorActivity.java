package com.example.proyectofinal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SimuladorActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private RadioGroup radioGroupTipo;
    private Button btnCalcular;

    Button btnInfografia;


    Button btnSaberMas;

    Button btnSimulador;
    private TextView resultadoDias, resultadoPHClara, resultadoPHYema, resultadoEstado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulador);

        datePicker = findViewById(R.id.datePicker);
        radioGroupTipo = findViewById(R.id.radioGroupTipo);
        btnCalcular = findViewById(R.id.btnCalcular);

        resultadoDias = findViewById(R.id.resultadoDias);
        resultadoPHClara = findViewById(R.id.resultadoPHClara);
        resultadoPHYema = findViewById(R.id.resultadoPHYema);
        resultadoEstado = findViewById(R.id.resultadoEstado);
        btnInfografia = findViewById(R.id.btnInfografia);
        btnSimulador = findViewById(R.id.btnSimulador);
        btnSaberMas = findViewById(R.id.btnSaberMas);



        btnCalcular.setOnClickListener(v -> calcularFrescura());
        btnInfografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimuladorActivity.this, HuevoActivity.class);
                startActivity(intent);
            }
        });

        btnSimulador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimuladorActivity.this, SimuladorActivity.class);
                startActivity(intent);
            }
        });

        btnSaberMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimuladorActivity.this, SaberMasActivity.class);
                startActivity(intent);
            }
        });
    }


    private void calcularFrescura() {
        ImageView imagenEstado = findViewById(R.id.imagenEstado);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        LocalDate fechaSeleccionada = LocalDate.of(year, month, day);

        boolean esPuesta = (radioGroupTipo.getCheckedRadioButtonId() == R.id.radioPuesta);

        LocalDate fechaPuesta = esPuesta ? fechaSeleccionada : fechaSeleccionada.minusDays(28);
        long dias = ChronoUnit.DAYS.between(fechaPuesta, LocalDate.now());

        double phClara = Math.min(9.7, 8.0 + dias * 0.06);
        double phYema = Math.min(7.4, 6.0 + dias * 0.05);

        String estado;
        if (dias <= 3) {
            estado = "Muy fresco";
            imagenEstado.setImageResource(R.drawable.muy_fresco);
        } else if (dias <= 7) {
            estado = "Aún fresco";
            imagenEstado.setImageResource(R.drawable.aun_fresco);
        } else if (dias <= 14) {
            estado = "No fresco";
            imagenEstado.setImageResource(R.drawable.no_fresco);
        } else {
            estado = "Poco fresco";
            imagenEstado.setImageResource(R.drawable.poco_fresco);
        }

        resultadoDias.setText("Días desde la puesta: " + dias);
        resultadoPHClara.setText("pH de la clara: " + String.format("%.2f", phClara));
        resultadoPHYema.setText("pH de la yema: " + String.format("%.2f", phYema));
        resultadoEstado.setText("Estado: " + estado);
    }

}
