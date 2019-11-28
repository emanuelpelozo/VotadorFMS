package test;

import modelo.Batalla.Round;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundTest {

    private Round round;
    private int cantEntradas;

    @Before
    public void setUp() throws Exception {

        this.cantEntradas = 5;
        this.round = new Round(this.cantEntradas);
    }

    @Test
    public void puntajeAcumuladoDeRoundAlComenzarEsCero() {
        int puntajeEsperado = 0;
        assertEquals(puntajeEsperado, round.getPuntajeAcumulado());

    }

    @Test
    public void alVotarPrimeraEntradaSeActualizaElPuntajeAcumulado() {
        int puntajeEsperado = 2;
        int nroPatron = 1;

        //Antes de votar el puntaje es cero
        assertEquals(0, round.getPuntajeAcumulado());

        //Despues de votar se actualiza el puntaje
        round.votarPatron(nroPatron, puntajeEsperado);
        assertEquals(puntajeEsperado, round.getPuntajeAcumulado());

    }

    @Test
    public void alPuntuarEntradaPorPrimeraVezSeInicializaSuValor(){
        int puntajeEsperado = 4;
        int nroPatron = 2;

        //Antes de votar cero
        assertEquals(0, round.getPuntajePatron(nroPatron));

        //Despues de votar, se actualiza
        round.votarPatron(nroPatron, puntajeEsperado);
        assertEquals(puntajeEsperado, round.getPuntajePatron(nroPatron));

    }
    @Test
    public void alPuntuarNuevamenteLaEntradaSeActualizaElValorDeLaEntrada(){

        int puntajeAntiguo = 1;
        int puntajeNuevo = 3;
        int nroPatron = 3;

        round.votarPatron(nroPatron, puntajeAntiguo);

        //Actualizamos el valor
        round.votarPatron(nroPatron, puntajeNuevo);

        assertEquals(puntajeNuevo, round.getPuntajePatron(nroPatron));

    }

    @Test
    public void alPuntuarNuevamenteUnaEntradaSeActualizaElPuntajeAcumulado(){
        int puntajeAntiguo = 1;
        int puntajeNuevo = 3;
        int nroPatron = 3;

        round.votarPatron(nroPatron, puntajeAntiguo);

        //Actualizamos el valor
        round.votarPatron(nroPatron, puntajeNuevo);
        assertEquals(puntajeNuevo, round.getPuntajeAcumulado());

    }

    @Test
    public void alPuntuarPorPrimeraVezDosEntradaDistintasSeAcumulaElPuntajeTotal(){
        int puntaje1 = 1;
        int puntaje2 = 3;
        int nroPatron1 = 3;
        int nroPatron2 = 2;

        round.votarPatron(nroPatron1, puntaje1);
        round.votarPatron(nroPatron2, puntaje2);

        assertEquals(puntaje1 + puntaje2, round.getPuntajeAcumulado());
    }


    @Test
    public void alTenerVotadosTresPatronesYLuegoModificarUnoSeActualizaElPuntajeAcumulado(){

        int puntaje1 = 1;
        int puntaje2 = 3;
        int puntaje3 = 1;
        int nuevoPuntaje3 = 4;

        int nroPatron1 = 3;
        int nroPatron2 = 2;
        int nroPatron3 = 1;

        round.votarPatron(nroPatron1, puntaje1);
        round.votarPatron(nroPatron2, puntaje2);
        round.votarPatron(nroPatron3, puntaje3);

        //El puntaje acumulado es la suma de todos los puntajes
        assertEquals(puntaje1+puntaje2+puntaje3, round.getPuntajeAcumulado());

        //Al modificar un puntaje se actualiza el puntaje acumulado
        round.votarPatron(nroPatron3, nuevoPuntaje3);
        assertEquals( puntaje1+puntaje2+nuevoPuntaje3, round.getPuntajeAcumulado());
    }


}
