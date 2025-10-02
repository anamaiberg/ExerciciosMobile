package com.example.exerciciosofc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoB extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragmento_b, container, false);

        TextView txtDescricao = view.findViewById(R.id.tvDescricao);

        // abra a socola (bundle) de dados enviados pelo fragmento A
        Bundle args = getArguments();
        float imc = args.getFloat("imc");
        float peso = args.getFloat("peso");

        String classificacao;
        Float pesoideal;
        if (imc < 20) {
            pesoideal = imc-peso;
            txtDescricao.setText("Ganhe " + String.format("%.2f", pesoideal)+ " kg");
        } else if (imc > 25) {
            pesoideal = peso-imc;
            txtDescricao.setText("Ganhe " + String.format("%.2f", pesoideal)+ " kg");
        }

        return view;
    }
}
