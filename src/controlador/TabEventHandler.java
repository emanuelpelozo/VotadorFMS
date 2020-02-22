package controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import modelo.FormatoFMS;
import vista.tableroVotacion.VistaPuntajeTotal;
import vista.tableroVotacion.VistaTabPaneRounds;

public class TabEventHandler implements EventHandler<Event> {
    @Override
    public void handle(Event event) {

        Tab tab = (Tab) event.getSource();
//        VistaTabPaneRounds tabPane = tab.getSource();
        VBox vistaTab = (VBox) tab.getContent();
        VistaPuntajeTotal vistaTotal = (VistaPuntajeTotal) vistaTab.getChildren().get(1);
        FormatoFMS app = FormatoFMS.getInstance();

        int pje1 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidor1());
        int pje2 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidor2());

        vistaTotal.actualizarPuntajes(pje1,pje2);

    }
}
