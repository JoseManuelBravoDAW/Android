package com.example.usuario.marcadorbaloncesto;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView equipo1, equipo2;
    Button mas1Equipo1, mas2Equipo1, mas3Equipo1, menos1Equipo1, mas1Equipo2, mas2Equipo2, mas3Equipo2, menos1Equipo2, resetear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equipo1 = (TextView) findViewById(R.id.puntosEquipo1);
        equipo2 = (TextView) findViewById(R.id.puntosEquipo2);
        mas1Equipo1 = findViewById(R.id.Equipo1puntos1);
        mas2Equipo1 = findViewById(R.id.Equipo1puntos2);
        mas3Equipo1 = findViewById(R.id.Equipo1puntos3);
        menos1Equipo1 = findViewById(R.id.Equipo1Restar);
        mas1Equipo2 = findViewById(R.id.Equipo2puntos1);
        mas2Equipo2 = findViewById(R.id.Equipo2puntos2);
        mas3Equipo2 = findViewById(R.id.Equipo2puntos3);
        menos1Equipo2 = findViewById(R.id.Equipo2Restar);
        resetear = findViewById(R.id.Resetear);

        mas1Equipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipo1.setText(Integer.toString(Integer.parseInt(equipo1.getText().toString())+1));

            }
        });

        mas2Equipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipo1.setText(Integer.toString(Integer.parseInt(equipo1.getText().toString())+2));

            }
        });

        mas3Equipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipo1.setText(Integer.toString(Integer.parseInt(equipo1.getText().toString())+3));

            }
        });

        menos1Equipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipo1.setText(Integer.toString(Integer.parseInt(equipo1.getText().toString())-1));

            }
        });

        mas1Equipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipo2.setText(Integer.toString(Integer.parseInt(equipo2.getText().toString())+1));

            }
        });

        mas2Equipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipo2.setText(Integer.toString(Integer.parseInt(equipo2.getText().toString())+2));

            }
        });

        mas3Equipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipo2.setText(Integer.toString(Integer.parseInt(equipo2.getText().toString())+3));

            }
        });

        menos1Equipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipo2.setText(Integer.toString(Integer.parseInt(equipo2.getText().toString())-1));

            }
        });

        resetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialogo = crearDialogo();
                dialogo.show();
            }
        });


    }

    protected AlertDialog crearDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("¿Seguro que quieres resetear el marcador?");
        builder.setTitle("Resetear");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                equipo1.setText("0");
                equipo2.setText("0");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return builder.create();
    }

}
