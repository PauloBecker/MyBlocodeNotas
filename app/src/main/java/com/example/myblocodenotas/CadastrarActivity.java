package com.example.myblocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myblocodenotas.controller.NotaController;
import com.example.myblocodenotas.model.Nota;

public class CadastrarActivity extends AppCompatActivity {

    EditText edTitulo, edTxt;
    Nota mNote;
    NotaController mNoteController;
    Button bntCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        edTitulo=findViewById(R.id.edTitulo);
        edTxt=findViewById(R.id.edtxt);
        bntCadastrar=findViewById(R.id.bntSalvar);
        mNoteController = new NotaController(getApplicationContext());
        mNote=new Nota(edTitulo.getText().toString(),edTxt.getText().toString());
        bntCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastraNota();
            }
        });
    }

    private void cadastraNota() {
        mNote.setTitulo(edTitulo.getText().toString());
        mNote.setTxt(edTxt.getText().toString());
        mNoteController.cadastrarNota(mNote);
        finish();
    }
}