package com.example.proyectofinal.egg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.R;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SimuladorActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private RadioGroup radioGroupTipo;
    private Button btnCalcular, btnInfografia, btnSaberMas, btnSimulador;
    private TextView resultadoDias, resultadoPHClara, resultadoPHYema, resultadoEstado;
    private ImageView imagenEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulador);

        datePicker = findViewById(R.id.datePicker);
        radioGroupTipo = findViewById(R.id.radioGroupTipo);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnInfografia = findViewById(R.id.btnInfografia);
        btnSimulador = findViewById(R.id.btnSimulador);
        btnSaberMas = findViewById(R.id.btnSaberMas);

        resultadoDias = findViewById(R.id.resultadoDias);
        resultadoPHClara = findViewById(R.id.resultadoPHClara);
        resultadoPHYema = findViewById(R.id.resultadoPHYema);
        resultadoEstado = findViewById(R.id.resultadoEstado);
        imagenEstado = findViewById(R.id.imagenEstado);

        btnCalcular.setOnClickListener(v -> calcularFrescura());

        btnInfografia.setOnClickListener(v -> {
            Intent intent = new Intent(SimuladorActivity.this, HuevoActivity.class);
            startActivity(intent);
        });

        btnSimulador.setOnClickListener(v -> {
            Intent intent = new Intent(SimuladorActivity.this, SimuladorActivity.class);
            startActivity(intent);
        });

        btnSaberMas.setOnClickListener(v -> {
            Intent intent = new Intent(SimuladorActivity.this, SaberMasActivity.class);
            startActivity(intent);
        });
    }

    private void calcularFrescura() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth(); // No sumes 1 aquí porque Calendar lo maneja internamente
        int year = datePicker.getYear();

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        Date fechaSeleccionada = cal.getTime();

        boolean esPuesta = (radioGroupTipo.getCheckedRadioButtonId() == R.id.radioPuesta);

        // Restar 28 días si es fecha de caducidad
        if (!esPuesta) {
            cal.add(Calendar.DAY_OF_MONTH, -28);
        }
        Date fechaPuesta = cal.getTime();

        long dias = calcularDiasCompat(fechaPuesta);

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
        resultadoPHClara.setText("pH de la clara: " + String.format(Locale.getDefault(), "%.2f", phClara));
        resultadoPHYema.setText("pH de la yema: " + String.format(Locale.getDefault(), "%.2f", phYema));
        resultadoEstado.setText("Estado: " + estado);
    }

    private long calcularDiasCompat(Date fechaPuesta) {
        Date hoy = new Date();
        long diffInMillis = hoy.getTime() - fechaPuesta.getTime();
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }
}
