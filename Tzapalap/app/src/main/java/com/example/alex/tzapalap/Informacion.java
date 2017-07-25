package com.example.alex.tzapalap;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alex.tzapalap.SQLite.Sqlite;

import java.util.List;

public class Informacion extends AppCompatActivity {
    Bundle bundle;
    TextView col, bas, k;
    Sqlite sqlite;
    String c1="",c2="",c3="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        col=(TextView)findViewById(R.id.col);
        bas=(TextView)findViewById(R.id.bas);
        k=(TextView)findViewById(R.id.kg);
        bundle=getIntent().getExtras();
        sqlite=new Sqlite(this);
        sqlite.abrir();
        Cursor cursor=sqlite.selectinventario(bundle.getString("id"));
        List list=sqlite.escribe(cursor,5);
        Log.i("datos----->>>>>>>>>>>>>>",list.size()+"\t"+list.toString());
        int i=0;
        while (i<list.size()){
            c1+=list.get(i+1)+"\n";
            c2+=list.get(i+2)+"\n";
            c3+=list.get(i+3)+"\n";
            i+=5;
        }
        col.setText(c1);
        col.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        bas.setText(c2);
        bas.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        k.setText(c3);
        k.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
}
