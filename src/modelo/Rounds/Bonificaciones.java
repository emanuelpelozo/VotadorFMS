package modelo.Rounds;

import java.util.ArrayList;

public class Bonificaciones {

    private ArrayList bonificaciones;

    public Bonificaciones(){
        bonificaciones = new ArrayList();
    }

    public void bonificarEntrada(int numeroEntrada){
        bonificaciones.add(numeroEntrada);
    }

    public void desbonificarEntrada(int numeroEntrada){
        bonificaciones.remove(numeroEntrada);
    }

    public int getTotal() {
        return bonificaciones.size();
    }
}
