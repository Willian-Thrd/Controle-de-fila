package org.will;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class trueFalse {
    @FXML
    protected TextField EnderecoCliente;
    @FXML
    protected TextField TelCliente;
    @FXML
    private ComboBox<String> box, tipoRetirada;

    public void trueFalse(Boolean checker, Boolean mouseTransparent) {
        EnderecoCliente.setEditable(checker);
        TelCliente.setEditable(checker);
        box.setFocusTraversable(checker);
        box.setMouseTransparent(mouseTransparent);
        tipoRetirada.setFocusTraversable(mouseTransparent);
        tipoRetirada.setMouseTransparent(checker);
    }
}
