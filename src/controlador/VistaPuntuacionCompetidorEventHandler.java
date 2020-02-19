package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modelo.FormatoFMS;
import vista.tableroVotacion.CasilleroAcumulador;
import vista.tableroVotacion.VistaPuntuacionCompetidor;

public class VistaPuntuacionCompetidorEventHandler implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        FormatoFMS app = FormatoFMS.getInstance();
        VistaPuntuacionCompetidor vistaPuntuacionCompetidor = (VistaPuntuacionCompetidor) keyEvent.getSource();
        String competidor = vistaPuntuacionCompetidor.getCompetidor();
        vistaPuntuacionCompetidor.setPuntaje(app.getPuntajeRoundActualParaCompetidor(competidor));
    }
}
