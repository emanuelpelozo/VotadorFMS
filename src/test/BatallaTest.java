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
        batalla.setBatallaEnPais("Argentina");

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
    public void alIniciarBatallaPrimerRoundEsEasyMode(){
        batalla.setCompetidor1("Papo");
        batalla.setCompetidor2("Dtoke");

        assertEquals(batalla.getNombreRoundActual(), FabricaRounds.EASY_MODE);
    }

    @Test
    public void votarUnPatronEnRoundEasyModeModificaElPuntajeTotalDelCompetidorVotado(){

        batalla.setCompetidor1("Dtoke");

        int nroPatron = 1;
        int puntaje = 2;

        batalla.setEasyMode();

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

        batalla.setEasyMode();

        batalla.puntuarPatronNumero(nroPatron,puntaje,"Dtoke");

        assertEquals(batalla.getPuntajeAcumuladoCompetidor("Stuart"), puntajeEsperado);
    }

    @Test
    public void votarUnPatronEnEasyModeActualizaElPuntajeAcumuladoDelRound(){
        batalla.setCompetidor1("Papo");
        batalla.setCompetidor2("DTO");

        int puntaje = 2;
        int nroPatron = 3;

        //Al iniciar se encuentra en easy mode()
        batalla.puntuarPatronNumero(nroPatron,puntaje, "DTO");

        assertEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor("DTO"), puntaje);

    }

    @Test
    public void votarUnPatronEnEasyModeNoActualizaElPuntajeAcumuladoDelRoundDelOtroCompetidor(){
        batalla.setCompetidor1("Papo");
        batalla.setCompetidor2("DTO");

        int puntaje = 2;
        int nroPatron = 3;
        int puntajeEsperado = 0;

        //Al iniciar se encuentra en easy mode()
        batalla.puntuarPatronNumero(nroPatron,puntaje, "DTO");

        assertEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor("Papo"), puntajeEsperado);
    }

    @Test
    public void alAvanzarDeRoundSeActualizaElRound(){

        String roundEsperado = FabricaRounds.HARD_MODE;
        batalla.setCompetidor1("Dto");
        batalla.setCompetidor2("Wos");

        batalla.avanzarRound();

        assertEquals(batalla.getNombreRoundActual(), roundEsperado);
    }

    @Test
    public void alAvanzarDeRoundSeActualizaELRoundEnLosDosCompetidores(){
        String competidor1 = "Papo";
        String competidor2 = "Dtoke";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        //Voto en el round actual a los dos competidores
        batalla.puntuarPatronNumero(2,3,competidor1);
        batalla.puntuarPatronNumero(1,4,competidor2);

        batalla.avanzarRound();
        //Al avanzar el round el puntaje debe ser cero porque todavia no han sido votados.
        assertEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1), 0);
        assertEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2), 0);


    }

    @Test
    public void enElEasyModeElCompetidorAtacanteEsElUno(){
        String competidor1 = "Stuart";
        String competidor2 = "Wos";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        assertEquals(competidor1, batalla.getAtacanteActual());

    }

    @Test
    public void setearBatallaActualizaElRoundActual(){
        batalla.setCompetidor2("WOS");
        batalla.setCompetidor1("PAPO");

        String roundEsperado1 = FabricaRounds.LIBRE_IDA;
        String roundEsperado2 = FabricaRounds.DELUXE;
        String roundEsperado3 = FabricaRounds.HARD_MODE;
        String roundEsperado4 = FabricaRounds.PERSONAJES;
        String roundEsperado5 = FabricaRounds.LIBRE_VTA;
        String roundEsperado6 = FabricaRounds.EASY_MODE;
        String roundEsperado7 = FabricaRounds.TEMATICA_IDA;
        String roundEsperado8 = FabricaRounds.TEMATICA_VTA;

        batalla.setLibreIda();
        assertEquals(batalla.getNombreRoundActual(), roundEsperado1);

        batalla.setDeluxe();
        assertEquals(batalla.getNombreRoundActual(), roundEsperado2);

        batalla.setHardMode();
        assertEquals(batalla.getNombreRoundActual(), roundEsperado3);

        batalla.setPersonajes();
        assertEquals(batalla.getNombreRoundActual(), roundEsperado4);

        batalla.setLibreVuelta();
        assertEquals(batalla.getNombreRoundActual(), roundEsperado5);

        batalla.setEasyMode();
        assertEquals(batalla.getNombreRoundActual(), roundEsperado6);

        batalla.setTematicaIda();
        assertEquals(batalla.getNombreRoundActual(), roundEsperado7);

        batalla.setTematicaVuelta();
        assertEquals(batalla.getNombreRoundActual(), roundEsperado8);

    }

    @Test
    public void enElHardModeElCompetidorAtacanteEsElDos(){
        String competidor1 = "Stuart";
        String competidor2 = "Wos";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setHardMode();

        assertEquals(competidor2, batalla.getAtacanteActual());

    }

    @Test
    public void enTematicasIdaElAtacanteEsElCompetidorUno(){
        String competidor1 = "Stuart";
        String competidor2 = "Wos";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setTematicaIda();

        assertEquals(competidor1, batalla.getAtacanteActual());

    }


    @Test
    public void enPersonajesElAtacanteEsElCompetidorUno(){
        String competidor1 = "Stuart";
        String competidor2 = "Wos";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();

        assertEquals(competidor1, batalla.getAtacanteActual());

    }

    @Test
    public void enLibreVueltaElAtacanteEsElCompetidorUno(){
        String competidor1 = "Stuart";
        String competidor2 = "Wos";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setLibreVuelta();

        assertEquals(competidor1, batalla.getAtacanteActual());

    }


    @Test
    public void enDeluxeIdaElAtacanteEsElCompetidorDos(){
        String competidor1 = "Stuart";
        String competidor2 = "Wos";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setDeluxe();

        assertEquals(competidor2, batalla.getAtacanteActual());

    }

    @Test
    public void enTematicasVueltaElAtacanteEsElCompetidorDos(){
        String competidor1 = "Stuart";
        String competidor2 = "Wos";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setTematicaVuelta();

        assertEquals(competidor2, batalla.getAtacanteActual());

    }


    @Test
    public void enLibreIdaElAtacanteEsElCompetidorDos(){
        String competidor1 = "Stuart";
        String competidor2 = "Wos";
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setDeluxe();

        assertEquals(competidor2, batalla.getAtacanteActual());

    }


}

