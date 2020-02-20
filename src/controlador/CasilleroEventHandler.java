package controlador;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modelo.FormatoFMS;
import vista.IntField;


public class CasilleroEventHandler implements EventHandler<KeyEvent> {

    private final String nombreRound;
    private String nombreCasilla;
    private String nombreCompetidor;

    public CasilleroEventHandler(String nombreCasilla, String nombreCompetidor, String nombreRound){
        this.nombreCasilla = nombreCasilla;
        this.nombreCompetidor = nombreCompetidor;
        this.nombreRound = nombreRound;
    }



    @Override
    public void handle(KeyEvent keyEvent) {
        IntField casilla = (IntField) keyEvent.getSource();
        FormatoFMS app = FormatoFMS.getInstance();
        app.setRound(nombreRound);

        int nro = casilla.getValue();
        if(nombreCasilla.matches("\\d+")){
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
