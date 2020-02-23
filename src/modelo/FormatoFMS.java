package modelo;

import javafx.scene.control.Label;
import modelo.Batalla.Batalla;
import modelo.Batalla.Rounds.ExcepcionRoundSinAnterior;
import modelo.Batalla.Rounds.ExcepcionRoundSinSiguiente;

import java.text.Normalizer;

public class FormatoFMS {

    private Batalla batalla;
    private String pais;

    private static FormatoFMS instancia_unica = null;

    private FormatoFMS(){

    }

    public static FormatoFMS getInstance(){
        if (instancia_unica == null)
            instancia_unica = new FormatoFMS();
        return instancia_unica;
    }



    public void iniciarBatallaNuevaEnPais(String pais, String competidor1, String competidor2){

        this.pais = pais;
        this.batalla = new Batalla();
        this.batalla.setBatallaEnPais(pais);
        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);
    }

    public void avanzarRound() throws ExcepcionRoundSinSiguiente {
        this.batalla.avanzarRound();
    }

    public void retrocederRound() throws ExcepcionRoundSinAnterior {
        this.batalla.retrocederRound();
    }

    public void puntuarPatronParaCompetidor(int nroPatron, int puntaje, String competidor){
        this.batalla.puntuarPatronNumero(nroPatron, puntaje, competidor);
    }

    public void puntuarFlowParaCompetidor(int pjeFlow, String competidor){
        this.batalla.puntuarFlow(pjeFlow, competidor);
    }

    public void puntuarSkillParaCompetidor(int pjeSkill, String competidor){
        this.batalla.puntuarSkill(pjeSkill, competidor);
    }
    public void puntuarPuestaEnEscenaParaCompetidor(int pjePuestaEscena, String competidor){
        this.batalla.puntuarPuestaEnEscena(pjePuestaEscena, competidor);
    }

    public int getPuntajeRoundActualParaCompetidor(String competidor){
        return this.batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor);
    }

    public int getPuntajeAcumuladoParaCompetidor(String competidor){
        return this.batalla.getPuntajeAcumuladoCompetidor(competidor);
    }

    public String getGanador(){
        return this.batalla.getGanador();
    }

    public void setEasyMode(){
        this.batalla.setEasyMode();
    }

    public void setHardMode(){
        this.batalla.setHardMode();
    }

    public void setTematicaIda(){
        this.batalla.setTematicaIda();
    }

    public void setTematicaVuelta(){
        this.batalla.setTematicaVuelta();
    }

    public void setPersonajes(){
        this.batalla.setPersonajes();
    }

    public void setLibreIda(){
        this.batalla.setLibreIda();
    }

    public void setLibreVuelta(){
        this.batalla.setLibreVuelta();
    }

    public void setDeluxe(){
        this.batalla.setDeluxe();
    }

    public String getCompetidorQueAtaca(){
        return this.batalla.getCompetidorQueAtaca();
    }

    public String getCompetidorQueResponde(){
        return this.batalla.getCompetidorQueResponde();
    }

    public String getPais() {
        return this.pais;
    }

    public void setRound(String nombreRound) {
        this.batalla.setRound(nombreRound);
    }

    public void bonificarEntradaRoundActual(int nroPatron, String nombreCompetidor) {
        this.batalla.bonificarEntradaRoundActual(nroPatron, nombreCompetidor);
    }

    public String getCompetidor1() {
        return this.batalla.getCompetidor1();
    }

    public String getCompetidor2() {
        return this.batalla.getCompetidor2();
    }

    public String getGanadorRoundActual() {
        return this.batalla.getGanadorRoundActual();
    }
}
