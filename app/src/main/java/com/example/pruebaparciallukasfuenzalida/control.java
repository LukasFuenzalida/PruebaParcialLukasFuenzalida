package com.example.pruebaparciallukasfuenzalida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class control extends AppCompatActivity {
    ImageButton btn2;
    TextView total;
    TextView hombres;
    TextView mujer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        total = (TextView) findViewById(R.id.total);
        hombres = (TextView) findViewById(R.id.hombres);
        mujer = (TextView) findViewById(R.id.mujeres);
        btn2 = (ImageButton) findViewById(R.id.btn2);

        Bundle b = getIntent().getExtras();
        Integer tot= b.getInt("CONTADORP");
        Integer hom= b.getInt("CONTADORH");
        Integer muj= b.getInt("CONTADORM");

        total.setText(""+tot);
        hombres.setText(""+hom);
        mujer.setText(""+muj);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),llenado.class);
                startActivity(I);
            }
        });
    }
}