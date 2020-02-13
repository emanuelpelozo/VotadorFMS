package modelo.Batalla.Rounds;

import java.util.ArrayList;

public class Round {

    protected ColeccionDePuntajes puntajes;
    private ColeccionDePuntajes ptjesExtras;
    private String nombre;
    private Round siguiente;
    private Round anterior;
    private int nroOrden;

    public Round(String nombre, int cantEntradas){

        this.puntajes = new ColeccionDePuntajes(cantEntradas);
        this.ptjesExtras = new ColeccionDePuntajes(3); //Puesta en escena, flow y tecnicas
        this.nombre = nombre;
        this.siguiente = null;
        this.anterior = null;
    }

    public int getPuntajePatron(int nroPatron){
        return puntajes.getPuntajeDeEntrada(nroPatron);
    }

    public void votarPatron(int nroPatron, int puntaje) {
        puntajes.votarEntrada(nroPatron,puntaje);
    }

    public int getPuntajeAcumulado(){
        return puntajes.getPuntajeAcumulado() + this.ptjesExtras.getPuntajeAcumulado();
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setSiguiente(Round roundSig){
        this.siguiente = roundSig;

    }

    public Round getSiguiente() throws ExcepcionRoundSinSiguiente {

        if(this.siguiente == null){
            throw new ExcepcionRoundSinSiguiente("El round seleccionado no tiene siguiente");
        }
        return this.siguiente;
    }

    public void setAnterior(Round roundAnt){
        this.anterior = roundAnt;
    }

    public Round getAnterior() throws ExcepcionRoundSinAnterior {
        if(this.anterior == null){
            throw new ExcepcionRoundSinAnterior("El round seleccionado no tiene anterior");
        }
        return this.anterior;
    }

    public void setOrden(int nroOrden){
        this.nroOrden = nroOrden;
    }

    public int getOrden() {
        return this.nroOrden;
    }

    public void puntuarFlow(int pjeFlow) {
        this.ptjesExtras.votarEntrada(1, pjeFlow);
    }

    public void puntuarPuestaEnEscena(int pjePuestaEscena){
        this.ptjesExtras.votarEntrada(2, pjePuestaEscena);
    }

    public void puntuarSkill(int pjeSkill) {

        this.ptjesExtras.votarEntrada(3, pjeSkill);
    }


}
