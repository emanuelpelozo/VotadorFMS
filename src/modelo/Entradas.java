package modelo;

import modelo.Rounds.Bonificaciones;

import java.util.ArrayList;

public abstract class Entradas {

    private ArrayList<int> puntuaciones;
    private int cantidadEntradas;

    public Entradas(int cantidadEntradas){
        this.cantidadEntradas = cantidadEntradas;
        this.iniciarPuntuaciones();
    }

    private void iniciarPuntuaciones() {
        for(i = 0,i < cantidadEntradas, i++) {
            this.puntuaciones.add(0); //inicio puntuaciones en 0
        }
    }

    public void puntuarEntrada(int puntuacion, int numeroEntrada) {
        this.puntuaciones.add(numeroEntrada - 1 , puntuacion);
    }



    public int getPuntuacionParcial() {
        int puntuacion = 0;
        for (int puntaje : this.puntuaciones){
            puntuacion += puntaje;
        }

        return puntuacion;
    }


}
