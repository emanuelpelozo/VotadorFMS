package modelo.Batalla;

public class FabricaRounds {

    static final int ENTRADAS_EMODE = 6;
    static final int ENTRADAS_HMODE = 6;
    static final int ENTRADAS_PJES = 4;
    static final int ENTRADAS_TEMATICA = 4;
    static final int ENTRADAS_LIBRE = 6;
    static final int ENTRADAS_DELUXE = 11;

    public Round crearEasyMode(){
        return new Round(ENTRADAS_EMODE);
    }

    public Round crearHardMode(){
        return new Round(ENTRADAS_HMODE);
    }

    public Round crearTematica(){
        return new Round(ENTRADAS_TEMATICA);
    }

    public RoundBonificable crearPersonajes(){
        return new RoundBonificable(ENTRADAS_PJES);
    }

    public Round crearLibreIda(){
        return new Round(ENTRADAS_LIBRE);
    }

    public RoundBonificable crearLibreVuelta(){
        return new RoundBonificable(ENTRADAS_LIBRE);
    }

    public Round crearDeluxe(){
        return new Round(ENTRADAS_DELUXE);
    }

}
