package Controladores;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class NameInputEventHandler implements EventHandler<KeyEvent> {

    private Button sendButton;

    public NameInputEventHandler(Button sendButton) {
        this.sendButton = sendButton;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(sendButton, new ActionEvent());
        }
    }
}

