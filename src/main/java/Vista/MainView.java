package Vista;


import Controladores.EntradaUsuario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Controladores.Botones.ControladorEntrar;

import java.util.ArrayList;
import java.util.HashMap;

public class MainView extends VBox {

    ArrayList<EntradaUsuario> jugadores = new ArrayList<>();
    ControladorEntrar ce;

    public MainView() {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        EntradaUsuario entrada1 = new EntradaUsuario("Primer Jugador", Color.PALEGREEN);
        EntradaUsuario entrada2 = new EntradaUsuario("Segundo Jugador", Color.PALEVIOLETRED);
        jugadores.add(entrada1);
        jugadores.add(entrada2);

        VBox vb = new VBox(entrada1.getHb(), entrada2.getHb());
        vb.setSpacing(30);

        Label titulo = new Label("AlgoPoly");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setTextFill(Color.web("000000"));
        Label subtitulo = new Label("The World's Greatest Java Monopoly");
        subtitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        subtitulo.setTextAlignment(TextAlignment.CENTER);
        subtitulo.setTextFill(Color.web("000000"));
    }

    public void setBotonJugar(Stage stage, Scene proximaEscena){
        ce = new ControladorEntrar(stage,proximaEscena, jugadores);
        Boton botonEntrar = new Boton("JUGAR", ce);
        this.getChildren().add(3, botonEntrar);
    }
}
