package org.will;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class MainController extends trueFalse{
    @FXML
    private ToggleButton toggle;
    @FXML
    private AnchorPane deliveryPane;
    @FXML
    private ComboBox<String> box, tipoRetirada;
    @FXML
    private Label labelRetirada, EnderecoLabel, MetodoLabel, TelLabel;
    @FXML
    private TextField EnderecoCliente, TelCliente;

    @FXML
    private void initialize() {
        trueFalse(false, true);
        applicationOpacity(0.5, 1.0);
 
        box.getItems().addAll("Débito", "Crédito", "Pix");
        tipoRetirada.getItems().addAll("Retirada", "Balcão");

        toggle.selectedProperty().addListener((obs, oldVal, isOn) -> {

            if (oldVal) {
                toggle.setStyle("-fx-background-color: black; -fx-text-fill: red;");
                trueFalse(false, true);
                applicationOpacity(0.5, 1.0);
            } else {
                toggle.setStyle("-fx-background-color: black; -fx-text-fill: lime;");
                trueFalse(true, false);
                applicationOpacity(1.0, 0.5);
            }
        });
    }

    private void applicationOpacity(double opacity, double oapcity2) {
    
        TextField[] deliverFields = {EnderecoCliente, TelCliente};
        Label[] deliveryLabels = {EnderecoLabel, MetodoLabel, TelLabel, labelRetirada};

        for (TextField tf : deliverFields) {
            tf.setOpacity(opacity);
        }

        for (Label lbl : deliveryLabels) {
            lbl.setOpacity(opacity);
        }

        box.setOpacity(opacity);

        tipoRetirada.setOpacity(oapcity2);
        labelRetirada.setOpacity(oapcity2);
    }
}
