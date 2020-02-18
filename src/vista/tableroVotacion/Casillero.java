package vista.tableroVotacion;

import controlador.IntFieldEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import vista.IntField;

import java.awt.event.KeyEvent;


public class Casillero extends VBox {

    private IntField casilla;
    private CheckBox bonificacion;
    private Label nombre;
    private String nombreCompetidor;

    public Casillero(String nombre, String nombreCompetidor){

        this.nombre = new Label(nombre);
        this.nombreCompetidor = nombreCompetidor;
        casilla = new IntField(0,20, 0);
        this.inicializar();
        this.estilizarCasilla();
    }

    private void inicializar() {
        this.getChildren().addAll(this.nombre, this.casilla);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(2);
//
//        this.casilla.setOnAction(new
//                IntFieldEventHandler(this.nombre.getText(), this.nombreCompetidor));

        this.casilla.setOnKeyReleased(new
                IntFieldEventHandler(this.nombre.getText(), this.nombreCompetidor));
    }


    private void estilizarCasilla() {
        this.casilla.setMaxWidth(30);
        this.casilla.setMaxHeight(30);
        this.casilla.setFont(Font.font ("Verdana", 10));

    }

    public void habilitarBonificacion(){
        this.bonificacion = new CheckBox();
        this.getChildren().add(this.bonificacion);
    }


    public void setPuntaje(int pje) {
        System.out.println("Entro");
        System.out.println("Puntaje: " + Integer.toString(pje));
        this.casilla.setValue(pje);
    }
}
