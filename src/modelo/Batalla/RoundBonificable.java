package modelo.Batalla;

import java.util.ArrayList;

public class RoundBonificable extends Round {

    private ArrayList<Integer> bonificaciones;
    public RoundBonificable(int cantEntradas) {
        super(cantEntradas);
        this.bonificaciones = new ArrayList<Integer>();
        this.inicializarBonificaciones();
    }

    private void inicializarBonificaciones(){
        for(int i = 0; i < this.cantEntradas ; i++){
            bonificaciones.add(i, 0);
        }
    }

    public void bonificarEntrada(int nroEntrada){
        this.bonificaciones.set(nroEntrada - 1,1);
    }

    public void desbonificarEntrada(int nroEntrada){
        this.bonificaciones.set(nroEntrada - 1 , 0);
    }

    @Override
    public int getPuntajePatron(int nroPatron) {
        return super.getPuntajePatron(nroPatron) + this.bonificaciones.get(nroPatron -1);
    }


}
