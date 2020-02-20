package vista.tableroVotacion;

import controlador.VistaParaPuntuacionEventHandlerKey;
import controlador.VistaPuntuacionCompetidorEventHandlerMouse;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class VistaRoundParaPuntuacion extends VBox {

    private Label nombreRound;
    private VistaPuntuacionCompetidor vistaCompetidor1;
    private VistaPuntuacionCompetidor vistaCompetidor2;

    public VistaRoundParaPuntuacion(String nombreRound, String competidor1, String competidor2){
        this.nombreRound = new Label(nombreRound);
        this.vistaCompetidor1 = new VistaPuntuacionCompetidor(competidor1, nombreRound);
        this.vistaCompetidor2 = new VistaPuntuacionCompetidor(competidor2, nombreRound);
        this.inicializar();

    }

    private void inicializar() {
        this.getChildren().addAll(this.nombreRound, this.vistaCompetidor1, this.vistaCompetidor2);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
//        this.setOnKeyReleased(new VistaParaPuntuacionEventHandlerKey());
//        this.setOnMouseClicked(new VistaPuntuacionCompetidorEventHandlerMouse());
    }

    public void inciarParaCantidadDeRounds(int cantRounds){

        this.vistaCompetidor1.inicializarParaCantRounds(cantRounds, 2);
        this.vistaCompetidor2.inicializarParaCantRounds(cantRounds, 2);
    }


    public String getNombreRound() {
        return this.nombreRound.getText();
    }
}
