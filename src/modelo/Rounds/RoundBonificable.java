package modelo.Rounds;

import modelo.Entradas;

import java.util.HashMap;

public class RoundBonificable extends Round {

    private Bonificaciones bonificaciones;


    public RoundBonificable(int cantidadEntradas, String participante1, String participante2) {
        super(cantidadEntradas, participante1, participante2);
        this.bonificaciones = new Bonificaciones();

    }


    public void bonificarEntrada(int numeroEntrada){
        this.bonificaciones.bonificarEntrada(numeroEntrada);
    }


    public void desbonificarEntrada(int numeroEntrada){
        this.bonificaciones.desbonificarEntrada(numeroEntrada);
    }


    @Override
    public int getPuntaje (String participante){
        int puntaje = super.getṔuntuacion(participante);
        puntaje += this.bonificaciones.getTotal();
        return puntaje;
    }



}
