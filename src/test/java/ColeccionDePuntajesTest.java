import modelo.Batalla.Batalla;
import modelo.Batalla.Rounds.ColeccionDePuntajes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColeccionDePuntajesTest {

    private ColeccionDePuntajes puntajes;
    private int cantEntradas ;

    @Before
    public void setUp(){
        this.cantEntradas = 4;
        puntajes = new ColeccionDePuntajes(this.cantEntradas);
    }

    @Test
    public void alIniciarElPuntajeAcumuladoEsCero(){
        assertEquals(0, puntajes.getPuntajeAcumulado());
    }

    @Test
    public void alIniciarElPuntajeDeCadaEntradaEsCero(){
        int pjeEsperado = 0;

        for( int i = 1; i <=this.cantEntradas ; i++){

            assertEquals(pjeEsperado, puntajes.getPuntajeDeEntrada(i));
        }
    }

    @Test
    public void alPuntuarUnaEntradaSeModificaElPuntajeAcumulado(){
        int nroEntrada = 1;
        int puntaje = 3;
        puntajes.votarEntrada(nroEntrada, puntaje);
        assertEquals(puntaje, puntajes.getPuntajeAcumulado());
    }

    @Test
    public void alPuntuarUnaEntradaSeModificaElPuntajeDeLaEntradaVotada(){
        int nroEntrada = 1;
        int puntaje = 3;
        puntajes.votarEntrada(nroEntrada, puntaje);
        assertEquals(puntaje, puntajes.getPuntajeDeEntrada(nroEntrada));

    }


    @Test
    public void alPuntuarMasDeUnaVezUnaEntradaSeModificaElPuntajeDeLaEntradaVotadaPorElUltimoVotado(){
        int nroEntrada = 1;
        int puntaje = 3;
        int puntaje2 = 1;
        int puntaje3 = 2;
        puntajes.votarEntrada(nroEntrada, puntaje);
        assertEquals(puntaje, puntajes.getPuntajeDeEntrada(nroEntrada));

        puntajes.votarEntrada(nroEntrada, puntaje2);
        assertEquals(puntaje2, puntajes.getPuntajeDeEntrada(nroEntrada));

        puntajes.votarEntrada(nroEntrada, puntaje3);
        assertEquals(puntaje3, puntajes.getPuntajeDeEntrada(nroEntrada));
    }




}

