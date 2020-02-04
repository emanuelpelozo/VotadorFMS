package test;

import modelo.Batalla.AdministradorRound;
import modelo.Batalla.FabricaRounds;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdministradorRoundTest {

    private AdministradorRound admRound;

    @Before
    public void setUp(){
        admRound = new AdministradorRound();
    }

    @Test
    public void alIniciarAdministradorElRoundActualEsEasyMode(){
        String nombreEsperado = "Easy Mode";
        assertEquals( admRound.getNombreRoundActual(), nombreEsperado);

    }

    @Test
    public void alSetearNuevoRoundSeActualizaElRoundActual(){
        String roundASetear = FabricaRounds.NOMBRE_PJES;
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
        admRound.setRound(FabricaRounds.NOMBRE_HM);
        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntajeEsperado);

        admRound.setRound(FabricaRounds.NOMBRE_PJES);
        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntajeEsperado);

        admRound.setRound(FabricaRounds.NOMBRE_DLXE);
        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntajeEsperado);

    }

    @Test
    public void alPuntuarDosPatronesEnDiferentesRoundsSeAumentaElPuntajeTotal(){
        int puntaje1 = 3;
        int puntaje2 = 1;
        int nroPatron1 = 2;
        int nroPatron2 = 3;
        int puntajeEsperado = puntaje1 + puntaje2;

        admRound.setRound(FabricaRounds.NOMBRE_HM);
        admRound.puntuarPatronNumero(nroPatron1, puntaje1);

        admRound.setRound(FabricaRounds.NOMBRE_LIB_IDA);
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
        String round1 = FabricaRounds.NOMBRE_PJES;
        admRound.setRound(round1);
        admRound.puntuarPatronNumero(nroPatron1, puntaje1);

        admRound.setRound(FabricaRounds.NOMBRE_HM);
        admRound.puntuarPatronNumero(nroPatron2, puntaje2);

        admRound.setRound(round1);
        assertEquals(admRound.getPuntajeAcumuladoRoundActual(), puntajeEsperado);

    }

    @Test
    public void alSetearUnNuevoRoundSeActualizaElNombre(){
        String nuevoRound = FabricaRounds.NOMBRE_PJES;

        admRound.setRound(nuevoRound);
        assertEquals(admRound.getNombreRoundActual(), nuevoRound);
    }


}
