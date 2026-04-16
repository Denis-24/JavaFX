package org.example.pruebafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {

    static Contador cont = new Contador();

    @FXML
    private Label welcomeText;

    @FXML
    private Button pruebaPulsarButton;

    @FXML
    private Label contadorLabel;


    @FXML
    public void initialize(){
        pruebaPulsarButton.setOnAction(e -> {
            cont.contar();
            contadorLabel.setText(Integer.toString(cont.getContar()));
        });
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void siguienteClickButton() throws IOException {
        HelloApplication.setRoot("SegundaControler");
    }

    public void resetButton(){
        cont.resetear();
        contadorLabel.setText("0");
    }

}
