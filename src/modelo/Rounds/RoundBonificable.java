package modelo.Rounds;

import modelo.Entradas;

import java.util.HashMap;

public abstract class RoundBonificable extends Round {

    private int PUNTAJE_BONUS = 1;
    private HashMap<String, Entradas> puntuacionesBonus;


    public RoundBonificable(int cantidadEntradas, String participante1, String participante2) {
        super(cantidadEntradas, participante1, participante2);
    }

    private void inicializarPuntuacionesBonus(String participante1, String participante2){
        this.inicializarBonusParticipante(participante1);
        this.inicializarBonusParticipante(participante2);
    }
    
    private void inicializarBonusParticipante(String participante){
        Entradas entradasBonus = new Entradas(this.cantidadEntradas);
        this.puntuacionesBonus.put(participante, entradasBonus);
    }
     
    public void sumarBonusPorPersonaje(String participante, int numeroEntrada){
        
        Entradas entradasBonus = this.puntuacionesBonus.get(participante);
        entradasBonus.puntuar(PUNTAJE_BONUS, numeroEntrada);
    }


}
