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
        this.vistaCompetidor1 = new VistaPuntuacionCompetidor(competidor1, nombreRound);
        this.vistaCompetidor2 = new VistaPuntuacionCompetidor(competidor2, nombreRound);
        this.inicializar();

    }

    private void inicializar() {

        this.getChildren().addAll(this.nombreRound, this.vistaCompetidor1, this.vistaCompetidor2);

        this.nombreRound.setAlignment(Pos.CENTER);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        this.getStyleClass().add("vista-round");
  }

    public void inciarParaCantidadDeRounds(int cantRounds){

        this.vistaCompetidor1.inicializarParaCantRounds(cantRounds, 1);
        this.vistaCompetidor2.inicializarParaCantRounds(cantRounds, 2);
        this.vistaCompetidor1.alinearTamañoNombreCompetidor(this.vistaCompetidor2.getCompetidor());
        this.vistaCompetidor2.alinearTamañoNombreCompetidor(this.vistaCompetidor1.getCompetidor());

    }


    public String getNombreRound() {
        return this.nombreRound.getText();
    }

    public void ocultarPuntajeParcial() {
        this.vistaCompetidor1.ocultarPuntajeParcial();
        this.vistaCompetidor2.ocultarPuntajeParcial();
    }

    public void mostrarPuntajeParcial() {
        this.vistaCompetidor1.mostrarPuntajeParcial();
        this.vistaCompetidor2.mostrarPuntajeParcial();
    }
}
