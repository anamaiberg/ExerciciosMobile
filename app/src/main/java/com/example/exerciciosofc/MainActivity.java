package com.example.exerciciosofc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private TextView texto;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.texto);
        botao = findViewById(R.id.botao);

        // restaurar estado
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("contador");
            texto.setText("Contagem: " + contador);
        }

        botao.setOnClickListener(v -> {
            contador++;
            texto.setText("Contagem: " + contador);
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contador", contador);
    }
}
