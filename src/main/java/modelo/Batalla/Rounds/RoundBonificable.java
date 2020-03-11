package modelo.Batalla.Rounds;

import java.util.ArrayList;

public class RoundBonificable extends Round {


    private ColeccionDePuntajes bonificaciones;

    public RoundBonificable(String nombre, int cantEntradas) {

        super(nombre, cantEntradas);
        this.bonificaciones = new ColeccionDePuntajes(cantEntradas);
    }

    public void bonificarEntrada(int nroEntrada){
        this.bonificaciones.votarEntrada(nroEntrada, 1);
    }

    public void desbonificarEntrada(int nroEntrada){
        this.bonificaciones.votarEntrada(nroEntrada, 0);
    }


    @Override
    public int getPuntajePatron(int nroPatron) {
        return super.getPuntajePatron(nroPatron) + this.bonificaciones.getPuntajeDeEntrada(nroPatron );
    }

    @Override
    public int getPuntajeAcumulado() {
        return super.getPuntajeAcumulado() + this.bonificaciones.getPuntajeAcumulado();
    }
}
