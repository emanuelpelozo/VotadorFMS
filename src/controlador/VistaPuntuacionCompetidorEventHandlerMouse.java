package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaPuntuacionCompetidor;
import vista.tableroVotacion.VistaRoundParaPuntuacion;


public class VistaPuntuacionCompetidorEventHandlerMouse implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent mouseEvent) {

        FormatoFMS app = FormatoFMS.getInstance();
//        VistaRoundParaPuntuacion vistaPuntuacionCompetidor = (VistaRoundParaPuntuacion) mouseEvent.getSource();
//        VistaRoundParaPuntuacion vistaRound = (VistaRoundParaPuntuacion) vistaPuntuacionCompetidor.getParent();
//        app.setRound(vistaRound.getNombreRound());

//        String competidor = vistaPuntuacionCompetidor.getCompetidor();
//        vistaPuntuacionCompetidor.setPuntajeRound(app.getPuntajeRoundActualParaCompetidor(competidor));
    }
}
