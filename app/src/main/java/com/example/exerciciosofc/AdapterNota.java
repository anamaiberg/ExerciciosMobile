package com.example.exerciciosofc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterNota extends ArrayAdapter<Nota> {

    int mResource;
    SQLiteDatabaseActions dbActions;

    public interface SQLiteDatabaseActions {
        void deletarNota(int id);
    }

    public AdapterNota(@NonNull Context context, int resource, @NonNull List<Nota> objects, SQLiteDatabaseActions dbActions) {
        super(context, resource, objects);
        this.mResource = resource;
        this.dbActions = dbActions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View v = layoutInflater.inflate(mResource, parent, false);

        Nota nota = getItem(position);
        TextView tvNota = v.findViewById(R.id.tvNota);
        Button btnDelete = v.findViewById(R.id.btnDelete);

        tvNota.setText(nota.txt);

        btnDelete.setOnClickListener(view -> {
            dbActions.deletarNota(nota.id);
            Toast.makeText(getContext(), "Nota deletada!", Toast.LENGTH_SHORT).show();
        });

        return v;
    }
}
