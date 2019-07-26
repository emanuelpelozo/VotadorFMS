package modelo.Rounds;

import javax.print.DocFlavor;

public class ConstructorRound{
    private int ENTRADAS_PALABRAS = 6;
    private int ENTRADAS_TEMATICA = 4;
    private int ENTRADAS_PERSONAJES = 6;
    private int ENTRADAS_LIBRE = 6;
    private int ENTRADAS_ACAPELA = 11;
    private String participante1;
    private String participante2;

    public ConstructorRound(String participante1, String participante2) {
        this.participante1 = participante1;
        this.participante2 = participante2;
    }

    public getRoundEasyMode(){
        Round round = new Round(ENTRADAS_PALABRAS, this.participante1,this.participante2) {
        return round;
        }
    }

    public getRoundHardMode(){
        Round round = new Round(ENTRADAS_PALABRAS,this.participante1,this.participante2);
        return round;
    }

    public getRoundTematica(){
        Round round = new Round(ENTRADAS_TEMATICA,this.participante1,this.participante2);
        return round;
    }

    public getRoundPersonajes(){
        Round round = new RoundBonificable(ENTRADAS_PERSONAJES,this.participante1,this.participante2);
        return round;
    }

    public getRoundLibre(){
        Round round = new RoundBonificable(ENTRADAS_LIBRE,this.participante1,this.participante2);
        return round;
    }

    public getRoundACapella(){
        Round round = new Round(ENTRADAS_ACAPELA,this.participante1,this.participante2);
        return round;
    }


}
