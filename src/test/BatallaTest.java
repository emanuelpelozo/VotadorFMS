package test;

import modelo.Batalla.Batalla;
import modelo.Batalla.FabricaRounds;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BatallaTest {

    private Batalla batalla;
    private String competidor1;
    private String competidor2;
    private String competidor3;


    @Before
    public void setUp(){

        batalla = new Batalla();
        batalla.setBatallaEnPais("Argentina");

        this.competidor1 = "Stuart";
        this.competidor1 = "Papo";
        this.competidor3 = "Dtoke";
    }

    @Test
    public void iniciarBatallaYElegirDosCompetidores(){

        batalla.setCompetidor1(this.competidor1);
        batalla.setCompetidor2(this.competidor2);

        assertEquals(batalla.getCompetidor1(), this.competidor1);
        assertEquals(batalla.getCompetidor2(), this.competidor2);
    }

    @Test
    public void alIniciarBatallaAmbosCompetidoresTienenPuntajeAcumuladoCero(){
        batalla.setCompetidor1(this.competidor1);
        batalla.setCompetidor2(this.competidor2);

        assertEquals(batalla.getPuntajeAcumuladoCompetidor(competidor1), 0);
        assertEquals(batalla.getPuntajeAcumuladoCompetidor(competidor2), 0);

    }

    @Test
    public void alIniciarBatallaPrimerRoundEsEasyMode(){
        batalla.setCompetidor1(this.competidor1);
        batalla.setCompetidor2(this.competidor2);

        assertEquals(batalla.getNombreRoundActual(), FabricaRounds.EASY_MODE);
    }

    @Test
    public void votarUnPatronEnRoundEasyModeModificaElPuntajeTotalDelCompetidorVotado(){

        batalla.setCompetidor1(this.competidor1);

        int nroPatron = 1;
        int puntaje = 2;

        batalla.setEasyMode();

        batalla.puntuarPatronNumero(nroPatron,puntaje,this.competidor1);

        assertEquals(batalla.getPuntajeAcumuladoCompetidor(this.competidor1), puntaje);
    }

    @Test
    public void votarUnPatronEnRoundEasyModeNoModificaElPuntajeTotalDelOtroCompetidor(){

        batalla.setCompetidor1(this.competidor3);
        batalla.setCompetidor2(this.competidor2);
        int nroPatron = 1;
        int puntaje = 2;
        int puntajeEsperado = 0;

        batalla.setEasyMode();

        batalla.puntuarPatronNumero(nroPatron,puntaje,this.competidor3);

        assertEquals(batalla.getPuntajeAcumuladoCompetidor(this.competidor2), puntajeEsperado);
    }

    @Test
    public void votarUnPatronEnEasyModeActualizaElPuntajeAcumuladoDelRound(){
        batalla.setCompetidor1(this.competidor1);
        batalla.setCompetidor2(this.competidor2);

        int puntaje = 2;
        int nroPatron = 3;

        //Al iniciar se encuentra en easy mode()
        batalla.puntuarPatronNumero(nroPatron,puntaje, this.competidor1);

        assertEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor(this.competidor1), puntaje);

    }

    @Test
    public void votarUnPatronEnEasyModeNoActualizaElPuntajeAcumuladoDelRoundDelOtroCompetidor(){
        batalla.setCompetidor1(this.competidor1);
        batalla.setCompetidor2(this.competidor2);

        int puntaje = 2;
        int nroPatron = 3;
        int puntajeEsperado = 0;

        //Al iniciar se encuentra en easy mode()
        batalla.puntuarPatronNumero(nroPatron,puntaje, this.competidor2);

        assertEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor(this.competidor1), puntajeEsperado);
    }

    @Test
    public void alAvanzarDeRoundSeActualizaElRound(){

        String roundEsperado = FabricaRounds.HARD_MODE;
        batalla.setCompetidor1(this.competidor1);
        batalla.setCompetidor2(this.competidor2);

        batalla.avanzarRound();

        assertEquals(batalla.getNombreRoundActual(), roundEsperado);
    }

    @Test
    public void alAvanzarDeRoundSeActualizaELRoundEnLosDosCompetidores(){

        batalla.setCompetidor1(this.competidor1);
        batalla.setCompetidor2(this.competidor2);

        //Voto en el round actual a los dos competidores
        batalla.puntuarPatronNumero(2,3,competidor1);
        batalla.puntuarPatronNumero(1,4,competidor2);

        batalla.avanzarRound();
        //Al avanzar el round el puntaje debe ser cero porque todavia no han sido votados.
        assertEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1), 0);
        assertEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2), 0);


    }

    @Test
    public void setearBatallaActualizaElRoundActual(){
        batalla.setCompetidor2(this.competidor2);
        batalla.setCompetidor1(this.competidor1);

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
    public void enElEasyModeElCompetidorAtacanteEsElUno(){

        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        assertEquals(competidor1, batalla.getCompetidorQueAtaca());

    }

    @Test
    public void enElHardModeElCompetidorAtacanteEsElDos(){
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setHardMode();

        assertEquals(competidor2, batalla.getCompetidorQueAtaca());

    }

    @Test
    public void enTematicasIdaElAtacanteEsElCompetidorUno(){
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setTematicaIda();

        assertEquals(competidor1, batalla.getCompetidorQueAtaca());

    }


    @Test
    public void enTematicasVueltaElAtacanteEsElCompetidorDos(){
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setTematicaVuelta();

        assertEquals(competidor2, batalla.getCompetidorQueAtaca());

    }

    @Test
    public void enPersonajesElAtacanteEsElCompetidorUno(){
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();

        assertEquals(competidor1, batalla.getCompetidorQueAtaca());

    }


    @Test
    public void enLibreIdaElAtacanteEsElCompetidorDos(){
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setDeluxe();

        assertEquals(competidor2, batalla.getCompetidorQueAtaca());

    }

    @Test
    public void enLibreVueltaElAtacanteEsElCompetidorUno(){
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setLibreVuelta();

        assertEquals(competidor1, batalla.getCompetidorQueAtaca());

    }

    @Test
    public void enDeluxeElAtacanteEsElCompetidorDos(){
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setDeluxe();

        assertEquals(competidor2, batalla.getCompetidorQueAtaca());

    }

    @Test
    public void alVotarDosPatronesEnDosRoundsDistintosSeVaAcumulandoElPuntajeTotalDelCompetidor(){

        int puntaje1 = 2;
        int puntaje2 = 3;
        int puntaje3 = 1;
        int puntaje4 = 4;
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.puntuarPatronNumero(3,puntaje1,competidor1);
        batalla.puntuarPatronNumero(2, puntaje2, competidor1);

        batalla.avanzarRound();
        batalla.puntuarPatronNumero(2, puntaje3, competidor1);
        batalla.puntuarPatronNumero(1,puntaje4, competidor1);

        assertEquals(batalla.getPuntajeAcumuladoCompetidor(competidor1), puntaje1+puntaje2+puntaje3+puntaje4);


    }


    @Test
    public void alVotarDosPatronesEnDosRoundsDistintosElPuntajeDeCadaRoundIndividualSeMantiene(){

        int puntaje1 = 2;
        int puntaje2 = 3;
        int puntaje3 = 1;
        int puntaje4 = 4;
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.puntuarPatronNumero(3,puntaje1,competidor1);
        batalla.puntuarPatronNumero(2, puntaje2, competidor1);

        batalla.avanzarRound();
        batalla.puntuarPatronNumero(2, puntaje3, competidor1);
        batalla.puntuarPatronNumero(1,puntaje4, competidor1);

        batalla.retrocederRound();
        assertEquals(puntaje1+puntaje2, batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1) );

        batalla.avanzarRound();
        assertEquals( puntaje3+puntaje4, batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1));

    }

    @Test
    public void alVotarElMismoPatronEnElMismoRoundADosCompetidoresDistintosElPuntajeAcumuladoDeRoundDeAmbosCoincide(){

        int nroPatron = 3;
        int puntaje = 2;

        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();
        batalla.puntuarPatronNumero(nroPatron,puntaje, competidor1);
        batalla.puntuarPatronNumero(nroPatron, puntaje, competidor2);

        assertEquals( puntaje, batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2));
        assertEquals( puntaje, batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1));
    }

    @Test
    public void alVotarElMismoPatronEnElMismoRoundADosCompetidoresDistintosElPuntajeAcumuladoTotalDeAmbosCoincide(){

        int nroPatron = 3;
        int puntaje = 2;

        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();
        batalla.puntuarPatronNumero(nroPatron,puntaje, competidor1);
        batalla.puntuarPatronNumero(nroPatron, puntaje, competidor2);

        assertEquals( puntaje, batalla.getPuntajeAcumuladoCompetidor(competidor2));
        assertEquals( puntaje, batalla.getPuntajeAcumuladoCompetidor(competidor1));
    }

    @Test
    public void alVotarElMismoValorEnDiferentePatronEnElMismoRoundADosCompetidoresElPuntajeAcumuladoDeRoundCoincide(){

        int nroPatron = 3;
        int nroPatron2 = 1;
        int puntaje = 2;

        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();
        batalla.puntuarPatronNumero(nroPatron,puntaje, competidor1);
        batalla.puntuarPatronNumero(nroPatron2, puntaje, competidor2);

        assertEquals( puntaje, batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2));
        assertEquals( puntaje, batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1));
    }
    @Test
    public void alVotarElMismoValorEnDiferentePatronEnElMismoRoundADosCompetidoresElPuntajeAcumuladoCoincide(){

        int nroPatron = 3;
        int nroPatron2 = 1;
        int puntaje = 2;

        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();
        batalla.puntuarPatronNumero(nroPatron,puntaje, competidor1);
        batalla.puntuarPatronNumero(nroPatron2, puntaje, competidor2);

        assertEquals( puntaje, batalla.getPuntajeAcumuladoCompetidor(competidor2));
        assertEquals( puntaje, batalla.getPuntajeAcumuladoCompetidor(competidor1));
    }


    @Test
    public void alVotarElMismoValorEnDiferentePatronEnDiferenteRoundADosCompetidoresElPuntajeAcumuladoCoincide(){

        int nroPatron = 3;
        int nroPatron2 = 1;
        int puntaje = 2;

        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();
        batalla.puntuarPatronNumero(nroPatron,puntaje, competidor1);
        batalla.setEasyMode();
        batalla.puntuarPatronNumero(nroPatron2, puntaje, competidor2);

        assertEquals( puntaje, batalla.getPuntajeAcumuladoCompetidor(competidor2));
        assertEquals( puntaje, batalla.getPuntajeAcumuladoCompetidor(competidor1));
    }


    @Test
    public void alVotarElMismoPatronEnElMismoRoundPeroDiferentePuntajeADosCompetidoresElPuntajeAcumuladoDeRoundDeAmbosNoCoincide(){

        int nroPatron = 3;
        int puntaje1 = 2;
        int puntaje2 = 3;

        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();
        batalla.puntuarPatronNumero(nroPatron,puntaje1, competidor1);
        batalla.puntuarPatronNumero(nroPatron, puntaje2, competidor2);

        assertNotEquals(batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1), batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2));
        assertEquals( puntaje2, batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2));
        assertEquals( puntaje1, batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1));
    }



    @Test
    public void alVotarElMismoPatronEnElMismoRoundPeroDiferentePuntajeADosCompetidoresElPuntajeAcumuladoTotalDeAmbosNoCoincide(){

        int nroPatron = 3;
        int puntaje1 = 2;
        int puntaje2 = 3;

        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.setPersonajes();
        batalla.puntuarPatronNumero(nroPatron,puntaje1, competidor1);
        batalla.puntuarPatronNumero(nroPatron, puntaje2, competidor2);

        assertNotEquals(batalla.getPuntajeAcumuladoCompetidor(competidor1), batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2));
        assertEquals( puntaje2, batalla.getPuntajeAcumuladoCompetidor(competidor2));
        assertEquals( puntaje1, batalla.getPuntajeAcumuladoCompetidor(competidor1));
    }

    @Test
    public void votarUnSoloRoundYObtenerElGanadorDevuelveElCompetidorQueSacaVentajaDeCincoEnPuntajeAcumuladoTotal(){

        int puntaje1 = 2;
        int puntaje2 = 3;
        int puntaje3 = 4;
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.puntuarPatronNumero(2, puntaje1, competidor1);

        // puntaje2 + puntaje3 = puntaje1 + 5
        batalla.puntuarPatronNumero(2, puntaje2,competidor2);
        batalla.puntuarPatronNumero(1, puntaje3, competidor2);
        assertEquals(batalla.getGanador(), competidor2);

    }

    @Test
    public void votarUnSoloRoundYObtenerElGanadorDevuelveReplicaSiNadieSacaVentajaDeCincoEnPuntajeAcumuladoTotal(){

        int puntaje1 = 2;
        int puntaje2 = 3;
        batalla.setCompetidor1(competidor1);
        batalla.setCompetidor2(competidor2);

        batalla.puntuarPatronNumero(2, puntaje1, competidor1);

        batalla.puntuarPatronNumero(2, puntaje2,competidor2);

        assertEquals(batalla.getGanador(), batalla.REPLICA);

    }

    @Test
    public void elGanadorPrevaleceAunqueElPerdedorTengaVentajaDeCincoEnUnRoundSiElGanadorTieneVentajaDeCincoEnElTotal(){
        int pje1Comp1 = 4;
        int pje2Comp1 = 4;
        int pje1Comp2 = 2;
        int pje2Comp2 = 4;
        int pje3Comp2 = 3;
        int pje4Comp2 = 4;

        batalla.setCompetidor1(this.competidor1);
        batalla.setCompetidor2(this.competidor2);

        batalla.puntuarPatronNumero(1, pje1Comp1, competidor1);
        batalla.puntuarPatronNumero(2, pje2Comp1, competidor1);

        batalla.puntuarPatronNumero(1, pje1Comp2, competidor2);

        //El competidor dos sigue puntuando hasta obtener ventaja de 5 sobre el primero
        batalla.setTematicaIda();
        batalla.puntuarPatronNumero(1, pje2Comp2, competidor2);
        batalla.puntuarPatronNumero(2, pje3Comp2, competidor2);
        batalla.puntuarPatronNumero(3, pje4Comp2, competidor2);

        assertEquals(competidor2, batalla.getGanador());


    }

    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void puntuarFlowModificaElPuntajeAcumuladoDelCompetidorEnElRoundActual(){
        int pjePatron = 2;
        int pjeFlow = 1;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarFlow(pjeFlow, competidor1);

        assertEquals(pjePatron + pjeFlow, this.batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1));
    }

    @Test
    public void puntuarFlowNoModificaElPuntajeDelOtroCompetidorAcumuladoDelCompetidorEnElRoundActual(){
        int pjePatron = 3;
        int pjeFlow = 1;
        int pjeEsperado = 0;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarFlow(pjeFlow, competidor1);

        assertEquals(pjeEsperado, this.batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2));

    }

    @Test
    public void puntuarFlowModificaElPuntajeAcumuladoTotalDelCompetidor(){
        int pjePatron = 3;
        int pjeFlow = 1;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarFlow(pjeFlow, competidor1);

        assertEquals( pjeFlow + pjePatron , this.batalla.getPuntajeAcumuladoCompetidor(competidor1));


    }

    @Test
    public void puntuarFlowNoModificaElPuntajeAcumuladoTotalDelOtroCompetidor(){
        int pjePatron = 3;
        int pjeFlow = 1;
        int pjeEsperado = 0;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarFlow(pjeFlow, competidor1);

        assertEquals(pjeEsperado, this.batalla.getPuntajeAcumuladoCompetidor(competidor2));

    }

    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void puntuarSkillModificaElPuntajeAcumuladoDelCompetidorEnElRoundActual(){
        int pjePatron = 2;
        int pjeSkill = 1;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarSkill(pjeSkill, competidor1);

        assertEquals(pjePatron + pjeSkill, this.batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1));
    }

    @Test
    public void puntuarSkillNoModificaElPuntajeDelOtroCompetidorAcumuladoDelCompetidorEnElRoundActual(){
        int pjePatron = 3;
        int pjeSkill = 1;
        int pjeEsperado = 0;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarSkill(pjeSkill, competidor1);

        assertEquals(pjeEsperado, this.batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2));

    }

    @Test
    public void puntuarSkillModificaElPuntajeAcumuladoTotalDelCompetidor(){
        int pjePatron = 3;
        int pjeSkill = 1;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarSkill(pjeSkill, competidor1);

        assertEquals( pjeSkill + pjePatron , this.batalla.getPuntajeAcumuladoCompetidor(competidor1));


    }

    @Test
    public void puntuarSkillNoModificaElPuntajeAcumuladoTotalDelOtroCompetidor(){
        int pjePatron = 3;
        int pjeSkill = 1;
        int pjeEsperado = 0;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarSkill(pjeSkill, competidor1);

        assertEquals(pjeEsperado, this.batalla.getPuntajeAcumuladoCompetidor(competidor2));

    }

    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void puntuarPuestaEnEscenaModificaElPuntajeAcumuladoDelCompetidorEnElRoundActual(){
        int pjePatron = 2;
        int pjePtaEscena = 1;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarPuestaEnEscena(pjePtaEscena, competidor1);

        assertEquals(pjePatron + pjePtaEscena, this.batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor1));
    }

    @Test
    public void puntuarPuestaEnEscenaNoModificaElPuntajeDelOtroCompetidorAcumuladoDelCompetidorEnElRoundActual(){
        int pjePatron = 3;
        int pjePtaEscena = 1;
        int pjeEsperado = 0;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarPuestaEnEscena(pjePtaEscena, competidor1);

        assertEquals(pjeEsperado, this.batalla.getPuntajeAcumuladoEnRoundCompetidor(competidor2));

    }

    @Test
    public void puntuarPuestaEnEscenaModificaElPuntajeAcumuladoTotalDelCompetidor(){
        int pjePatron = 3;
        int pjePtaEscena = 1;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarPuestaEnEscena(pjePtaEscena, competidor1);

        assertEquals( pjePtaEscena + pjePatron , this.batalla.getPuntajeAcumuladoCompetidor(competidor1));


    }

    @Test
    public void puntuarPuestaEnEscenaNoModificaElPuntajeAcumuladoTotalDelOtroCompetidor(){
        int pjePatron = 3;
        int pjePtaEscena = 1;
        int pjeEsperado = 0;

        this.batalla.setCompetidor1(competidor1);
        this.batalla.setCompetidor2(competidor2);


        this.batalla.puntuarPatronNumero(2, pjePatron, competidor1);
        this.batalla.puntuarPuestaEnEscena(pjePtaEscena, competidor1);

        assertEquals(pjeEsperado, this.batalla.getPuntajeAcumuladoCompetidor(competidor2));

    }


}

