package com.example.usuario.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonPunto,buttonIgual,buttonSumar,buttonRestar,buttonMultiplicar,buttonDividir,buttonBorrar;
    String operacion = "";
    double acumulado = 0;
    boolean limpiar = false;

    DecimalFormat df = new DecimalFormat("###.#");

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
        buttonRestar = findViewById(R.id.buttonRestar);
        buttonMultiplicar = findViewById(R.id.buttonMultiplicar);
        buttonDividir = findViewById(R.id.buttonDividir);
        buttonIgual = findViewById(R.id.buttonIgual);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Double.parseDouble(resultado.getText().toString()) != 0 || resultado.getText().toString().contains(".")){
                    resultado.setText(resultado.getText()+"0");
                }

                if(limpiar){
                    resultado.setText("0");
                    limpiar = false;
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
                acumulado = 0;
            }
        });

        buttonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!resultado.getText().toString().contains(".")){
                    resultado.setText(resultado.getText() + ".");
                }

                if(limpiar){
                    resultado.setText("0.");
                    limpiar = false;
                }

            }
        });

        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operacion = "sumar";
                acumulado = Double.parseDouble(resultado.getText().toString());
                limpiar = true;
            }
        });

        buttonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = "restar";
                acumulado = Double.parseDouble(resultado.getText().toString());
                limpiar = true;
            }
        });

        buttonMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = "multiplicar";
                acumulado = Double.parseDouble(resultado.getText().toString());
                limpiar = true;
            }
        });

        buttonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = "dividir";
                acumulado = Double.parseDouble(resultado.getText().toString());
                limpiar = true;
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (operacion){

                    case "sumar":
                        double suma = sumar(acumulado, Double.parseDouble(resultado.getText().toString()));
                        resultado.setText(eliminarCeros(suma));
                        acumulado = Double.parseDouble(resultado.getText().toString());
                        break;

                    case "restar":
                        double resta = restar(acumulado,Double.parseDouble(resultado.getText().toString()));
                        resultado.setText(eliminarCeros(resta));
                        acumulado = Double.parseDouble(resultado.getText().toString());
                        break;

                    case "multiplicar":
                        double multiplicacion = multiplicar(acumulado,Double.parseDouble(resultado.getText().toString()));
                        resultado.setText(eliminarCeros(multiplicacion));
                        acumulado = Double.parseDouble(resultado.getText().toString());
                        break;

                    case "dividir":
                        double division = dividir(acumulado,Double.parseDouble(resultado.getText().toString()));
                        resultado.setText(eliminarCeros(division));
                        acumulado = Double.parseDouble(resultado.getText().toString());
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

                if(Double.parseDouble(resultado.getText().toString()) == 0 && !resultado.getText().toString().contains(".") || limpiar){
                    resultado.setText(num);
                    limpiar = false;
                }else{
                    resultado.setText(resultado.getText() + num);
                }


            }
        });
    }

    protected double sumar(double num1, double num2){

        return num1 + num2;
    }

    protected double restar(double num1, double num2){
        return num1 - num2;
    }

    protected double multiplicar(double num1, double num2){
        return num1 * num2;
    }

    protected double dividir(double num1, double num2){
        return num1 / num2;
    }

    private static String eliminarCeros(double d) {
        return String.valueOf(d).replaceAll("[0]*$", "").replaceAll(".$", "");
    }
}
