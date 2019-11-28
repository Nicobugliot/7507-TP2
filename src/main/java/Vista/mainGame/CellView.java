package Vista.mainGame;

import Controladores.CellController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CellView extends Pane {
    private static final String ASSET_DIR = "File:src/main/resources/assets/";

    private int xPosition;
    private int yPosition;
    private CellController controller;

    public CellView(int x, int y) {
        xPosition = x;
        yPosition = y;
        controller = new CellController(x, y, this);
        this.setOnMouseClicked(e -> {
            controller.handleClick();
        });
    }

    public void updateImage(String resource) {
        this.getChildren().removeAll();
        Image image = new Image(ASSET_DIR + resource);
        ImageView imageView = new ImageView(image);
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());
        this.getChildren().addAll(imageView);
    }

}
