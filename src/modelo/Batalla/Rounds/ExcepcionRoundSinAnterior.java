package modelo.Batalla.Rounds;

public class ExcepcionRoundSinAnterior extends RuntimeException {

    public ExcepcionRoundSinAnterior(String msg){
        super(msg);
    }
}
