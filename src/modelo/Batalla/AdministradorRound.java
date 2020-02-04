package modelo.Batalla;

import java.util.HashMap;

public class AdministradorRound {

    private HashMap<String, Round> rounds;
    private Round roundActual;
    private FabricaRounds fabrica;


    public AdministradorRound(){

        this.rounds = new HashMap<>();
        this.fabrica = new FabricaRounds();
        this.inicializarRounds();

    }

    private void inicializarRounds() {

        rounds.put("Easy Mode", fabrica.crearEasyMode());
        rounds.put("Hard Mode", fabrica.crearHardMode());
        rounds.put("Tematica", fabrica.crearTematica());
        rounds.put("Personajes", fabrica.crearPersonajes());
        rounds.put("Libre", fabrica.crearLibreIda());
        rounds.put("Deluxe", fabrica.crearDeluxe());

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
}
