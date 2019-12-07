package Vista.mainGame;

import Controladores.CellController;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CellView extends Pane {
    private static final String ASSET_DIR = "File:src/main/resources/assets/";

    private Integer xPosition;
    private Integer yPosition;
    ImageView imageView;

    public CellView(Integer x, Integer y) {
        xPosition = x;
        yPosition = y;
        this.setOnMouseClicked(new CellController(xPosition, yPosition, this));
    }

    public void updateImage(String resource) {
        this.getChildren().removeAll();
        Image image = new Image(ASSET_DIR + resource);
        imageView = new ImageView(image);
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());
        this.getChildren().addAll(imageView);
    }

    public void highlightUnit() {
        imageView.setEffect(new Glow(0.8));
    }

    public void unHighlightUnit() { imageView.setEffect(null); }

    public void clearImage() {
        this.getChildren().clear();
    }

}
