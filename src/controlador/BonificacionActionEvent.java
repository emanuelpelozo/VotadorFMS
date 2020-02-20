package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaPuntuacionCompetidor;

public class BonificacionActionEvent implements EventHandler<ActionEvent> {
    private int nroPatron;
    private String nombreCompetidor;
    private String nombreRound;


    public BonificacionActionEvent(String nroPatron, String nombreCompetidor, String nombreRound) {
        this.nroPatron = Integer.parseInt(nroPatron);
        this.nombreCompetidor = nombreCompetidor;
        this.nombreRound = nombreRound;

    }

    @Override
    public void handle(ActionEvent event) {

        FormatoFMS app = FormatoFMS.getInstance();
        app.setRound(nombreRound);

        app.bonificarEntradaRoundActual(nroPatron, nombreCompetidor);

        CheckBox bonificacion = (CheckBox)event.getSource();
        VistaPuntuacionCompetidor vista = (VistaPuntuacionCompetidor) bonificacion.getParent().getParent().getParent();
        vista.setPuntajeRound(app.getPuntajeRoundActualParaCompetidor(vista.getCompetidor()));

    }
}
