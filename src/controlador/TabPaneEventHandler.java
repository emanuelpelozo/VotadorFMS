package controlador;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
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

        int pje1 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidor1());
        int pje2 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidor2());
        vistaTotal.actualizarPuntajes(pje1,pje2);
    }


//    @Override
//    public void handle(KeyEvent keyEvent) {
//        VistaTabPaneRounds tabPane = (VistaTabPaneRounds) keyEvent.getSource();
//        BorderPane border = (BorderPane) tabPane.getParent();
//        FormatoFMS app = FormatoFMS.getInstance();
//
//        int pje1 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidorQueAtaca());
//        int pje2 = app.getPuntajeAcumuladoParaCompetidor(app.getCompetidorQueResponde());
//        VistaPuntajeTotal2 vista1 = (VistaPuntajeTotal2) border.getLeft();
//        VistaPuntajeTotal2 vista2 = (VistaPuntajeTotal2) border.getRight();
//        vista1.actualizarPuntaje(pje1);
//        vista2.actualizarPuntaje(pje2);
//    }

}
