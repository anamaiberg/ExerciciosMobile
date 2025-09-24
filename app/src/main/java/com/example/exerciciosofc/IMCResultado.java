package com.example.exerciciosofc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IMCResultado extends AppCompatActivity {
    TextView tvPeso, tvAltura, tvIMC, tvClassifacao;
    ImageView imageView;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvIMC = findViewById(R.id.tvIMC);
        imageView = findViewById(R.id.imgPerfil);
        b2 = findViewById(R.id.button2);

        // Pegando dados do Bundle
        Bundle b = getIntent().getExtras();
        float peso = b.getFloat("peso");
        float altura = b.getFloat("altura");

        // Cálculo do IMC
        float imc = peso / (altura * altura);

        // Exibindo valores
        tvPeso.setText("Peso: " + peso + " Kg");
        tvAltura.setText("Altura: " + altura + " m");
        tvIMC.setText("IMC: " + String.format("%.2f", imc));

        // Classificação de acordo com a tabela
        String classificacao;
        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
            imageView.setImageResource(R.drawable.abaixopeso);
        } else if (imc < 24.9) {
            classificacao = "Peso normal";
            imageView.setImageResource(R.drawable.normal);
        } else if (imc < 29.9) {
            classificacao = "Sobrepeso";
            imageView.setImageResource(R.drawable.sobrepeso);
        } else if (imc < 34.9) {
            classificacao = "Obesidade grau 1";
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (imc < 39.9) {
            classificacao = "Obesidade grau 2";
            imageView.setImageResource(R.drawable.obesidade2);
        } else {
            classificacao = "Obesidade grau 3";
            imageView.setImageResource(R.drawable.obesidade3);
        }

        // Exibe a classificação junto do IMC
        tvIMC.append("\n" + classificacao);

        b2.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        });
    }
}
