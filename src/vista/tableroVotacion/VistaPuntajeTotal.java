package vista.tableroVotacion;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class VistaPuntajeTotal extends HBox {

    private Label puntajeTotal1;
    private Label puntajeTotal2;
    private String competidor1;
    private String competidor2;

    public VistaPuntajeTotal(String competidor1, String competidor2){


        this.competidor1 = competidor1;
        this.competidor2 = competidor2;
        this.iniciarLabels();
    }

    private void iniciarLabels() {
        this.puntajeTotal1 = new Label();
        this.puntajeTotal2 = new Label();
        this.puntajeTotal1.setText(this.competidor1 + ": 0");
        this.puntajeTotal2.setText(this.competidor2 + ": 0");

        this.getChildren().addAll(this.puntajeTotal1, this.puntajeTotal2);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
    }

    public void actualizarPuntajes(int pje1, int pje2){
        this.puntajeTotal1.setText(this.competidor1 + ": " + Integer.toString(pje1));

        this.puntajeTotal2.setText(this.competidor2 + ": " + Integer.toString(pje2));
    }

    public void ocultarPuntajes(){
        this.setVisible(false);
    }

    public void mostrarPuntajes(){
        this.setVisible(true);
    }




}
