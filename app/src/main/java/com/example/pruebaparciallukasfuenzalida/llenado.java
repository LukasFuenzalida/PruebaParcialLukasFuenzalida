package com.example.pruebaparciallukasfuenzalida;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class llenado extends AppCompatActivity {
    Spinner ger;
    Button btn3;
    EditText nom,edad;
    ArrayList<String> valores = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenado);
        btn3 = (Button) findViewById(R.id.btn3);
        ger = (Spinner) findViewById(R.id.sp_generos);
        nom = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);

        valores.add("...");
        valores.add("Hombre");
        valores.add("Mujer");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,valores);
        ger.setAdapter(adaptador);
    }
    public void Agre(View V){
        AlertDialog.Builder mi = new AlertDialog.Builder(this);
        mi.setMessage("Seguro que desea agragar a la persona?");
        mi.setTitle("ADVERTENCIA");
        mi.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String gen = ger.getSelectedItem().toString();
                if(gen.equals("Hombre")){
                    Integer totalp = 0, contadoh=0;
                    contadoh++;
                    totalp++;
                    Intent I = new Intent(getApplicationContext(),control.class);
                    I.putExtra("CONTADORH",contadoh);
                    I.putExtra("CONTADORP",totalp);
                    startActivity(I);
                }
                else if(gen.equals("Mujer")){
                    Integer totalp = 0, contadorm=0;
                    contadorm++;
                    totalp++;
                    Intent I = new Intent(getApplicationContext(),control.class);
                    I.putExtra("CONTADORM",contadorm);
                    I.putExtra("CONTADORP",totalp);
                    startActivity(I);
                }
                else if(nom.getText().toString().isEmpty() || edad.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "DEBE INGRESAR NOMBRE y EDAD",Toast.LENGTH_LONG).show();
                }
            }
        });
        mi.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = mi.create();
        dialog.show();
    }
}