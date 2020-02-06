package modelo.Batalla;

import java.util.ArrayList;
import java.util.HashMap;

public class Batalla {

    private ArrayList<String> competidores;
    private HashMap<String, AdministradorRound> rounds;
    private String competicion;

    public Batalla(){

        this.competidores = new ArrayList<>();
        this.rounds = new HashMap<>();
    }

    public void setBatallaEnPais(String paisCompeticion) {
        this.competicion = paisCompeticion;
    }

    private void setCompetidor(String competidor, int nroCompetidor){
        AdministradorRound administrador = new AdministradorRound();
        administrador.inicializarRounds(nroCompetidor);
        this.competidores.add(competidor);
        this.rounds.put(competidor, administrador);
    }

    public void setCompetidor1(String competidor) {
        this.setCompetidor(competidor, 1);
    }


    public void setCompetidor2(String competidor){
        this.setCompetidor(competidor,2);
    }


    public String getCompetidor1(){
        return this.competidores.get(0);
    }

    public String getCompetidor2(){
        return this.competidores.get(1);
    }

    public int getPuntajeAcumuladoCompetidor(String nombreCompetidor) {

        AdministradorRound administradorRound =  this.rounds.get(nombreCompetidor);
        return administradorRound.getPuntajeAcumuladoTotal();

    }


    private void setRound(String nombreRound) {

        this.rounds.forEach((competidor, administradorRound) -> administradorRound.setRound(nombreRound));
    }

    public void puntuarPatronNumero(int nroPatron, int puntaje, String competidor) {

        AdministradorRound administradorRound = this.rounds.get(competidor);
        administradorRound.puntuarPatronNumero(nroPatron, puntaje);
    }

    public String getNombreRoundActual() {

        AdministradorRound administrador = this.rounds.get(this.getCompetidor1());
        return administrador.getNombreRoundActual();

    }

    public int getPuntajeAcumuladoEnRoundCompetidor(String competidor) {
        return this.rounds.get(competidor).getPuntajeAcumuladoRoundActual();
    }


    public void avanzarRound() {
        this.rounds.forEach((competidor, administradorRound) -> administradorRound.avanzarRound());

    }

    public String getAtacanteActual() {
        AdministradorRound administrador = this.rounds.get(this.getCompetidor1());
        int nroRound = administrador.getNumeroRound();
        System.out.println(nroRound);
        if(nroRound % 2 == 0) return this.getCompetidor2();
        return this.getCompetidor1();
    }

    public void setEasyMode() {
        this.setRound(FabricaRounds.EASY_MODE);
    }

    public void setHardMode(){
        this.setRound(FabricaRounds.HARD_MODE);
    }


    public void setTematicaIda() {
        this.setRound(FabricaRounds.TEMATICA_IDA);
    }

    public void setTematicaVuelta() {
        this.setRound(FabricaRounds.TEMATICA_VTA);
    }


    public void setPersonajes() {
        this.setRound(FabricaRounds.PERSONAJES);
    }
    public void setLibreIda() {
        this.setRound(FabricaRounds.LIBRE_IDA);
    }

    public void setLibreVuelta() {
        this.setRound(FabricaRounds.LIBRE_VTA);
    }

    public void setDeluxe() {
        this.setRound(FabricaRounds.DELUXE);
    }

}
