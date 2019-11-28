package Vista.mainGame;

import Controladores.CellController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CellView extends Pane {
    private static final String ASSET_DIR = "File:src/main/resources/assets/";

    private int positionX;
    private int positionY;
    private CellController controller;

    public CellView(int x, int y    ) {
        positionX = x;
        positionY = y;
        controller = new CellController(x, y);
        this.setOnMouseClicked(e -> {
            controller.handleClick();
            updateImage();
        });
    }

    private void updateImage() {
        this.getChildren().removeAll();
        String resource = controller.getResource();
        Image image = new Image(ASSET_DIR + resource);
        ImageView imageView = new ImageView(image);
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());
        this.getChildren().addAll(imageView);
    }

}
