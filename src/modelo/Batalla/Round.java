package modelo.Batalla;

import java.util.ArrayList;

public class Round {

    private ArrayList<Integer> puntajes;
    protected int cantEntradas;
    private String nombre;

    public Round(String nombre, int cantEntradas){
        this.cantEntradas = cantEntradas;
        this.nombre = nombre;
        this.inicializarPuntajes();
    }

    private void inicializarPuntajes() {

        puntajes = new ArrayList();
        for(int i = 0; i<this.cantEntradas; i++){

            puntajes.add(i, 0);
        }
    }

    public int getPuntajePatron(int nroPatron){

        return this.puntajes.get( nroPatron - 1);
    }

    public void votarPatron(int nroPatron, int puntaje) {

        this.puntajes.set( nroPatron - 1, puntaje);
    }

    public int getPuntajeAcumulado(){
        int puntajeAcumulado = 0;

        for (int i = 1; i <= this.cantEntradas; i++) {

            puntajeAcumulado += this.getPuntajePatron(i);

        }
        return puntajeAcumulado;
    }


    public String getNombre() {
        return this.nombre;
    }
}
