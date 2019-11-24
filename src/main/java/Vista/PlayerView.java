package Vista;

import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerView extends HBox {

    private final String name;

    public PlayerView(String name) {
        super();
        this.name = name;

        Text nameText = new Text();
        nameText.setText(this.name);
        nameText.setFont(new Font(20));

        this.setMaxWidth(500);
        this.setMaxHeight(100);
    }


}
