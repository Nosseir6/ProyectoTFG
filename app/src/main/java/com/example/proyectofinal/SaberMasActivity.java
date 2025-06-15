package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SaberMasActivity extends AppCompatActivity {

    Button btnInfografia;
    Button btnSaberMas;
    Button btnSimulador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saber_mas);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnInfografia = findViewById(R.id.btnInfografia);
        btnSimulador = findViewById(R.id.btnSimulador);
        btnSaberMas = findViewById(R.id.btnSaberMas);

        // Títulos y contenidos de las 6 tarjetas
        TextView title1 = findViewById(R.id.title1);
        TextView content1 = findViewById(R.id.content1);

        TextView title2 = findViewById(R.id.title2);
        TextView content2 = findViewById(R.id.content2);

        TextView title3 = findViewById(R.id.title3);
        TextView content3 = findViewById(R.id.content3);

        TextView title4 = findViewById(R.id.title4);
        TextView content4 = findViewById(R.id.content4);

        TextView title5 = findViewById(R.id.title5);
        TextView content5 = findViewById(R.id.content5);

        TextView title6 = findViewById(R.id.title6);
        TextView content6 = findViewById(R.id.content6);


        // Para las otras tarjetas que solo tienen un TextView con texto visible,
        // podemos convertirlos en dos TextView (título + contenido oculto),
        // pero si no, simplemente dejamos que no sean toggle.
        // O bien, para simular toggle, necesitarás separar los textos en dos views en XML.

        // En tu layout, solo la primera tarjeta tiene título y contenido separado.
        // Las otras tarjetas tienen un solo TextView con el texto completo visible.
        // Para que todas tengan toggle, tendrías que modificar el layout para que cada tarjeta
        // tenga dos TextViews: uno para título y otro para contenido oculto.

        // Si quieres hacerlo solo con la primera tarjeta, ya está hecho:
        toggle(title1, content1);
        toggle(title2, content2);
        toggle(title3, content3);
        toggle(title4, content4);
        toggle(title5, content5);
        toggle(title6, content6);


        // Listener para los botones
        btnInfografia.setOnClickListener(v -> {
            Intent intent = new Intent(SaberMasActivity.this, HuevoActivity.class);
            startActivity(intent);
        });

        btnSimulador.setOnClickListener(v -> {
            Intent intent = new Intent(SaberMasActivity.this, SimuladorActivity.class);
            startActivity(intent);
        });

        btnSaberMas.setOnClickListener(v -> {
            Intent intent = new Intent(SaberMasActivity.this, SaberMasActivity.class);
            startActivity(intent);
        });
    }

    private void toggleView(TextView content) {
        if (content.getVisibility() == View.GONE) {
            content.setVisibility(View.VISIBLE);
            content.setAlpha(0f);
            content.animate().alpha(1f).setDuration(300).start();
        } else {
            content.animate().alpha(0f).setDuration(300).withEndAction(() -> content.setVisibility(View.GONE)).start();
        }
    }

    private void toggle(TextView title, TextView content) {
        title.setOnClickListener(v -> toggleView(content));
    }
}
