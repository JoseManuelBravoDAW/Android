package com.example.usuario.conecta4;

public class Game {

    int[][] tablero;

    static final int NFILAS = 6;

    static final int NCOLUMNAS = 7;

    static final int VACIO = 0;

    static final int JUGADOR1 = 1;

    static final int JUGADOR2 = 2;

    static final String JUGADOR1GANA = "1111";

    static final String JUGADOR2GANA = "2222";

    static final String PATRONGANADOR_A = "222";


    String estado = "Jugando";
    String ganador = "";
    int turno;

    Game(int jugador) {
        tablero = new int[NFILAS][NCOLUMNAS];
        setTurno(jugador);
        iniciarTablero();
    }

    private void iniciarTablero() {
        for (int i = 0; i < NFILAS; i++) {
            for (int j = 0; j < NCOLUMNAS; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    private void setTurno(int turno) {

        this.turno = turno;
    }

    int getTurno() {

        return turno;
    }

    void cambiarTurno(){
        this.setTurno(this.getTurno() == JUGADOR1 ? JUGADOR2 : JUGADOR1);
        return;
    }

    boolean isVacio(int fila, int columna) {

        return tablero[fila][columna] == VACIO;
    }

    void setFicha(int i, int j) {

        tablero[i][j] = this.turno;
    }

    String fila(int fila) {
        String cadena = "";
        for (int i = 0; i < NCOLUMNAS; i++) {
            cadena += tablero[fila][i];
        }
        return cadena;
    }

    String columna(int columna) {
        String cadena = "";
        for (int i = 0; i < NFILAS - 1; i++) {
            for (int j = 0; j < NCOLUMNAS; j++) {
                if (j == columna) {
                    cadena = "";
                    for (int k = 0; k < NFILAS; k++) {
                        cadena += tablero[k][j];
                    }
                }
            }
        }
        return cadena;
    }

    String diagonalIzquierda(int fila, int columna) {
        String cadena = "";
        for (int i = fila, j= columna; i < NFILAS && j < NCOLUMNAS; i++, j++)
            cadena += tablero[i][j];
        for (int i = fila-1, j= columna - 1; j >= 0 && i >=0; i--, j--)
            cadena = tablero[i][j] + cadena;

        return cadena;
    }

    String diagonalDerecha(int fila, int columna) {
        String cadena = "";
        for (int i = fila, j= columna; i < NFILAS && j >= 0; i++, j--)
            cadena += tablero[i][j];
        for (int i = fila-1, j= columna + 1; j < NCOLUMNAS && i >=0; i--, j++)
            cadena = tablero[i][j] + cadena;

        return cadena;
    }

    boolean comprobarPartida(int fila, int columna) {
        if (fila(fila).contains(JUGADOR1GANA) || columna(columna).contains(JUGADOR1GANA)
                || diagonalDerecha(fila, columna).contains(JUGADOR1GANA) || diagonalIzquierda(fila, columna).contains(JUGADOR1GANA)) {
            ganador = "Jugador1";
            return true;
        } else if (fila(fila).contains(JUGADOR2GANA) || columna(columna).contains(JUGADOR2GANA)
                || diagonalDerecha(fila, columna).contains(JUGADOR2GANA) || diagonalIzquierda(fila, columna).contains(JUGADOR2GANA)) {
            ganador = "Jugador2";
            return true;
        }
        return false;
    }


    String mostrarTablero() {
        String mensaje = "";
        for (int i = 0; i < NFILAS; i++) {
            for (int j = 0; j < NCOLUMNAS; j++) {
                mensaje += tablero[i][j];
            }
        }
        return mensaje;
    }

    String tableroToString() {
        String cadena = "";
        for (int i = 0; i < NFILAS; i++) {
            for (int j = 0; j < NCOLUMNAS; j++) {
                cadena += tablero[i][j];
            }
        }
        return cadena;
    }

    void StringToTablero(String cadena) {
        int contador = 0;
        for (int i = 0; i < NFILAS; i++) {
            for (int j = 0; j < NCOLUMNAS; j++) {
                tablero[i][j] = Integer.parseInt(cadena.substring(contador, contador + 1));
                contador++;
            }
        }
    }
}