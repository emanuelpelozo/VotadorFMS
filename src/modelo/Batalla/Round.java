package modelo.Batalla;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;

public class Round {

    private ArrayList<Integer> puntajes;
    private int cantEntradas;

    public Round(int cantEntradas){
        this.cantEntradas = cantEntradas;
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

        for (int i = 0; i < this.cantEntradas; i++) {

            puntajeAcumulado += this.puntajes.get(i);

            System.out.println(i);
            System.out.println(this.puntajes.get(i));
        }
        return puntajeAcumulado;
    }

}
