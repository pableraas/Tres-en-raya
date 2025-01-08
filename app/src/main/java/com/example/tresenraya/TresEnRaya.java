package com.example.tresenraya;

import java.util.Random;

public class TresEnRaya {
    private int[][] tablero = new int[3][3];

    public static boolean empiezaUsuario1() {
        Random random = new Random();
        return random.nextBoolean();        //Devuelve un booleano aleatorio
    }

    /////////////////////////////////////////////
    public void mueveJugador1(int pos) {
        if (movimientoValido(pos)) {   //Si el movimiento es valido, el jugador 1 mueve
            tablero[pos / 3][pos % 3] = 1;
        }
    }

    /////////////////////////////////////////////
    public void mueveJugador2(int pos) {
        if (movimientoValido(pos)) {   //Si el movimiento es valido, el jugador 2 mueve
            tablero[pos / 3][pos % 3] = 2;
        }
    }

    /////////////////////////////////////////////
    public boolean mueveMaquina1() {
        if (quedanCasillas()) {      //Comprobamos que quedan casillas
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == 0) {     //Lo recorremos y en la primera vacia ponemos un 1
                        tablero[i][j] = 1;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /////////////////////////////////////////////
    public boolean mueveMaquina2() {
        if (quedanCasillas()) {      //Comprobamos que quedan casillas
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == 0) {
                        tablero[i][j] = 2;      //Lo recorremos y en la primera vacia ponemos un 2
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /////////////////////////////////////////////
    public boolean movimientoValido(int pos) {
        if (pos >= 0 && pos < 9) {      //Si el numero esta entre 0-8
            if (tablero[pos / 3][pos % 3] == 0) {     //Para el numero de fila y la columna
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /////////////////////////////////////////////
    public void iniciar() {           //Ponemos todas las posiciones del array a 0
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    /////////////////////////////////////////////
    public boolean quedanCasillas() {
        for (int i = 0; i < 3; i++) {       //Recorremos el array en busca de alguna pos == 0
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /////////////////////////////////////////////
    public void dibujarTablero() {

    }

    /////////////////////////////////////////////
    public boolean ganaJugador1() {
        for (int j = 0; j < 3; j++) {       //Primero comprobamos las columnas
            if (tablero[0][j] == 1 && tablero[1][j] == 1 && tablero[2][j] == 1) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {       //Segundo comprobaremos las filas
            if (tablero[i][0] == 1 && tablero[i][1] == 1 && tablero[i][2] == 1) {
                return true;
            }
        }
        if (tablero[0][0] == 1 && tablero[1][1] == 1 && tablero[2][2] == 1) {   //Comprobamos ambas diagonales
            return true;
        }
        if (tablero[0][2] == 1 && tablero[1][1] == 1 && tablero[2][0] == 1) {
            return true;
        }
        return false;
    }

    /////////////////////////////////////////////
    public boolean ganaJugador2() {
        for (int j = 0; j < 3; j++) {       //Primero comprobamos las columnas
            if (tablero[0][j] == 2 && tablero[1][j] == 2 && tablero[2][j] == 2) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {       //Segundo comprobaremos las filas
            if (tablero[i][0] == 2 && tablero[i][1] == 2 && tablero[i][2] == 2) {
                return true;
            }
        }
        if (tablero[0][0] == 2 && tablero[1][1] == 2 && tablero[2][2] == 2) {   //Comprobamos ambas diagonales
            return true;
        }
        if (tablero[0][2] == 2 && tablero[1][1] == 2 && tablero[2][0] == 2) {
            return true;
        }
        return false;
    }
    /////////////////////////////////////////////
}
