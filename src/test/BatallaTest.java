package test;

import modelo.Batalla.Batalla;
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
    public void votarUnPatronEnRoundEasyModeModificaElPuntajeTotal(){

        batalla.iniciarBatalla("Argentina");
        batalla.setCompetidor1("Dtoke");

        int nroPatron = 1;
        int puntaje = 2;

        batalla.puntuarPatronEasyMode(nroPatron,puntaje,"Dtoke");

        assertEquals(batalla.getPuntajeAcumuladoCompetidor("Dtoke"), puntaje);
    }


}

