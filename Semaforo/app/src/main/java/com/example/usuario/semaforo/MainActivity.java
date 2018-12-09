package com.example.usuario.semaforo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button jugar;
    ImageView rojo, amarillo, verde, botonRojo, botonAmarillo, botonVerde;
    TextView TVNivel, TVRecord, TVMensaje;
    int nivel = 1;
    int record = 1;
    String secuencia = "";
    String secuenciaUsuario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugar = findViewById(R.id.jugar);
        rojo = findViewById(R.id.rojo);
        verde = findViewById(R.id.verde);
        amarillo = findViewById(R.id.amarillo);
        botonRojo = findViewById(R.id.botonRojo);
        botonAmarillo = findViewById(R.id.botonAmarillo);
        botonVerde = findViewById(R.id.botonVerde);
        TVNivel = findViewById(R.id.nivel);
        TVRecord = findViewById(R.id.record);
        TVMensaje = findViewById(R.id.mensaje);


        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TVMensaje.setText("");
                secuenciaUsuario = "";
                crearSecuencia();
                mostrarSecuencia();
            }
        });

        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secuenciaUsuario += "r";
                comprobarSecuencia();
            }
        });

        botonAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secuenciaUsuario += "a";
                comprobarSecuencia();
            }
        });

        botonVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secuenciaUsuario += "v";
                comprobarSecuencia();
            }
        });
    }

    protected void crearSecuencia(){

        secuencia = "";

        for(int i = 0; i < nivel; i++){

            switch (numeroAleatorio(1,3)){
                case 1:
                    secuencia += "r";
                    break;
                case 2:
                    secuencia += "a";
                    break;
                case 3:
                    secuencia += "v";
                    break;
            }
        }
    }

    protected void mostrarSecuencia(){

        Handler handler=new Handler();
        for(int i = 0; i < secuencia.length(); i++){

            final int final1 = i;

            Runnable r = new Runnable(){
                @Override
                public void run() {

                    switch (secuencia.charAt(final1)){

                        case 'r':

                            rojo.setImageResource(R.drawable.rojo);

                            break;

                        case 'a':
                            amarillo.setImageResource(R.drawable.amarillo);

                            break;

                        case 'v':
                            verde.setImageResource(R.drawable.verde);

                            break;

                    }


                }
            };

            handler.postDelayed(r, 2000*i);

            Runnable r2=new Runnable() {
                public void run() {
                    rojo.setImageResource(R.drawable.vacio);
                    amarillo.setImageResource(R.drawable.vacio);
                    verde.setImageResource(R.drawable.vacio);
                }
            };

            handler.postDelayed(r2, 2000*i+1000);

        }
    }

    protected boolean comprobarSecuencia(){

        for(int i = 0; i < secuenciaUsuario.length(); i++){
            if(secuenciaUsuario.charAt(i) != secuencia.charAt(i)){
                TVMensaje.setText("Incorrecto!");
                if(nivel > record){
                    record = nivel;
                    TVRecord.setText("Record: " + record);
                }
                nivel = 1;
                TVNivel.setText("Nivel:" + nivel);
                return false;
            }
        }

        if(secuenciaUsuario.equals(secuencia)){
            TVMensaje.setText("Correcto!");
            nivel++;
            secuenciaUsuario = "";
            TVNivel.setText("Nivel:" + nivel);
            return true;
        }
        return false;
    }

    private int numeroAleatorio(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

}
