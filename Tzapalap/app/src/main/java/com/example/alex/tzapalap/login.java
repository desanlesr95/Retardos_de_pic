package com.example.alex.tzapalap;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.tzapalap.SQLite.Sqlite;

import java.util.List;

public class login extends AppCompatActivity implements View.OnClickListener{
    EditText editText,editText2;
    TextView crear,admin;
    Button btn;
    Sqlite sqlite;
    List datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText=(EditText)findViewById(R.id.m);
        editText2=(EditText)findViewById(R.id.pass);
        crear=(TextView)findViewById(R.id.crear);
        btn=(Button)findViewById(R.id.entrar);
        crear.setOnClickListener(this);
        btn.setOnClickListener(this);
        crear.setOnClickListener(this);
        sqlite=new Sqlite(this);
        sqlite.abrir();
        admin=(TextView)findViewById(R.id.admin);
        admin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.entrar:
                Cursor cursor=sqlite.selectusuarios(editText.getText().toString(),editText2.getText().toString());
                datos=sqlite.escribe(cursor,7);
                if (datos.size()<=0){
                    Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i=new Intent(this,Datos.class);
                    i.putExtra("id",editText.getText().toString());
                    startActivity(i);
                }
                break;
            case R.id.crear:
                Intent i=new Intent(this,Registro.class);
                startActivity(i);
                finish();
                break;
            case R.id.admin:
                Intent in=new Intent(this,verificar.class);
                startActivity(in);
                finish();
                break;
            default:
                break;

        }
    }
}
