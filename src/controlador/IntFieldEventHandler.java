package controlador;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modelo.FormatoFMS;
import vista.IntField;
import vista.tableroVotacion.VistaPuntuacionCompetidor;


public class IntFieldEventHandler implements EventHandler<KeyEvent> {

    private String nombreCasilla;
    private String nombreCompetidor;

    public IntFieldEventHandler(String nombreCasilla, String nombreCompetidor){
        this.nombreCasilla = nombreCasilla;
        this.nombreCompetidor = nombreCompetidor;
    }

//    @Override
//    public void handle(ActionEvent event) {
//        IntField casilla = (IntField) event.getSource();
//        FormatoFMS app = FormatoFMS.getInstance();
//
//        int nro = casilla.getValue();
//        if(nombreCasilla.matches("123456789")){
//            app.puntuarPatronParaCompetidor(Integer.parseInt(nombreCasilla),
//                    nro, this.nombreCompetidor);
//        }
//
//        else if(nombreCasilla == "Flow")
//            app.puntuarFlowParaCompetidor(nro, nombreCompetidor);
//
//        else if(nombreCasilla == "Skill")
//            app.puntuarSkillParaCompetidor(nro, nombreCompetidor);
//
//        else if(nombreCasilla == "P.esc")
//            app.puntuarPuestaEnEscenaParaCompetidor(nro, nombreCompetidor);
//
//        VistaPuntuacionCompetidor vista = (VistaPuntuacionCompetidor) casilla.getParent().getParent().getParent();
//        int pje = app.getPuntajeRoundActualParaCompetidor(nombreCompetidor);
//        vista.actualizarPuntajeParcial(pje);
//    }

    @Override
    public void handle(KeyEvent keyEvent) {
        IntField casilla = (IntField) keyEvent.getSource();
        FormatoFMS app = FormatoFMS.getInstance();

        int nro = casilla.getValue();
        if(nombreCasilla.matches("\\d+")){
            System.out.println("ENTRAMO PAPUUUUUUU");
            app.puntuarPatronParaCompetidor(Integer.parseInt(nombreCasilla),
                    nro, this.nombreCompetidor);
        }

        else if(nombreCasilla == "Flow")
            app.puntuarFlowParaCompetidor(nro, nombreCompetidor);

        else if(nombreCasilla == "Skill")
            app.puntuarSkillParaCompetidor(nro, nombreCompetidor);

        else if(nombreCasilla == "P.esc")
            app.puntuarPuestaEnEscenaParaCompetidor(nro, nombreCompetidor);

    }
}
