package com.desan.luis.retardos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        view=(ImageView)findViewById(R.id.atras);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
