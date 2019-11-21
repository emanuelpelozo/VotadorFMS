package modelo.Batalla;

import java.util.ArrayList;
import java.util.HashMap;

public class Batalla {

    private ArrayList<String> competidores;
    private HashMap<String, ManejadorRondas> puntajes;
    private String competicion;

    public Batalla(){

        this.competidores = new ArrayList<>();
        this.puntajes = new HashMap<>();
    }

    public void iniciarBatalla(String paisCompeticion) {
        this.competicion = paisCompeticion;
    }

    public void setCompetidor1(String competidor) {
        this.competidores.add(0,competidor);
        this.puntajes.put(competidor, new ManejadorRondas()); //Iniciamos en 0 el puntaje
    }

    public void setCompetidor2(String competidor){
        this.competidores.add(1,competidor);
        this.puntajes.put(competidor, new ManejadorRondas()); //Iniciamos en 0 el puntaje
    }

    public String getCompetidor1(){
        return this.competidores.get(0);
    }

    public String getCompetidor2(){
        return this.competidores.get(1);
    }

    public int getPuntajeAcumuladoCompetidor(String nombreCompetidor) {

        ManejadorRondas manejadorRondas =  this.puntajes.get(nombreCompetidor);
        return manejadorRondas.getPuntajeAcumulado();

    }

    public void puntuarPatronEasyMode(int nroPatron, int puntaje, String competidor) {

        ManejadorRondas manejadorRondas = this.puntajes.get(competidor);

        manejadorRondas.puntuarEaseMode(nroPatron, puntaje);
    }
}
