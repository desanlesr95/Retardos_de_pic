package com.example.alex.tzapalap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alex.tzapalap.SQLite.Sqlite;

import java.util.Random;

public class Datos extends AppCompatActivity implements View.OnClickListener{
    EditText col,bas,kilos;
    Button btn;
    Sqlite sqlite;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        col=(EditText)findViewById(R.id.cant_col);
        bas=(EditText)findViewById(R.id.cant_bas);
        kilos=(EditText)findViewById(R.id.kilos);
        btn=(Button)findViewById(R.id.aceptar);
        btn.setOnClickListener(this);
        sqlite=new Sqlite(this);
        bundle=getIntent().getExtras();

    }

    @Override
    public void onClick(View view) {
        sqlite.abrir();
        Random random=new Random();
        sqlite.insertainventario(random.nextInt(),Integer.parseInt(col.getText().toString()),Integer.parseInt(bas.getText().toString()),
                Float.parseFloat(kilos.getText().toString()),bundle.getString("id"));
        Intent i=new Intent(this,Informacion.class);
        i.putExtra("id",bundle.getString("id"));
        startActivity(i);
        finish();
    }
}
