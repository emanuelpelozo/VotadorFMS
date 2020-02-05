package test;

import modelo.Batalla.EnlazadorDeRounds;
import modelo.Batalla.ExcepcionRoundSinAnterior;
import modelo.Batalla.ExcepcionRoundSinSiguiente;
import modelo.Batalla.Round;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EnlazadorDeRoundsTest {

    private EnlazadorDeRounds enlazador;
    private Round round1;
    private Round round2;
    private Round round3;

    @Before
    public void setUp(){
        this.enlazador = new EnlazadorDeRounds();
        this.round1 = new Round("round1", 3);
        this.round2 = new Round("round2", 4);
        this.round3 = new Round("round3", 2);

    }

    @Test (expected = ExcepcionRoundSinAnterior.class)
    public void alEnlazarUnaListaDeRoundsElPrimerValorNoTieneAnteriorYLanzaExcepcion(){
        ArrayList<Round> rounds = new ArrayList();

        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);

        this.enlazador.enlazarRounds(rounds);

        rounds.get(0).getAnterior();

    }


    @Test (expected = ExcepcionRoundSinSiguiente.class)
    public void alEnlazarUnaListaDeRoundsElUltimoValorNoTieneSiguienteYLanzaExcepcion(){
        ArrayList<Round> rounds = new ArrayList();

        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);

        this.enlazador.enlazarRounds(rounds);

        rounds.get(2).getSiguiente();

    }
    @Test
    public void alEnlazarUnaListaDeRoundsElSegundoValorTieneDeAnteriorAlPrimero(){
        ArrayList<Round> rounds = new ArrayList();

        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);

        this.enlazador.enlazarRounds(rounds);

        assertEquals( rounds.get(1).getAnterior(), round1);
    }

    @Test
    public void alEnlazarUnaListaDeRoundsElPrimerValorTieneDeSiguienteAlSegundo(){
        ArrayList<Round> rounds = new ArrayList();

        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);

        this.enlazador.enlazarRounds(rounds);

        assertEquals( rounds.get(0).getSiguiente(), round2);
    }

    @Test
    public void alEnlazarUnaListaDeRoundsElAnteultimoTieneDeSiguienteAlUltimo(){
        ArrayList<Round> rounds = new ArrayList();

        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);

        this.enlazador.enlazarRounds(rounds);

        assertEquals(rounds.get(1).getSiguiente(), round3);

    }


    @Test
    public void alEnlazarUnaListaDeRoundsElUltimoTieneDeAnteriorAlAnteultimo(){
        ArrayList<Round> rounds = new ArrayList();

        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);

        this.enlazador.enlazarRounds(rounds);

        assertEquals(rounds.get(2).getAnterior(), round2);

    }


}
