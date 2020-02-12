package modelo.Batalla.Rounds;

import java.util.ArrayList;

public class ColeccionDePuntajes {

    private ArrayList<Integer> puntajes;
    private int cantEntradas;

    public ColeccionDePuntajes(int cantEntradas){
        this.cantEntradas = cantEntradas;

        inicializarPuntajes();
    }
    private void inicializarPuntajes() {

        this.puntajes = new ArrayList();
        for(int i = 0; i<this.cantEntradas; i++){

            puntajes.add(i, 0);
        }
    }

    public int getPuntajeDeEntrada(int nroEntrada){
        return this.puntajes.get( nroEntrada - 1);
    }


    public void votarEntrada(int nroEntrada, int puntaje) {

        this.puntajes.set( nroEntrada - 1, puntaje);
    }

    public int getPuntajeAcumulado(){
        int puntajeAcumulado = 0;

        for (int i = 1; i <= this.cantEntradas; i++) {

            puntajeAcumulado += this.getPuntajeDeEntrada(i);

        }
        return puntajeAcumulado;
    }



}
