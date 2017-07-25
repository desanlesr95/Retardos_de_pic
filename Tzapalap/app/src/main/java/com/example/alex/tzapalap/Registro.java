package com.example.alex.tzapalap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alex.tzapalap.SQLite.Sqlite;

import java.util.Random;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText nombre,apellido_p,apellido_m,edad,local,user,contra;
    Button reg;
    Sqlite sqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre=(EditText)findViewById(R.id.nombre);
        apellido_p=(EditText)findViewById(R.id.paterno);
        apellido_m=(EditText)findViewById(R.id.materno);
        edad=(EditText)findViewById(R.id.edad);
        local=(EditText)findViewById(R.id.localidad);
        reg=(Button) findViewById(R.id.button);
        user=(EditText)findViewById(R.id.user);
        contra=(EditText)findViewById(R.id.contra);

        reg.setOnClickListener(this);
        sqlite=new Sqlite(this);
        sqlite.abrir();
    }

    @Override
    public void onClick(View view) {
        sqlite.insertausuario(user.getText().toString(),nombre.getText().toString(),apellido_p.getText().toString(),apellido_m.getText().toString(),
                Integer.parseInt(edad.getText().toString()),local.getText().toString(),contra.getText().toString());
        Intent i=new Intent(this,Datos.class);
        i.putExtra("id",user.getText().toString());
        startActivity(i);
        finish();
    }
}
