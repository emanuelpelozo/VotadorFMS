package vista.tableroVotacion;

import controlador.CasilleroEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import vista.IntField;


public class Casillero extends VBox {

    private IntField casilla;
    private CheckBox bonificacion;
    private Label nombre;

    public Casillero(String nombre) {

        this.nombre = new Label(nombre);
        casilla = new IntField(0, 9, 0);
        this.inicializar();
        this.estilizarCasilla();

    }

    private void inicializar() {
        this.getChildren().addAll(this.nombre, this.casilla);
        this.setAlignment(Pos.CENTER);
//        this.setSpacing(2);
        this.casilla.getStyleClass().add("casilla-puntaje");
        this.casilla.setAlignment(Pos.CENTER);
        this.nombre.setFont(Font.font("Verdana", 10));
        this.getStyleClass().add("casillero");
//        this.casilla
    }


    private void estilizarCasilla() {
        this.casilla.setMaxWidth(20);
        this.casilla.setMaxHeight(20);
//        this.casilla.setFont(Font.font("Verdana", 10));

    }

    public void habilitarBonificacion() {
        this.bonificacion = new CheckBox();
//        this.bonificacion.getStyleClass()
//        this.bonificacion.setMaxSize(5,5);
        this.getChildren().add(this.bonificacion);
    }

    public int getValue() {
        return this.casilla.getValue();
    }

    public void setOnActionParaBonificacion(EventHandler<ActionEvent> event){
        if(this.bonificacion != null){
            this.bonificacion.setOnAction( event);
        }
    }

    public void setOnKeyReleasedParaCasilla(EventHandler eventHandler) {
        this.casilla.setOnKeyReleased(eventHandler);
        this.casilla.setOnKeyTyped(eventHandler);

    }
}