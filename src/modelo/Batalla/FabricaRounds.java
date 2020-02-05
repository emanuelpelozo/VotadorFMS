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

    public ArrayList crearRounds(){
        EnlazadorDeRounds enlazador = new EnlazadorDeRounds();
        ArrayList<Round> rounds = new ArrayList();

        crearPalabras(rounds);
        crearTematicas(rounds);
        crearPersonajes(rounds);
        crearRoundLibre(rounds);
        crearDeluxe(rounds);

        enlazador.enlazarRounds(rounds);
        return rounds;
    }

    private void crearPalabras(ArrayList rounds){
        rounds.add( new Round(EASY_MODE, ENTRADAS_EMODE));
        rounds.add( new Round(HARD_MODE, ENTRADAS_HMODE));
    }

    private void crearTematicas(ArrayList rounds) {
        rounds.add(new Round(TEMATICA_IDA, ENTRADAS_TEMATICA));
        rounds.add(new Round(TEMATICA_VTA, ENTRADAS_TEMATICA));
    }

    private void crearPersonajes(ArrayList rounds){
        rounds.add(new RoundBonificable(PERSONAJES, ENTRADAS_PJES));
    }

    private void crearRoundLibre(ArrayList rounds){
        rounds.add(new Round(LIBRE_IDA, ENTRADAS_LIBRE));
        rounds.add(new RoundBonificable(LIBRE_VTA, ENTRADAS_LIBRE));
    }

    private void crearDeluxe(ArrayList rounds) {

        rounds.add( new Round(DELUXE, ENTRADAS_DELUXE));
    }

}
