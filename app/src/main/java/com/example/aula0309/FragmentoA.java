package com.example.aula0309;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentoA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragmento_a, container, false);

        Button btnCamiseta = view.findViewById(R.id.btnCamiseta);

        btnCamiseta.setOnClickListener(v -> {

            FragmentoB fragmentoB = new FragmentoB();

            // Passar dados via Bundle
            Bundle bundle = new Bundle();
            bundle.putString("nomeItem", "Camiseta Flamengo");
            bundle.putString("descricaoItem", "Camiseta 100% algodão, tamanho M.");
            bundle.putString("valorItem", "R$ 69,00");
            fragmentoB.setArguments(bundle);

            // Trocar fragmento
            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, fragmentoB);
            ft.addToBackStack(null); // permite voltar com botão "voltar"
            ft.commit();
        });

        return view;
    }
}
