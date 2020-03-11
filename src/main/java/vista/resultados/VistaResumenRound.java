package vista.resultados;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class VistaResumenRound extends VBox {

    private Label nombreRound;
    private Label pje1;
    private Label pje2;

    public VistaResumenRound(String nombreRound){
        this.nombreRound = new Label(nombreRound);
        this.pje1 = new Label("0");
        this.pje2 = new Label("0");
//        this.nombreGanador = new Label();
        this.inicializar();
    }

    private void inicializar() {

        this.getChildren().addAll(nombreRound, pje1, pje2);
        this.setAlignment(Pos.CENTER);
    }

    public void setPuntaje1(int pje1){
        this.pje1.setText(Integer.toString(pje1));
    }

    public void setPuntaje2(int pje2){
        this.pje2.setText(Integer.toString(pje2));
    }

//    public void setGanador(String nombreGanador){
//        this.nombreGanador.setText(nombreGanador);
//    }

}
