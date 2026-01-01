package org.will;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class MainController extends trueFalse{
    @FXML
    private ToggleButton toggle;
    @FXML
    private AnchorPane deliveryPane;
    @FXML
    private TextArea note;
    @FXML
    private ComboBox<String> box, tipoRetirada;
    @FXML
    private Label labelRetirada, EnderecoLabel, TelLabel;
    @FXML
    private TextField EnderecoCliente, TelCliente, nomeInput;
    @FXML
    private TableView<listaInputs> lista;
    @FXML
    private TableColumn<listaInputs, String> nome, tel, endereco, id, hr, retirada, nota, formaPagamento;

    ObservableList<listaInputs> list = FXCollections.observableArrayList();
    LocalTime now = LocalTime.now();
    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("HH:mm");
    int tipos = 0;

    @FXML
    private void initialize() {
        lista.setItems(list);
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        hr.setCellValueFactory(new PropertyValueFactory<>("hr"));
        retirada.setCellValueFactory(new PropertyValueFactory<>("retirada"));
        nota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        formaPagamento.setCellValueFactory(new PropertyValueFactory<>("metodo"));

        trueFalse(false, true);
        applicationOpacity(0.5, 1.0);
 
        box.getItems().addAll("Débito", "Crédito", "Pix");
        tipoRetirada.getItems().addAll("Retirada", "Balcão");

        toggle.selectedProperty().addListener((obs, oldVal, isOn) -> {

            if (oldVal) {
                toggle.setStyle("-fx-background-color: black; -fx-text-fill: red;");
                trueFalse(false, true);
                applicationOpacity(0.5, 1.0);
                tipos = 0;
            } else {
                toggle.setStyle("-fx-background-color: black; -fx-text-fill: lime;");
                trueFalse(true, false);
                applicationOpacity(1.0, 0.5);
                tipos = 1;
            }
        });
    }

    private void applicationOpacity(double opacity, double oapcity2) {
    
        TextField[] deliverFields = {EnderecoCliente, TelCliente};
        Label[] deliveryLabels = {EnderecoLabel, TelLabel, labelRetirada};

        for (TextField tf : deliverFields) {
            tf.setOpacity(opacity);
        }

        for (Label lbl : deliveryLabels) {
            lbl.setOpacity(opacity);
        }

        tipoRetirada.setOpacity(oapcity2);
        labelRetirada.setOpacity(oapcity2);
    }

    @FXML
    private void finalizarPedido(ActionEvent event) {
        String nomeString = nomeInput.getText();
        String telString = TelCliente.getText();
        String EnderecoString = EnderecoCliente.getText();
        String metodoString = box.getValue();
        String retiradaString = tipoRetirada.getValue();
        String notaString = note.getText();
        String time = now.format(fomatter);

        switch (tipos) {
            case 0:
                if (!nomeString.isBlank() && retiradaString != null && metodoString != null) {
                    list.add(new listaInputs(nomeString, "NaN", "NaN", metodoString, "NaN", time, retiradaString, notaString));
                    nomeInput.clear();
                    TelCliente.clear();
                    EnderecoCliente.clear();
                    box.getSelectionModel().clearSelection();
                    tipoRetirada.getSelectionModel().clearSelection();
                    note.clear();
                } else {
                    ERROR("Por favor, preencha todos os campos.");
                }
            break;

            case 1:
                if (!nomeString.isBlank() && !telString.isBlank() && !EnderecoString.isBlank() && metodoString != null) {
                    list.add(new listaInputs(nomeString, telString, EnderecoString, metodoString, "NaN", time, "NaN", notaString));
                    nomeInput.clear();
                    TelCliente.clear();
                    EnderecoCliente.clear();
                    box.getSelectionModel().clearSelection();
                    tipoRetirada.getSelectionModel().clearSelection();
                    note.clear();
                } else {
                    ERROR("Por favor, preencha todos os campos.");
                }
            break;
        }
    }

    public void ERROR(String erro) {
        Alert error = new Alert(AlertType.ERROR);
        error.setTitle("ERROR");
        error.setHeaderText("Dados inválidos");
        error.setContentText(erro);
        error.showAndWait();
    }

    @FXML
    private void cancel(ActionEvent e) {
        listaInputs index = lista.getSelectionModel().getSelectedItem();

        if (index != null) {
            lista.getItems().remove(index);
        }
    }
}
