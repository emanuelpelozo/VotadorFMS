import modelo.Batalla.Rounds.ExcepcionRoundSinAnterior;
import modelo.Batalla.Rounds.ExcepcionRoundSinSiguiente;
import modelo.Batalla.Rounds.Round;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundTest {

    private Round round;
    private int cantEntradas;

    @Before
    public void setUp() throws Exception {

        this.cantEntradas = 5;
        this.round = new Round("Round", this.cantEntradas);
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


    @Test
    public void alSetearSiguienteParaUnRoundYLuegoAvanzarObtengoElRoundSiguiente()  {

        String nombreRoundSig = "Round siguiente";
        Round roundSiguiente = new Round(nombreRoundSig, 4);

        this.round.setSiguiente(roundSiguiente);

        assertEquals(this.round.getSiguiente().getNombre(), nombreRoundSig);


    }

    @Test (expected = ExcepcionRoundSinSiguiente.class)
    public void alAvanzarEnUnRoundQueNoTieneSeteadoSiguienteSeLanzaExcepcionRoundNoTieneSiguiente(){

        this.round.setSiguiente(null);
        this.round.getSiguiente();

    }

    @Test(expected = ExcepcionRoundSinSiguiente.class)
    public void alCrearseElRoundNoTieneSeteadoSiguienteDebeLanzarExcepcion(){
        this.round.getSiguiente();
    }


    @Test(expected = ExcepcionRoundSinAnterior.class)
    public void alCrearseElRoundNoTieneSeteadoAnteriorDebeLanzarExcepcion(){
        this.round.getAnterior();
    }


    @Test (expected = ExcepcionRoundSinAnterior.class)
    public void alAvanzarEnUnRoundQueNoTieneSeteadoAnteriorSeLanzaExcepcionRoundNoTieneSiguiente(){

        this.round.setAnterior(null);
        this.round.getAnterior();

    }

    @Test
    public void puntuarCasillaDeFlowModificaElPuntajeDelRound(){
        int pjeFlow = 2;

        //Puntaje inicial es cero
        assertEquals(0, round.getPuntajeAcumulado());

        round.puntuarFlow(pjeFlow);
        assertEquals(pjeFlow, round.getPuntajeAcumulado());

    }

    @Test
    public void puntuarCasillaDeFlowSeCuentaSoloUnaVezDentroDelRound(){
        int pjeFlow = 2;
        int pje1 = 3;
        int pje2 = 4;
        int pje3 = 2;
        int pjeEntradas = pje1 + pje2 + pje3;

        round.votarPatron(1, pje1);
        round.votarPatron(2, pje2);
        round.votarPatron(3, pje3);

        round.puntuarFlow(pjeFlow);

        assertEquals(pjeEntradas + pjeFlow, round.getPuntajeAcumulado());

    }

    @Test
    public void PuntuarFlowDosVecesModificarCasillaDeFlowYActualizaElPuntajeDelRound(){
        int pjeFlow = 2;
        int pjeFlow2 = 1;
        int pje1 = 3;
        int pje2 = 4;
        int pje3 = 2;
        int pjeEntradas = pje1 + pje2 + pje3;

        round.votarPatron(1, pje1);
        round.votarPatron(2, pje2);
        round.votarPatron(3, pje3);

        round.puntuarFlow(pjeFlow);

        assertEquals(pjeEntradas + pjeFlow, round.getPuntajeAcumulado());

        round.puntuarFlow(pjeFlow2);
        assertEquals(pjeEntradas + pjeFlow2, round.getPuntajeAcumulado());

    }


    @Test
    public void puntuarCasillaDeSkillModificaElPuntajeDelRound(){
        int pjeSkill = 2;

        //Puntaje inicial es cero
        assertEquals(0, round.getPuntajeAcumulado());

        round.puntuarSkill(pjeSkill);
        assertEquals(pjeSkill, round.getPuntajeAcumulado());

    }

    @Test
    public void puntuarCasillaDeSkillSeCuentaSoloUnaVezDentroDelRound(){
        int pjeSkill = 2;
        int pje1 = 3;
        int pje2 = 4;
        int pje3 = 2;
        int pjeEntradas = pje1 + pje2 + pje3;

        round.votarPatron(1, pje1);
        round.votarPatron(2, pje2);
        round.votarPatron(3, pje3);

        round.puntuarSkill(pjeSkill);

        assertEquals(pjeEntradas + pjeSkill, round.getPuntajeAcumulado());

    }

    @Test
    public void PuntuarSkillDosVecesModificarCasillaDeFlowYActualizaElPuntajeDelRound(){
        int pjeSkill = 2;
        int pjeSkill2 = 1;
        int pje1 = 3;
        int pje2 = 4;
        int pje3 = 2;
        int pjeEntradas = pje1 + pje2 + pje3;

        round.votarPatron(1, pje1);
        round.votarPatron(2, pje2);
        round.votarPatron(3, pje3);

        round.puntuarFlow(pjeSkill);

        assertEquals(pjeEntradas + pjeSkill, round.getPuntajeAcumulado());

        round.puntuarFlow(pjeSkill2);
        assertEquals(pjeEntradas + pjeSkill2, round.getPuntajeAcumulado());

    }

    @Test
    public void puntuarCasillaDePuestaEnEscenaModificaElPuntajeDelRound(){
        int pjePtaEscena = 2;

        //Puntaje inicial es cero
        assertEquals(0, round.getPuntajeAcumulado());

        round.puntuarSkill(pjePtaEscena);
        assertEquals(pjePtaEscena, round.getPuntajeAcumulado());

    }

    @Test
    public void puntuarCasillaDePuestaEnEscenaSeCuentaSoloUnaVezDentroDelRound(){
        int pjePtaEscena = 2;
        int pje1 = 3;
        int pje2 = 4;
        int pje3 = 2;
        int pjeEntradas = pje1 + pje2 + pje3;

        round.votarPatron(1, pje1);
        round.votarPatron(2, pje2);
        round.votarPatron(3, pje3);

        round.puntuarPuestaEnEscena(pjePtaEscena);

        assertEquals(pjeEntradas + pjePtaEscena, round.getPuntajeAcumulado());

    }

    @Test
    public void PuntuarPuestaEnEscenaDosVecesModificarCasillaDeFlowYActualizaElPuntajeDelRound(){
        int pjePtaEscena = 2;
        int pjePtaEscena2 = 1;
        int pje1 = 3;
        int pje2 = 4;
        int pje3 = 2;
        int pjeEntradas = pje1 + pje2 + pje3;

        round.votarPatron(1, pje1);
        round.votarPatron(2, pje2);
        round.votarPatron(3, pje3);

        round.puntuarFlow(pjePtaEscena);

        assertEquals(pjeEntradas + pjePtaEscena, round.getPuntajeAcumulado());

        round.puntuarFlow(pjePtaEscena2);
        assertEquals(pjeEntradas + pjePtaEscena2, round.getPuntajeAcumulado());

    }




}
