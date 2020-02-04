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

        rounds.put(FabricaRounds.NOMBRE_EM, fabrica.crearEasyMode());
        rounds.put(FabricaRounds.NOMBRE_HM, fabrica.crearHardMode());
        rounds.put(FabricaRounds.NOMBRE_TEM, fabrica.crearTematica());
        rounds.put(FabricaRounds.NOMBRE_PJES, fabrica.crearPersonajes());
        rounds.put(FabricaRounds.NOMBRE_LIB_IDA, fabrica.crearLibreIda());
        rounds.put(FabricaRounds.NOMBRE_LIB_VTA, fabrica.crearLibreVuelta());
        rounds.put(FabricaRounds.NOMBRE_DLXE, fabrica.crearDeluxe());

        this.roundActual = rounds.get(FabricaRounds.NOMBRE_EM);

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
}
