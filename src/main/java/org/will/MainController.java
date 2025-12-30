package org.will;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class MainController {
    @FXML
    private ToggleButton delivery;
    @FXML
    private AnchorPane deliveryPane;
    @FXML
    private ComboBox<String> box;


    @FXML
    private void initialize() {
        box.getItems().addAll("Débito", "Crédito", "Pix");

        delivery.selectedProperty().addListener((obs, oldVal, isOn) -> {
            if (isOn) {
                delivery.setStyle("-fx-background-color: black; -fx-text-fill: lime;");
                deliveryPane.setStyle("-fx-background-color: black; -fx-border-width: 2px; -fx-border-color: white;");
            } else {
                delivery.setStyle("-fx-background-color: black; -fx-text-fill: red;");
                deliveryPane.setStyle("-fx-background-color: black; -fx-border-width: 2px; -fx-border-color: white;");
            }
        });
    }
}
