package com.desan.luis.retardos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText m,n,p;
    TextView r1,r2,r3;
    Button b;
    RadioButton micro,seg;
    ImageView info;
    double vn,vm,vp,vr1,vr2,vr3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m = (EditText) findViewById(R.id.m);
        n = (EditText) findViewById(R.id.n);
        p = (EditText) findViewById(R.id.p);
        r1 = (TextView) findViewById(R.id.r1);
        r2 = (TextView) findViewById(R.id.r2);
        r3 = (TextView) findViewById(R.id.r3);
        b = (Button) findViewById(R.id.cal);
        micro = (RadioButton) findViewById(R.id.micro);
        seg = (RadioButton) findViewById(R.id.seg);
        micro.setChecked(true);
        b.setOnClickListener(this);
        info=(ImageView)findViewById(R.id.info);
        info.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.cal:
                vm=Double.parseDouble(m.getText().toString());
                vn=Double.parseDouble(n.getText().toString());
                vp=Double.parseDouble(p.getText().toString());
                if(!m.getText().toString().isEmpty()&&!n.getText().toString().isEmpty()&&!p.getText().toString().isEmpty()){
                    retardo1();
                    retardo2();
                    retardo3();
                    if(micro.isChecked()){
                        r1.setText("Microsegundos: " + (int)vr1);
                        r2.setText("Microsegundos: " + (int)vr2);
                        r3.setText("Microsegundos: "+ (int)vr3);
                    }
                    else{
                        r1.setText("Segundos: " + (vr1)/1000000);
                        r2.setText("Segundos: " + (vr2)/1000000);
                        r3.setText("Segundos: "+ (vr3)/1000000);
                    }
                }

                else{
                    if(!m.getText().toString().isEmpty()&&!n.getText().toString().isEmpty()&&(p.getText().toString().isEmpty()||vp==0)){
                        retardo1();
                        retardo2();
                        if(micro.isChecked()){
                            r1.setText("Microsegundos: " + (int)vr1);
                            r2.setText("Microsegundos: " + (int) vr2);
                        }
                        else{
                            r1.setText("Segundos: " + (vr1)/1000000);
                            r2.setText("Segundos: " + (vr2)/1000000);
                        }
                    }
                    else if(!m.getText().toString().isEmpty()&&(n.getText().toString().isEmpty()||vn==0)&&(p.getText().toString().isEmpty())||vm==0){
                        retardo1();
                        if(micro.isChecked()){
                            r1.setText("Microsegundos: " + (int)vr1);
                        }
                        else{
                            r1.setText("Segundos: " + (vr1)/1000000);
                        }
                    }
                    else{
                        Toast.makeText(this,"Inserte digitos en las varaibles de los retardos",Toast.LENGTH_LONG);
                    }
                }
                break;
            case R.id.info:
                Intent i=new Intent(this,Main2Activity.class);
                startActivity(i);
                break;
        }



    }
    public void retardo1(){
        vr1=(3*vm)+1;
    }
    public void retardo2(){
        vr2=(((3*vm)+1)*vn)+((3*vn)+1);
    }
    public void retardo3(){
        vr3=(vr2*vp)+((3*vp)+1);
    }
}
