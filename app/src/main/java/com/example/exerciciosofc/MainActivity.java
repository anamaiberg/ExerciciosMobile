package com.example.exerciciosofc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView texto = findViewById(R.id.texto);
        Button botao = findViewById(R.id.botao);

        botao.setOnClickListener(v-> {
            contador++;
            texto.setText("Contagem: " + contador);
        });
    }
}