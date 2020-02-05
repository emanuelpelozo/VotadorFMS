package modelo.Batalla;

import java.util.ArrayList;
import java.util.HashMap;

public class AdministradorRound {

    private HashMap<String, Round> rounds;
    private Round roundActual;


    public AdministradorRound(){

        this.rounds = new HashMap<>();
        this.inicializarRounds();

    }

    private void inicializarRounds() {

        FabricaRounds fabrica = new FabricaRounds();
        ArrayList<Round> roundsCreados = fabrica.crearRounds();

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

    public void avanzarRound() throws ExcepcionRoundSinSiguiente{
        this.roundActual = this.roundActual.getSiguiente();
    }

    public void retrocederRound() throws ExcepcionRoundSinAnterior{
        this.roundActual = this.roundActual.getAnterior();
    }

}
