package com.example.alex.tzapalap;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alex.tzapalap.SQLite.Sqlite;

import java.util.List;

public class verificar extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{
    EditText editText,editText2;
    Button into;
    ArrayAdapter arrayAdapter;
    Sqlite sqlite;
    List list;
    ListView lista;
    String ids[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar);
        editText=(EditText)findViewById(R.id.administrador);
        editText2=(EditText)findViewById(R.id.pass);
        into=(Button)findViewById(R.id.into);
        into.setOnClickListener(this);
        sqlite=new Sqlite(this);
        sqlite.abrir();
        lista=(ListView)findViewById(R.id.list);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(editText.getText().toString().equals("admin")&& editText2.getText().toString().equals("admin")){
            Cursor cursor=sqlite.selectusuarios();
            list=sqlite.escribe(cursor,7);
            String datos[]=new String[list.size()/7];
            ids=new String[list.size()/7];
            int i=0;
            Log.i("lis",list.toString()+"");
            int j=0;
            while(i<list.size()){
                Log.i("I->",i+"");
                ids[j]=list.get(i).toString();
                datos[j]=list.get(i+1).toString();
                i=i+7;
                j++;
            }
            arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
            lista.setAdapter(arrayAdapter);
        }
        else{
            Toast.makeText(this,"No eres administrador",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(this,Informacion.class);
        intent.putExtra("id",ids[i]);
        startActivity(intent);
    }
}
