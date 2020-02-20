package controlador;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaRoundParaPuntuacion;

public class VistaParaPuntuacionEventHandlerKey implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        FormatoFMS app = FormatoFMS.getInstance();
        VistaRoundParaPuntuacion vista = (VistaRoundParaPuntuacion) keyEvent.getSource();

        app.setRound(vista.getNombreRound());

    }
}
