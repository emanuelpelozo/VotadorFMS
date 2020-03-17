import modelo.Batalla.Batalla;
import modelo.FormatoFMS;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatoFMSTest {

    private FormatoFMS formatoFMS;
    private String competidor1;
    private String competidor2;

    @Before
    public void setUp(){
        formatoFMS = FormatoFMS.getInstance();
        competidor1 = "Papo";
        competidor2 = "Dtoke";
        formatoFMS.iniciarBatallaNuevaEnPais("Argentina",competidor1, competidor2);
    }

    @Test
    public void alIniciarLaDiferenciaMinimaParaReplicaEs5SiConsultoGanadorReciboReplica(){
        String ganador = formatoFMS.getGanador();
        assertEquals(ganador, Batalla.REPLICA);
    }

    @Test
    public void alModificarLaDiferenciaParaReplicaYVotarAUnCompetidorParaEsaDiferenciaSeDefineComoGanador(){
        int diferencia = 1;
        formatoFMS.setDistanciaMinimaParaReplica(diferencia);

        formatoFMS.puntuarPatronParaCompetidor(1,diferencia,competidor1);
        String ganador = formatoFMS.getGanador();
        assertEquals(ganador, competidor1);
    }

    @Test
    public void conLaDiferenciaDeReplicaDefaultSiTengoDiferenciaDeCuatroSigueDandoReplica(){
        int diferencia = 4;
        formatoFMS.puntuarPatronParaCompetidor(1,diferencia,competidor1);
        String ganador = formatoFMS.getGanador();
        assertEquals(ganador, Batalla.REPLICA);
    }

    @Test
    public void simulacionBatalla(){

//      Al iniciar Los dos competidores tienen puntaje 0 en el round
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor1), 0);
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor2), 0);

//      Al iniciar los dos competidores tienen puntaje 0 en el total
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor1), 0);
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor2), 0);

//      El primer round ataca competidor 1 y responde competidor 2
        assertEquals(formatoFMS.getCompetidorQueAtaca(), competidor1);
        assertEquals(formatoFMS.getCompetidorQueResponde(), competidor2);

//       Voto tres patrones para un competidor, se actualiza el puntaje
        formatoFMS.puntuarPatronParaCompetidor(1, 2, competidor1);
        formatoFMS.puntuarPatronParaCompetidor(2, 1, competidor1);
        formatoFMS.puntuarPatronParaCompetidor(3, 1, competidor1);

        int pjeRound = 2+1+1;
        int pjeAcumulado = 2+1+1;
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor1), pjeRound);
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor1), pjeAcumulado);

//       El segundo competidor tiene puntaje 0
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor2), 0);
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor2),0);

//      Vuelvo a puntuar un mismo patron en el round actual para competidor uno y se modifica
        formatoFMS.puntuarPatronParaCompetidor(1, 4, competidor1);
        pjeRound = 4+1+1;
        pjeAcumulado = 4+1+1;
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor1), pjeRound);
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor1), pjeAcumulado);

//       El segundo competidor tiene puntaje 0
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor2), 0);
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor2),0);

//       Voto al segundo competidor
        int pjeRound2 = 1;
        int pjeAcumulado2 = 1;
        formatoFMS.puntuarPatronParaCompetidor(1, 1, competidor2);
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor2), pjeRound2);
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor2), pjeAcumulado2);

//      Avanzo al hard mode
        formatoFMS.setHardMode();

//       Puntaje acumulado de ambos se mantiene, puntaje de round es 0
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor1), pjeAcumulado);
        assertEquals(formatoFMS.getPuntajeAcumuladoParaCompetidor(competidor2), pjeAcumulado2);

        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor2), 0);
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor1), 0);

//        Vuelvo a easy mode y compruebo que el puntaje de round se mantiene
        formatoFMS.setEasyMode();
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor1), pjeRound);
        assertEquals(formatoFMS.getPuntajeRoundActualParaCompetidor(competidor2), pjeRound2);

        formatoFMS.setHardMode();
        


    }





}
