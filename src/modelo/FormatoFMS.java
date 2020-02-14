package modelo;

import modelo.Batalla.Batalla;
import modelo.Batalla.Rounds.ExcepcionRoundSinAnterior;
import modelo.Batalla.Rounds.ExcepcionRoundSinSiguiente;

public class FormatoFMS {

    private Batalla batalla;


    public void iniciarBatallaNuevaEnPais(String pais, String competidor1, String competidor2){
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
}
