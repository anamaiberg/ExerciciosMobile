package com.example.aula0309;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.IMCResultado;
import com.example.exerciciosofc.R;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText edpeso, edaltura;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        edaltura = findViewById(R.id.edAltura);
        edpeso= findViewById(R.id.edPeso);
        b.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);
            float peso = Float.parseFloat(edpeso.getText().toString());
            float altura = Float.parseFloat(edaltura.getText().toString());

            intent.putExtra("altura", altura);
            intent.putExtra("peso", peso);
            startActivity(intent);
        });
        }
    }