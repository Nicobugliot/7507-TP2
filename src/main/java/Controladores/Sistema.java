package Controladores;


import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Sistema {

    static VBox consola = null;
    static ArrayList<MediaPlayer> sonidos = new ArrayList<MediaPlayer>();
    static ScrollPane sp;

    public Sistema() {
        Text text = new Text(">>> Consola");
        text.setFont(Font.font("Verdana", 12));
        text.setFill(Color.GREEN);
        VBox contenedorConsola = new VBox(text);
        contenedorConsola.setStyle("-fx-background-color: black;");
        contenedorConsola.setPrefWidth(280);
        consola = contenedorConsola;
        sp = new ScrollPane(contenedorConsola);
        sp.setStyle("-fx-background: black;");
        sp.vvalueProperty().bind(consola.heightProperty());
    }

    public static ScrollPane contenedorConsola() {
        return sp;
    }

}
