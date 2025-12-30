package org.will;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class MainController extends trueFalse{

    @FXML
    private ToggleButton delivery;
    @FXML
    private AnchorPane deliveryPane;
    @FXML
    private ComboBox<String> box, tipoRetirada;
    @FXML
    private Label labelRetirada;
    @FXML
    private TextField EnderecoCliente, TelCliente;

    ComboBox cb;
    TextField tf;

    @FXML
    private void initialize() {
        box.getItems().addAll("Débito", "Crédito", "Pix");
        tipoRetirada.getItems().addAll("Retirada", "Balcão");

        delivery.selectedProperty().addListener((obs, oldVal, isOn) -> {

            deliveryPane.lookupAll(".delivery").forEach(node -> {
            if (node instanceof TextField) {
                tf = (TextField) node;
                tf.setEditable(false);
            }

            if (node instanceof ComboBox) {
                cb = (ComboBox) node;
                cb.setMouseTransparent(true);
                cb.setFocusTraversable(false);
            }
        });

            if (isOn) {
                delivery.setStyle("-fx-background-color: black; -fx-text-fill: lime;");
                deliveryPane.setStyle("-fx-background-color: black; -fx-border-width: 2px; -fx-border-color: white;");
                trueFalse(true, false);

            } else {
                delivery.setStyle("-fx-background-color: black; -fx-text-fill: red;");
                deliveryPane.setStyle("-fx-background-color: black; -fx-border-width: 2px; -fx-border-color: white;");
                trueFalse(false, true);
            }
        });
    }
}
