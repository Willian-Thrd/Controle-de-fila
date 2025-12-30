package org.will;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class MainController {
    @FXML
    private ToggleButton delivery;
    @FXML
    private AnchorPane deliveryPane;

    @FXML
    private void initialize() {
        delivery.selectedProperty().addListener((obs, oldVal, isOn) -> {
            if (isOn) {
                delivery.setStyle("-fx-background-color: rgb(156, 156, 156); -fx-text-fill: green;");
                deliveryPane.setStyle("-fx-background-color: black; -fx-border-width: 2px; -fx-border-color: white;");
            } else {
                delivery.setStyle("-fx-background-color: rgb(23, 23, 23); -fx-text-fill: green;");
                deliveryPane.setStyle("-fx-background-color: black; -fx-border-width: 2px; -fx-border-color: white;");
            }
        });
    }
}
