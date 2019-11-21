package modelo.Batalla;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;

public class Round {

    private ArrayList<Integer> puntajes;
    private int cantRounds;

    public Round(int cantRounds){
        this.cantRounds = cantRounds;
        this.inicializarPuntajes();
    }

    private void inicializarPuntajes() {

        puntajes = new ArrayList();
        for(int i = 0; i<this.cantRounds; i++){

            puntajes.add(i, 0);
        }
    }

    public int getPuntajePatron(int nroPatron){
        return this.puntajes.get( nroPatron - 1);
    }

    public void votarPatron(int nroPatron, int puntaje) {

        this.puntajes.add( nroPatron - 1, puntaje);
    }

    public int getPuntajeAcumulado(){
        int puntajeAcumulado = 0;

        for (int i = 0; i < this.cantRounds; i++) {

            puntajeAcumulado += this.puntajes.get(i);

            System.out.println(this.puntajes.get(i));
        }
        return puntajeAcumulado;
    }

}
