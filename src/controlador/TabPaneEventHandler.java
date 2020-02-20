package controlador;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaPuntajeTotal;
import vista.tableroVotacion.VistaTabPaneRounds;

public class TabPaneEventHandler implements EventHandler<KeyEvent> {


    @Override
    public void handle(KeyEvent keyEvent) {
        VistaTabPaneRounds tabPane = (VistaTabPaneRounds) keyEvent.getSource();
        VBox vistaTab = (VBox) tabPane.getSelectionModel().getSelectedItem().getContent();
        VistaPuntajeTotal vistaTotal = (VistaPuntajeTotal) vistaTab.getChildren().get(1);
        FormatoFMS app = FormatoFMS.getInstance();

        int pje1 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidorQueAtaca());
        int pje2 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidorQueResponde());
        vistaTotal.actualizarPuntajes(pje1,pje2);
    }
}
