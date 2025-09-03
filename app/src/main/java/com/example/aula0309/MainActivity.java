package com.example.aula0309;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editTextMin, editTextMax;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editTextMin = findViewById(R.id.edMin);
        editTextMax = findViewById(R.id.edMax);
        tv = findViewById(R.id.tvResultado);

        button.setOnClickListener(v-> {
            Random random = new Random();
            int min, max;
            min = Integer.parseInt(editTextMin.getText().toString());
            max = Integer.parseInt(editTextMax.getText().toString());

            int delta = max-min;
            int sorteado = random.nextInt(delta)+min;
            tv.setText(Integer.toString(sorteado));
        });
        }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Sorteado", tv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState!=null){
            tv.setText(savedInstanceState.getString("sorteado"));
        }
    }
}
