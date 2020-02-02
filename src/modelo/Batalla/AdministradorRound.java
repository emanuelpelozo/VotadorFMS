package modelo.Batalla;

import java.util.HashMap;

public class AdministradorRound {

    private HashMap<String, Round> rounds;


    public AdministradorRound(){

        rounds = new HashMap<>();
        this.inicializarRounds();

    }

    private void inicializarRounds() {

        rounds.put("EasyMode", new Round(5));

    }

    public void puntuarEaseMode(int nroPatron, int puntaje){

        rounds.get("EasyMode").votarPatron(nroPatron, puntaje);
    }

    public int getPuntajeAcumulado() {
        
        int puntajeAcumulado = 0;

        for (Round round: rounds.values()) {
            puntajeAcumulado+= round.getPuntajeAcumulado();
        }

        return puntajeAcumulado;
    }
}
