package modelo.Batalla;

public class FabricaRounds {

    public static final int ENTRADAS_EMODE = 6;
    public static final int ENTRADAS_HMODE = 6;
    public static final int ENTRADAS_PJES = 4;
    public static final int ENTRADAS_TEMATICA = 4;
    public static final int ENTRADAS_LIBRE = 6;
    public static final int ENTRADAS_DELUXE = 11;

    public static final String NOMBRE_EM = "Easy Mode";
    public static final String NOMBRE_HM = "Hard Mode";
    public static final String NOMBRE_PJES = "Personajes";
    public static final String NOMBRE_TEM = "Tematica";
    public static final String NOMBRE_LIB_IDA = "Libre Ida";
    public static final String NOMBRE_LIB_VTA = "Libre Vuelta";
    public static final String NOMBRE_DLXE = "Deluxe";

    public Round crearEasyMode(){
        return new Round(NOMBRE_EM, ENTRADAS_EMODE);
    }

    public Round crearHardMode(){
        return new Round(NOMBRE_HM, ENTRADAS_HMODE);
    }

    public Round crearTematica(){
        return new Round(NOMBRE_TEM, ENTRADAS_TEMATICA);
    }

    public RoundBonificable crearPersonajes(){

        return new RoundBonificable(NOMBRE_PJES, ENTRADAS_PJES);
    }

    public Round crearLibreIda(){
        return new Round(NOMBRE_LIB_IDA, ENTRADAS_LIBRE);
    }

    public RoundBonificable crearLibreVuelta(){

        return new RoundBonificable(NOMBRE_LIB_VTA, ENTRADAS_LIBRE);
    }

    public Round crearDeluxe(){
        return new Round(NOMBRE_DLXE, ENTRADAS_DELUXE);
    }

}
