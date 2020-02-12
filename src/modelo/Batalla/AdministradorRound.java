package modelo.Batalla;

import modelo.Batalla.Rounds.ExcepcionRoundSinAnterior;
import modelo.Batalla.Rounds.ExcepcionRoundSinSiguiente;
import modelo.Batalla.Rounds.Round;

import java.util.ArrayList;
import java.util.HashMap;

public class AdministradorRound {

    private HashMap<String, Round> rounds;
    private Round roundActual;


    public AdministradorRound(){

        this.rounds = new HashMap<String, Round>();

    }

    public void inicializarRounds(int nroCompetidor) {

        FabricaRounds fabrica = new FabricaRounds();
        ArrayList<Round> roundsCreados = fabrica.crearRoundsParaBatallaFMS(nroCompetidor);

        roundsCreados.forEach(round -> this.rounds.put(round.getNombre(), round));
        this.roundActual = this.rounds.get(FabricaRounds.EASY_MODE);
    }


    public int getPuntajeAcumuladoTotal() {
        
        int puntajeAcumulado = 0;

        for (Round round: rounds.values()) {
            puntajeAcumulado+= round.getPuntajeAcumulado();
        }

        return puntajeAcumulado;
    }

    public void setRound(String nombreRound) {
        this.roundActual = rounds.get(nombreRound);

    }

    public void puntuarPatronNumero(int nroPatron, int puntaje){

        this.roundActual.votarPatron(nroPatron, puntaje);
    }

    public String getNombreRoundActual() {
        return this.roundActual.getNombre();
    }

    public int getPuntajeAcumuladoRoundActual() {
       return this.roundActual.getPuntajeAcumulado();
    }

    public void avanzarRound() throws ExcepcionRoundSinSiguiente {
        this.roundActual = this.roundActual.getSiguiente();
    }

    public void retrocederRound() throws ExcepcionRoundSinAnterior {
        this.roundActual = this.roundActual.getAnterior();
    }


    public int getNumeroRound() {
       return this.roundActual.getOrden();
    }
}
