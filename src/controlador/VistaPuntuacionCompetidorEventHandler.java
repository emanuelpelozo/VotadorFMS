package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaPuntuacionCompetidor;
import vista.tableroVotacion.VistaRoundParaPuntuacion;

public class VistaPuntuacionCompetidorEventHandler implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        FormatoFMS app = FormatoFMS.getInstance();
        VistaPuntuacionCompetidor vistaPuntuacionCompetidor = (VistaPuntuacionCompetidor) keyEvent.getSource();
        VistaRoundParaPuntuacion vistaRound = (VistaRoundParaPuntuacion) vistaPuntuacionCompetidor.getParent();

        app.setRound(vistaRound.getNombreRound());

        String competidor = vistaPuntuacionCompetidor.getCompetidor();
        vistaPuntuacionCompetidor.setPuntajeRound(app.getPuntajeRoundActualParaCompetidor(competidor));
    }
}
