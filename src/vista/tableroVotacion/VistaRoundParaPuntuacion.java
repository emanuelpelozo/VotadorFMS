package vista.tableroVotacion;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class VistaRoundParaPuntuacion extends VBox {

    private Label nombreRound;
    private VistaPuntuacionCompetidor vistaCompetidor1;
    private VistaPuntuacionCompetidor vistaCompetidor2;

    public VistaRoundParaPuntuacion(String nombreRound, String competidor1, String competidor2){
        this.nombreRound = new Label(nombreRound);
        this.vistaCompetidor1 = new VistaPuntuacionCompetidor(competidor1);
        this.vistaCompetidor2 = new VistaPuntuacionCompetidor(competidor2);
        this.inicializar();

    }

    private void inicializar() {
        this.getChildren().addAll(this.nombreRound, this.vistaCompetidor1, this.vistaCompetidor2);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }

    public void inciarParaCantidadDeRounds(int cantRounds){
        this.vistaCompetidor1.inicializarParaCantRounds(cantRounds);
        this.vistaCompetidor2.inicializarParaCantRounds(cantRounds);
    }


}
