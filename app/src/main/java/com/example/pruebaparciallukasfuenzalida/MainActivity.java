package com.example.pruebaparciallukasfuenzalida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usu;
    EditText contra;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usu = (EditText) findViewById(R.id.usuario);
        contra = (EditText) findViewById(R.id.contra);
        btn = (Button) findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usu.getText().toString().isEmpty() || contra.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "DEBE INGRESAR USUARIO y CONTRASENA",Toast.LENGTH_LONG).show();
                }
                String us = usu.getText().toString();
                String con = contra.getText().toString();
                if(us.equals("adm123") & con.equals("adm123")){
                    Intent I = new Intent(getApplicationContext(),control.class);
                    I.putExtra("SUsuari", us);
                    I.putExtra("SContra", con);
                    startActivity(I);
                }
                else {
                    Toast.makeText(getApplicationContext(), "USUARIO O CONTRASENA INCORRECTOS",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}