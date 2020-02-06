package modelo.Batalla;

import java.util.ArrayList;
import java.util.Collection;

public class FabricaRounds {

    public static final int ENTRADAS_EMODE = 6;
    public static final int ENTRADAS_HMODE = 6;
    public static final int ENTRADAS_PJES = 4;
    public static final int ENTRADAS_TEMATICA = 4;
    public static final int ENTRADAS_LIBRE = 6;
    public static final int ENTRADAS_DELUXE = 11;

    public static final String EASY_MODE = "Easy Mode";
    public static final String HARD_MODE = "Hard Mode";
    public static final String TEMATICA_IDA = "Tematica Ida";
    public static final String TEMATICA_VTA = "Tematica Vuelta";
    public static final String PERSONAJES = "Personajes";
    public static final String LIBRE_IDA = "Libre Ida";
    public static final String LIBRE_VTA = "Libre Vuelta";
    public static final String DELUXE = "Deluxe";

    private int ordenRound;

    public ArrayList crearRoundsParaBatallaFMS(int nroCompetidor){
        EnlazadorDeRounds enlazador = new EnlazadorDeRounds();
        ArrayList<Round> rounds = new ArrayList();
        this.ordenRound = 1;
        crearPalabras(rounds);
        crearTematicas(rounds);
        crearPersonajes(rounds);
        crearRoundLibre(rounds, nroCompetidor);
        crearDeluxe(rounds);

        enlazador.enlazarRounds(rounds);
        return rounds;
    }


    private Round crearRoundConOrden(String nombre, int cantEntradas){
        Round round = new Round(nombre, cantEntradas);
        round.setOrden(this.ordenRound);
        this.ordenRound++;
        return round;
    }

    private RoundBonificable crearRoundBonificableConOrden(String nombre, int cantEntradas){
        RoundBonificable round = new RoundBonificable(nombre, cantEntradas);
        round.setOrden(this.ordenRound);
        this.ordenRound++;
        return round;
    }

    private void crearPalabras(ArrayList rounds){

        rounds.add(this.crearRoundConOrden(EASY_MODE, ENTRADAS_EMODE) );
        rounds.add(this.crearRoundConOrden(HARD_MODE, ENTRADAS_HMODE) );

    }

    private void crearTematicas(ArrayList rounds) {
        rounds.add(this.crearRoundConOrden(TEMATICA_IDA, ENTRADAS_TEMATICA));
        rounds.add(this.crearRoundConOrden(TEMATICA_VTA, ENTRADAS_TEMATICA));
    }

    private void crearPersonajes(ArrayList rounds){
        rounds.add(this.crearRoundBonificableConOrden(PERSONAJES, ENTRADAS_PJES));
    }

    private void crearRoundLibre(ArrayList rounds, int nroCompetidor){

        if(nroCompetidor == 1) {
            rounds.add(this.crearRoundConOrden(LIBRE_IDA, ENTRADAS_LIBRE));
            rounds.add(this.crearRoundBonificableConOrden(LIBRE_VTA, ENTRADAS_LIBRE));
        }
        else{
            rounds.add(this.crearRoundBonificableConOrden(LIBRE_IDA, ENTRADAS_LIBRE));
            rounds.add(this.crearRoundConOrden(LIBRE_VTA, ENTRADAS_LIBRE));
        }
    }

    private void crearDeluxe(ArrayList rounds) {

        rounds.add( this.crearRoundConOrden(DELUXE, ENTRADAS_DELUXE));
    }

}
