package modelo;

import java.util.HashMap;

public abstract class Round {

    private HashMap <String,Entradas> puntuaciones;
    private int cantidadEntradas;

    public Round(int cantidadEntradas, String participante1, String participante2) {
        this.cantidadEntradas = cantidadEntradas;
        this.puntuaciones = new HashMap<String,Entradas>();
        this.inicializarPuntuaciones(participante1,participante2);
    }

    private void inicializarPuntuaciones(String participante1, String participante2) {
        this.iniciarPuntuacionParticipante(participante1);
        this.iniciarPuntuacionParticipante(participante2);
    }

    private void iniciarPuntuacionParticipante(String participante){
        Entradas entradas = new Entradas(cantidadEntradas);
        this.puntuaciones.put(participante,entradas);
    }

    public void puntuarEntradaParaParticipante(int puntuacion, int numeroEntrada,String participante){

        Entradas entradas = this.puntuaciones.get(participante);
        entradas.puntuar(puntuacion,numeroEntrada);
    }

    public int getṔuntuacion(Sring participante){
        Entradas entrada = this.puntuaciones.get(participante);
        return entrada.getPuntuacionParcial();
    }

}
