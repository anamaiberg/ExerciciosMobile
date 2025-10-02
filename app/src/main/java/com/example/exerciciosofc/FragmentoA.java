package com.example.exerciciosofc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentoA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragmento_a, container, false);

        Button BtnIMC = view.findViewById(R.id.BtnIMC);
        //TextView tvNome = view.findViewById(R.id.tvNome);
        TextView tvIMC = view.findViewById(R.id.tvIMC);

        Bundle b =  getArguments();
        float imc = b.getFloat("imc");
        //String nome = b.getString("nome");

        //tvNome.setText("Nome: " + nome);
        tvIMC.setText("IMC: " + String.format("%.2f", imc));

        BtnIMC.setOnClickListener(v -> {

            FragmentoB fragmentoB = new FragmentoB();

            // Trocar fragmento
            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, fragmentoB);
            ft.addToBackStack(null); // permite voltar com botão "voltar"
            ft.commit();
        });

        return view;
    }
}
