package com.example.exerciciosofc;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText edpeso, edaltura, ednome;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        //ednome = findViewById(R.id.edNome);
        edaltura = findViewById(R.id.edAltura);
        edpeso= findViewById(R.id.edPeso);
        b.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);
            float peso = Float.parseFloat(edpeso.getText().toString());
            float altura = Float.parseFloat(edaltura.getText().toString());
            //Editable nome = ednome.getText();
            float imc = peso / (altura * altura);

            Bundle bundle = new Bundle();
            bundle.putFloat("peso", peso);
            bundle.putFloat("altura", altura);
            bundle.putFloat("imc", imc);
            fragmentoA.setArguments(bundle);
            fragmentoB.setArguments(bundle);

            intent.putExtra("altura", altura);
            intent.putExtra("peso", peso);
            //intent.putExtra("nome", nome);
            intent.putExtra("imc", imc);
            startActivity(intent);
        });
        }
    }