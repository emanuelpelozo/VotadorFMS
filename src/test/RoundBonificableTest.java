package test;

import modelo.Batalla.RoundBonificable;
import org.junit.Before;
import org.junit.Test;

import java.net.PortUnreachableException;

import static org.junit.Assert.assertEquals;

public class RoundBonificableTest {

    private RoundBonificable round;
    private int cantEntradas;

    @Before
    public void setUp(){
        this.cantEntradas = 4;
        this.round = new RoundBonificable("Round", this.cantEntradas);
    }

    @Test
    public void alIniciarRoundBonificableTienePuntajeAcumuladoCero(){
        int puntajeEsperado = 0;
        assertEquals(this.round.getPuntajeAcumulado(), puntajeEsperado);
    }

    @Test
    public void alPuntuarPatronSinBonificarElPuntajeDelPatronSeMantieneIgual(){
        int puntajeEsperado = 2;
        int nroPatron = 1;
        this.round.votarPatron(nroPatron, puntajeEsperado);

        assertEquals(round.getPuntajePatron(nroPatron), puntajeEsperado);
    }

    @Test
    public void alPuntuarPatronSinBonificarElPuntajeAcumuladoSeMantieneIgual(){
        int puntajeEsperado = 2;
        int nroPatron = 1;
        this.round.votarPatron(nroPatron, puntajeEsperado);

        assertEquals(round.getPuntajeAcumulado(), puntajeEsperado);
    }

    @Test
    public void alPuntuarPatronConBonificacionSeAumentaEnUnoElPuntajeDelPatron(){
        int puntajePatron = 2;
        int nroPatron = 1;
        int puntajeEsperado = puntajePatron + 1 ;

        this.round.votarPatron(nroPatron, puntajePatron);
        this.round.bonificarEntrada(nroPatron);
        assertEquals( puntajeEsperado, this.round.getPuntajePatron(nroPatron));

    }

    @Test
    public void alPuntuarPatronConBonificacionSeAumentaEnUnoElPuntajeAcumulado(){
        int puntajePatron = 2;
        int nroPatron = 2 ;
        int puntajeEsperado = puntajePatron + 1 ;

        this.round.votarPatron(nroPatron, puntajePatron);
        this.round.bonificarEntrada(nroPatron);

        assertEquals(puntajeEsperado, this.round.getPuntajeAcumulado());

    }


    @Test
    public void alDesbonificarPatronSinBonificacionSeMantieneElPuntajeDelPatron(){
        int puntajePatron = 3;
        int nroPatron = 3;
        int puntajeEsperado = 3;

        this.round.votarPatron(nroPatron, puntajePatron);
        assertEquals(puntajeEsperado, this.round.getPuntajePatron(nroPatron));

        this.round.desbonificarEntrada(nroPatron);
        assertEquals(puntajeEsperado, this.round.getPuntajePatron(nroPatron));
    }

    @Test
    public void alDesbonificarPatronPreviamenteBonificadoMantieneElNumeroVotadoSinBonificacion(){
        int puntajePatron = 1;
        int nroPatron = 2;
        int puntajeBonificado = puntajePatron + 1;
        int puntajeDesbonificado = puntajePatron;

        this.round.votarPatron(nroPatron, puntajePatron);
        this.round.bonificarEntrada(nroPatron);
        assertEquals(puntajeBonificado, this.round.getPuntajePatron(nroPatron));

        this.round.desbonificarEntrada(nroPatron);
        assertEquals(puntajeDesbonificado, this.round.getPuntajePatron(nroPatron));

    }

    @Test
    public void alBonificarDosVecesUnPatronSoloSumaUnoAlPuntajeActual(){
        int puntajePatron = 1;
        int nroPatron = 2;
        int puntajeBonificado = puntajePatron + 1;

        this.round.votarPatron(nroPatron, puntajePatron);
        this.round.bonificarEntrada(nroPatron);
        assertEquals(puntajeBonificado, this.round.getPuntajePatron(nroPatron));

        this.round.bonificarEntrada(nroPatron);
        assertEquals(puntajeBonificado, this.round.getPuntajePatron(nroPatron));
    }

    @Test
    public void alDesbonificarUnPatronNoBonificadoNoAfectaAlPuntajeDelPatron(){

        int puntajePatron = 1;
        int nroPatron = 2;
        int puntajeDesbonificado = puntajePatron;

        this.round.votarPatron(nroPatron, puntajePatron);
        this.round.desbonificarEntrada(nroPatron);
        assertEquals(puntajeDesbonificado, this.round.getPuntajePatron(nroPatron));
    }

    @Test
    public void alDesbonificarUnPatronNoBonificadoNoAfeectaAlPuntajeAcumulado(){
        int puntajePatron = 3;
        int nroPatron = 2;
        int puntajeDesbonificado = puntajePatron;

        this.round.votarPatron(nroPatron, puntajePatron);
        this.round.desbonificarEntrada(nroPatron);
        assertEquals(puntajeDesbonificado, this.round.getPuntajeAcumulado());
    }


    @Test
    public void alBonificarUnPatronYLuegoDesbonificarUnPatronDiferenteSinBonificacionSeMantieneElPuntajeBonificado(){
        int puntajePatron = 4;
        int puntajePatron2 = 2;
        int nroPatron = 3;
        int nroPatron2 = 2;
        int puntajeBonificado = puntajePatron + 1;


        this.round.votarPatron(nroPatron, puntajePatron);
        this.round.bonificarEntrada(nroPatron);
        assertEquals(puntajeBonificado, this.round.getPuntajePatron(nroPatron));

        this.round.desbonificarEntrada(nroPatron2);
        assertEquals(puntajeBonificado, this.round.getPuntajePatron(nroPatron));

    }

}



