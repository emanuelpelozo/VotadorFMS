package test;

import modelo.Batalla.Batalla;
import modelo.Batalla.FabricaRounds;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatallaTest {

    private Batalla batalla;

    @Before
    public void setUp(){

        batalla = new Batalla();
        batalla.iniciarBatalla("Argentina");

    }

    @Test
    public void iniciarBatallaYElegirDosCompetidores(){

        batalla.setCompetidor1("Dtoke");
        batalla.setCompetidor2("Papo");


        assertEquals(batalla.getCompetidor1(), "Dtoke");
        assertEquals(batalla.getCompetidor2(), "Papo");
    }

    @Test
    public void alIniciarBatallaAmbosCompetidoresTienenPuntajeAcumuladoCero(){
        batalla.setCompetidor1("Dtoke");
        batalla.setCompetidor2("Papo");

        assertEquals(batalla.getPuntajeAcumuladoCompetidor("Dtoke"), 0);
        assertEquals(batalla.getPuntajeAcumuladoCompetidor("Papo"), 0);

    }

    @Test
    public void votarUnPatronEnRoundEasyModeModificaElPuntajeTotalDelCompetidorVotado(){

        batalla.setCompetidor1("Dtoke");

        int nroPatron = 1;
        int puntaje = 2;

        batalla.setRound(FabricaRounds.EASY_MODE);

        batalla.puntuarPatronNumero(nroPatron,puntaje,"Dtoke");

        assertEquals(batalla.getPuntajeAcumuladoCompetidor("Dtoke"), puntaje);
    }

    @Test
    public void votarUnPatronEnRoundEasyModeNoModificaElPuntajeTotalDelOtroCompetidor(){

        batalla.setCompetidor1("Dtoke");
        batalla.setCompetidor2("Stuart");
        int nroPatron = 1;
        int puntaje = 2;
        int puntajeEsperado = 0;

        batalla.setRound(FabricaRounds.EASY_MODE);

        batalla.puntuarPatronNumero(nroPatron,puntaje,"Dtoke");

        assertEquals(batalla.getPuntajeAcumuladoCompetidor("Stuart"), puntajeEsperado);
    }



}

