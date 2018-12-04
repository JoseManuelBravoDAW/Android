package com.example.usuario.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonPunto,buttonIgual,buttonSumar,buttonRestar,buttonMultiplicar,buttonDividir,buttonBorrar;
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonBorrar = findViewById(R.id.buttonBorrar);
        buttonPunto = findViewById(R.id.buttonPunto);
        buttonSumar = findViewById(R.id.buttonSumar);
        buttonIgual = findViewById(R.id.buttonIgual);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Double.parseDouble(resultado.getText().toString()) != 0){
                    resultado.setText(resultado.getText()+"0");
                }

            }
        });

        annadirListener(button1, "1");
        annadirListener(button2, "2");
        annadirListener(button3, "3");
        annadirListener(button4, "4");
        annadirListener(button5, "5");
        annadirListener(button6, "6");
        annadirListener(button7, "7");
        annadirListener(button8, "8");
        annadirListener(button9, "9");

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("0");
            }
        });

        buttonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!resultado.getText().toString().contains(".")){
                    resultado.setText(resultado.getText() + ".");
                }

            }
        });

        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = "sumar";
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (operacion){

                    case "sumar":

                        break;

                    default:

                        break;

                }

            }
        });

    }

    protected void annadirListener(Button b, final String num){

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Double.parseDouble(resultado.getText().toString()) == 0){
                    resultado.setText(num);
                }else{
                    resultado.setText(resultado.getText() + num);
                }


            }
        });
    }

    protected double sumar(double num1, double num2){

        return num1 + num2;
    }

}
