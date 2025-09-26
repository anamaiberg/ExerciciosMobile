package com.example.aula0309;

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

        TextView txtNome = view.findViewById(R.id.tvNome);
        TextView txtDescricao = view.findViewById(R.id.tvDescricao);
        TextView txtValor = view.findViewById(R.id.tvValor);

        // abra a socola (bundle) de dados enviados pelo fragmento A
        Bundle args = getArguments();
        String nome = args.getString("nomeItem");
        String descricao = args.getString("descricaoItem");
        String valor = args.getString("valorItem");

        txtNome.setText(nome);
        txtDescricao.setText(descricao);
        txtValor.setText(valor);

        return view;
    }
}
