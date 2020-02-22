package vista.tableroVotacion;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class CasilleroAcumulador extends VBox {

    private Label puntaje;
    private Label titulo;
    private String nombreCompetidor;

    public CasilleroAcumulador(String nombreCompetidor, String titulo){

        this.nombreCompetidor = nombreCompetidor;
        this.titulo = new Label(titulo);
        this.puntaje = new Label("0");

        this.inicializar();
    }

    private void inicializar() {

        this.getChildren().addAll(this.titulo, this.puntaje);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(2);
        this.getStyleClass().add("casillero-acumulador");
    }

    public void setPuntaje(int puntaje) {
        this.puntaje.setText(Integer.toString(puntaje));
    }

}
