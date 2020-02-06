package test;

import modelo.Batalla.AdministradorRound;
import modelo.Batalla.ExcepcionRoundSinAnterior;
import modelo.Batalla.ExcepcionRoundSinSiguiente;
import modelo.Batalla.FabricaRounds;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdministradorRoundTest {

    private AdministradorRound admRound;

    @Before
    public void setUp(){
        admRound = new AdministradorRound();
        admRound.inicializarRounds(1);
    }

    @Test
    public void alIniciarAdministradorElRoundActualEsEasyMode(){
        String nombreEsperado = "Easy Mode";
        assertEquals( admRound.getNombreRoundActual(), nombreEsperado);

    }

    @Test
    public void alSetearNuevoRoundSeActualizaElRoundActual(){
        String roundASetear = FabricaRounds.PERSONAJES;
        String nombreEsperado = roundASetear;

        admRound.setRound(roundASetear);
        assertEquals(admRound.getNombreRoundActual(), nombreEsperado);
    }

    @Test
    public void alPuntuarPatronModificaElPuntajeAcumuladoDelRoundActual(){
        int puntaje = 2;
        int nroPatron = 1;

        admRound.puntuarPatronNumero(nroPatron, puntaje);

        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntaje);

    }

    @Test public void alPuntuarPatronNoModificaElPuntajeAcumuladoDeLosDemasRounds(){

        int puntaje = 3;
        int nroPatron = 2;
        int puntajeEsperado = 0;
        admRound.puntuarPatronNumero(nroPatron, puntaje);

        //Los demas rounds deben tener puntaje acumulado cero.
        admRound.setRound(FabricaRounds.HARD_MODE);
        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntajeEsperado);

        admRound.setRound(FabricaRounds.PERSONAJES);
        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntajeEsperado);

        admRound.setRound(FabricaRounds.DELUXE);
        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntajeEsperado);

    }

    @Test
    public void alPuntuarDosPatronesEnDiferentesRoundsSeAumentaElPuntajeTotal(){
        int puntaje1 = 3;
        int puntaje2 = 1;
        int nroPatron1 = 2;
        int nroPatron2 = 3;
        int puntajeEsperado = puntaje1 + puntaje2;

        admRound.setRound(FabricaRounds.HARD_MODE);
        admRound.puntuarPatronNumero(nroPatron1, puntaje1);

        admRound.setRound(FabricaRounds.LIBRE_IDA);
        admRound.puntuarPatronNumero(nroPatron2,puntaje2);

        assertEquals(admRound.getPuntajeAcumuladoTotal(), puntajeEsperado);
    }

    @Test
    public void alPuntuarUnRoundYLuegoVotarEnOtroElRoundAnteriorMantieneSuPuntajeAcumulado(){

        int puntaje1 = 2;
        int puntaje2 = 3;
        int puntajeEsperado= puntaje1;

        int nroPatron1 = 1;
        int nroPatron2 = 1;
        String round1 = FabricaRounds.PERSONAJES;
        admRound.setRound(round1);
        admRound.puntuarPatronNumero(nroPatron1, puntaje1);

        admRound.setRound(FabricaRounds.HARD_MODE);
        admRound.puntuarPatronNumero(nroPatron2, puntaje2);

        admRound.setRound(round1);
        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntajeEsperado);

    }

    @Test
    public void alSetearUnNuevoRoundSeActualizaElNombre(){
        String nuevoRound = FabricaRounds.PERSONAJES;

        admRound.setRound(nuevoRound);
        assertEquals(admRound.getNombreRoundActual(), nuevoRound);
    }

    @Test
    public void alAvanzarDeEasyModeObtenemosHardMode(){
        String nombreEsperado = FabricaRounds.HARD_MODE;
        admRound.avanzarRound();

        assertEquals(admRound.getNombreRoundActual(), nombreEsperado);

    }
    @Test
    public void alAvanzarDeEasyModeDosVecesObtenemosTematicaIda(){
        String nombreEsperado = FabricaRounds.TEMATICA_IDA;
        admRound.avanzarRound();
        admRound.avanzarRound();

        assertEquals(admRound.getNombreRoundActual(), nombreEsperado);

    }
    @Test
    public void alAvanzarDeEasyModeTresVecesObtenemosTematicaVuelta(){
        String nombreEsperado = FabricaRounds.TEMATICA_VTA;
        admRound.avanzarRound();
        admRound.avanzarRound();
        admRound.avanzarRound();

        assertEquals(admRound.getNombreRoundActual(), nombreEsperado);

    }

    @Test
    public void alAvanzarDeEasyModeCuatroVecesObtenemosPersonajes(){
        String nombreEsperado = FabricaRounds.PERSONAJES;

        for(int i = 0; i < 4; i++) admRound.avanzarRound();

        assertEquals(admRound.getNombreRoundActual(), nombreEsperado);

    }

    @Test
    public void alAvanzarDeEasyModeCincoVecesObtenemosLibreIda(){
        String nombreEsperado = FabricaRounds.LIBRE_IDA;

        for(int i = 0; i < 5; i++) admRound.avanzarRound();

        assertEquals(admRound.getNombreRoundActual(), nombreEsperado);

    }


    @Test
    public void alAvanzarDeEasyModeSeisVecesObtenemosLibreVuelta(){
        String nombreEsperado = FabricaRounds.LIBRE_VTA;

        for(int i = 0; i < 6; i++) admRound.avanzarRound();

        assertEquals(admRound.getNombreRoundActual(), nombreEsperado);

    }

    @Test
    public void alAvanzarDeEasyModeSieteVecesObtenemosDeluxe(){
        String nombreEsperado = FabricaRounds.DELUXE;

        for(int i = 0; i < 7; i++) admRound.avanzarRound();

        assertEquals(admRound.getNombreRoundActual(), nombreEsperado);

    }


    @Test (expected = ExcepcionRoundSinSiguiente.class)
    public void alAvanzarDeEasyModeOchoVecesObtenemosExcepcionRoundSinSiguiente(){
        String nombreEsperado = FabricaRounds.LIBRE_IDA;

        for(int i = 0; i < 8; i++) admRound.avanzarRound();

    }

    @Test(expected = ExcepcionRoundSinAnterior.class)
    public void alRetrocederDesdeEasyModeObtenemosExcepcionRoundSinAnterior(){

        admRound.retrocederRound();
    }


    @Test
    public void alSetearManualmentePersonajesYRetrocederObtengoTematicaVuelta(){
        String nombreEsperado = FabricaRounds.TEMATICA_VTA;
        admRound.setRound(FabricaRounds.PERSONAJES);
        admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }
    @Test
    public void alSetearManualmentePersonajesYRetrocederDosVecesObtengoTematicaIda(){
        String nombreEsperado = FabricaRounds.TEMATICA_IDA;
        admRound.setRound(FabricaRounds.PERSONAJES);
        admRound.retrocederRound();
        admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }


    @Test
    public void alSetearManualmenteDeluxeYRetrocederObtengoLibreVuelta(){
        String nombreEsperado = FabricaRounds.LIBRE_VTA;
        admRound.setRound(FabricaRounds.DELUXE);
        admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }

    @Test
    public void alSetearManualmenteDeluxeYRetrocederDosVecesObtengoLibreIda(){
        String nombreEsperado = FabricaRounds.LIBRE_IDA;
        admRound.setRound(FabricaRounds.DELUXE);
        admRound.retrocederRound();
        admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }

    @Test
    public void alSetearManualmenteDeluxeYRetrocederTresVecesObtengoPersonajes(){
        String nombreEsperado = FabricaRounds.PERSONAJES;
        admRound.setRound(FabricaRounds.DELUXE);
        for(int i = 0; i < 3; i++) admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }

    @Test
    public void alSetearManualmenteDeluxeYRetrocederCuatroVecesObtengoTematicaVuelta(){
        String nombreEsperado = FabricaRounds.TEMATICA_VTA;
        admRound.setRound(FabricaRounds.DELUXE);
        for(int i = 0; i < 4; i++) admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }

    @Test
    public void alSetearManualmenteDeluxeYRetrocederCincoVecesObtengoTematicaIda(){
        String nombreEsperado = FabricaRounds.TEMATICA_IDA;
        admRound.setRound(FabricaRounds.DELUXE);
        for(int i = 0; i < 5; i++) admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }


    @Test
    public void alSetearManualmenteDeluxeYRetrocederSeisVecesObtengoHardMode(){
        String nombreEsperado = FabricaRounds.HARD_MODE;
        admRound.setRound(FabricaRounds.DELUXE);
        for(int i = 0; i < 6; i++) admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }


    @Test
    public void alSetearManualmenteDeluxeYRetrocederSieteVecesObtengoEasyMode(){
        String nombreEsperado = FabricaRounds.EASY_MODE;
        admRound.setRound(FabricaRounds.DELUXE);
        for(int i = 0; i < 7; i++) admRound.retrocederRound();

        assertEquals(nombreEsperado, admRound.getNombreRoundActual());
    }

    @Test (expected = ExcepcionRoundSinAnterior.class)
    public void alSetearManualmenteDeluxeYRetrocederOchoVecesObtengoExcepcionSinAnterior(){
        admRound.setRound(FabricaRounds.DELUXE);
        for(int i = 0; i < 8; i++) admRound.retrocederRound();

    }

}
