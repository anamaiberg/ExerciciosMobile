package com.example.exerciciosofc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button buttonInsere, buttonAtualiza;
    EditText editText;
    ListView listView;
    ArrayList<Nota> notas = new ArrayList<>();
    Nota notaSelecionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsere = findViewById(R.id.buttonInsere);
        buttonAtualiza = findViewById(R.id.buttonAtualiza);
        editText = findViewById(R.id.edText);
        listView = findViewById(R.id.listView);

        db = openOrCreateDatabase("minhasnotinhas", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT)");

        // botão inserir
        buttonInsere.setOnClickListener(v -> {
            String txt = editText.getText().toString().trim();
            if (!txt.isEmpty()) {
                insereNota(txt);
            } else {
                Toast.makeText(this, "Digite algo antes de inserir!", Toast.LENGTH_SHORT).show();
            }
        });

        // botão atualizar
        buttonAtualiza.setOnClickListener(v -> {
            if (notaSelecionada != null) {
                String novoTxt = editText.getText().toString().trim();
                if (!novoTxt.isEmpty()) {
                    atualizaNota(notaSelecionada.id, novoTxt);
                    notaSelecionada = null;
                    editText.setText("");
                    buttonAtualiza.setVisibility(View.GONE);
                    buttonInsere.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(this, "Digite algo para atualizar!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Selecione uma nota antes de atualizar!", Toast.LENGTH_SHORT).show();
            }
        });

        // clique curto: editar
        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            notaSelecionada = (Nota) adapterView.getItemAtPosition(position);
            editText.setText(notaSelecionada.txt);
            buttonInsere.setVisibility(View.GONE);
            buttonAtualiza.setVisibility(View.VISIBLE);
        });

        carregaNota();
    }

    public void insereNota(String txt) {
        ContentValues cv = new ContentValues();
        cv.put("txt", txt);
        db.insert("notas", null, cv);
        editText.setText("");
        carregaNota();
    }

    public void atualizaNota(int id, String novoTxt) {
        ContentValues cv = new ContentValues();
        cv.put("txt", novoTxt);
        int rows = db.update("notas", cv, "id=?", new String[]{String.valueOf(id)});
        if (rows > 0) {
            Toast.makeText(this, "Nota atualizada com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro ao atualizar nota!", Toast.LENGTH_SHORT).show();
        }
        carregaNota();
    }

    public void carregaNota() {
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        notas.clear();
        if (cursor.moveToFirst()) {
            int columnId = cursor.getColumnIndex("id");
            int columnTxt = cursor.getColumnIndex("txt");
            do {
                int id = cursor.getInt(columnId);
                String txt = cursor.getString(columnTxt);
                notas.add(new Nota(id, txt));
            } while (cursor.moveToNext());
        }
        cursor.close();

        AdapterNota adapter = new AdapterNota(this, R.layout.item_nota, notas, id -> {
            db.delete("notas", "id=?", new String[]{String.valueOf(id)});
            carregaNota();
        });
        listView.setAdapter(adapter);
    }
}
